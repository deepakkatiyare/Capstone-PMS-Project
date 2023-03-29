import { AppService } from './../AppService';
import { LoginComponent } from './../login/login.component';
import { ProfileComponent } from './../profile/profile.component';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PatientRegisterService } from '../patient-register.service';
import { Patient } from '../Patient';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent {
  hide = true;
  formData!: FormGroup;
  showError:boolean=false;
  email = new FormControl('', [Validators.required, Validators.email]);
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'you must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  patient:Patient[]=[];
  constructor(private dialogRef: MatDialogRef<LoginComponent>,private getPatients:PatientRegisterService,private appservice:AppService) {}
  // ngOnInit(): void {
  //   this.getPatients.getPatients().subscribe(result => {
  //     this.patient=result;
  //   });
  // }

  onSubmit(value:any):void{
    this.getPatients.getPatients().subscribe(result => {
          this.patient=result;
        });
    
    for(let p of this.patient){
      if(p.email==value.email){
        this.appservice.getPatientByEmail(value.email,value.password).subscribe(result => {
          console.log(result);
          this.closeDialog();
        });
      }
    }
  }
  closeDialog(): void {
    this.dialogRef.close();
  }
}
