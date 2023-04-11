import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Patient } from 'src/app/model_classes/Patient';
import { CustomDatePipePipe } from 'src/app/patient_service/custom-date-pipe.pipe';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';
import { PatientRegisterService } from 'src/app/services/patient-register.service';
import { RegisterDialogComponent } from '../dialog-pop/dialog-pop.component';
import { MatDialog } from '@angular/material/dialog';
import { animate, style, transition, trigger } from '@angular/animations';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-patient-regi',
  templateUrl: './patient-regi.component.html',
  styleUrls: ['./patient-regi.component.css'],
  animations: [
    trigger('fadein', [
      transition('void => *', [
        style({ opacity: 0 }),
        animate(1000, style({ opacity: 1 }))
      ])
    ])
  ]
})
export class PatientRegiComponent {
  private patient: Patient;
  myForm: any;
  submitted = false;
  hide = true;
  hide0 = true;
  currentDate!: Date;
  check = false;
  patients: Patient[] = [];
  constructor(private formBuilder: FormBuilder, private matDialog: MatDialog, private _snackBar: MatSnackBar, private patientInfo: PatientBasicInfoService, private patientRegister: PatientRegisterService, private router: Router) {
    this.patient = new Patient();
  }
  ngOnInit() {
    // this.currentDate = new DatePipe('en-us');
    this.currentDate = new Date();
    this.myForm = new FormGroup({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      contactNumber: new FormControl('', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[6789][0-9]{9}$")]),
      dob: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      confirmpassword: new FormControl('', [Validators.required]),
      title: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
    }
    );

    this.patientInfo.getPatients().subscribe(data => {
      this.patients = data;
    });
  }
  matchPassword(formGroup: FormGroup) {
    const { value: password } = formGroup.value.password;
    const { value: confirmpassword } = formGroup.value.confirmpassword;
    return password === confirmpassword ? null : { passwordNotMatch: true };
  }
  // mustMatch(controlName: string, matchingControlName: string) {
  //   return (formGroup: FormGroup) => {
  //     const control = formGroup.controls[controlName];
  //     const matchingControl = formGroup.controls[matchingControlName];
  //     if (matchingControl.errors && !matchingControl.errors['mustMatch']) {
  //       return
  //     }
  //     if (control.value !== matchingControl.value) {
  //       matchingControl.setErrors({ mustMatch: true })
  //     }
  //     else {
  //       matchingControl.setErrors(null);
  //     }
  //   }
  // }
  public get register() {
    return this.myForm.controls;
  }
  onSubmit(): void {
    this.submitted = true;
    console.log(this.patients);
    console.log(this.myForm.value);
    if (this.myForm.valid) {
      if (this.patients.length != 0) {
        for (var p of this.patients) {
          console.log(this.myForm.value.email + " " + p.email)
          if (p.email == this.myForm.value.email) {
            this.check = true;
            break;
          }
        }
        if (this.check) {
          this.openSnackBar();
          this.check = false;
        }
        else {
          console.log("registered")
          //register
          this.myForm.value.dob = new CustomDatePipePipe('en-us').transform(this.myForm.value.dob, 'dd-MMM-yyyy');
          console.log("post registration")
          this.patient = this.myForm.value;
          console.log(this.patient)
          this.patientRegister.registerPatient(this.patient).subscribe((result) => {
            if (result != null) {
              console.log("dddddddddddddddddd");
              console.log(result);
              this.patients.push(result);
              this.registerDialog();

            }
          });
        }
      }
      else {
        console.log("register");
        //register
        this.myForm.value.dob = new CustomDatePipePipe('en-us').transform(this.myForm.value.dob, 'dd-MMM-yyyy');
        console.log("post registration")
        this.patient = this.myForm.value;
        this.patientRegister.registerPatient(this.patient).subscribe((result) => {
          if (result != null) {
            console.log("sddddddddddddddd")
            console.log(result);
            this.patients.push(result);
            this.registerDialog();
          }
        });
      }
    }
    else {
      console.log("form not valid");
    }

  }
  gotoUserList() {
    this.router.navigate(['login']);
  }
  registerDialog() {
    const dialog = this.matDialog.open(RegisterDialogComponent, {
      width: '300px',
      data: {
        value: "Successfully Registered!"
      }
    })
    dialog.afterClosed().subscribe(result => {
      this.router.navigateByUrl('/login')
    })
  }
  openSnackBar() {
    this._snackBar.open('Please choose another email', 'Close', {
      duration: 3000
    });

  }
}
