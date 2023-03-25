import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { CustomDatePipePipe } from '../custom-date-pipe.pipe';
import { Patient } from '../Patient';
import { PatientRegisterService } from '../patient-register.service';


@Component({
  selector: 'app-patient-regi',
  templateUrl: './patient-regi.component.html',
  styleUrls: ['./patient-regi.component.css']
})
export class PatientRegiComponent {
  showError:boolean=false;
  passwordError:boolean=false;
  constructor(private patientRegister: PatientRegisterService, private router: Router, private patient: Patient) {
  }

  email = new FormControl('', [Validators.required, Validators.email]);
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'you must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  hide = true;
  patients:Patient[]=[];
  ngOnInit(){
    this.patientRegister.getPatients().subscribe(data =>{
      this.patients=data;
    });
  }
  onSubmit(value: any): void {
    this.patient.title = value.title;
    this.patient.firstName = value.firstName;
    this.patient.lastName = value.lastName;
    for(var p of this.patients){
      if(p.email==value.email){
        this.showError=true;
      }
    }
    this.patient.email = value.email;
    this.patient.contactNumber = value.contact;
    this.patient.dob = new CustomDatePipePipe('en-us').transform(value.dob,'dd-MMM-yyyy');
    this.patient.gender = value.gender;
    if(value.password!=value.ConfirmPassword){
      this.passwordError=true;
    }
    this.patient.password = value.password;
    this.patient.address = value.address;
    if(!this.showError){
    this.patientRegister.registerPatient(this.patient).subscribe(result => {
      console.log(result);
      this.gotoUserList()
    });
  }
  }
  gotoUserList() {
    
      this.router.navigate(['/login']);
    
  }
}

