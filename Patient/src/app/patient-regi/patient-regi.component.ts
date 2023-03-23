import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Patient } from '../Patient';
import { PatientRegisterService } from '../patient-register.service';


@Component({
  selector: 'app-patient-regi',
  templateUrl: './patient-regi.component.html',
  styleUrls: ['./patient-regi.component.css']
})
export class PatientRegiComponent {


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

  onSubmit(value: any): void {
    this.patient.title = value.title;
    this.patient.firstName = value.firstName;
    this.patient.lastName = value.lastName;
    this.patient.email = value.email;
    this.patient.contactNumber = value.contact;
    this.patient.dob = value.dob;
    this.patient.gender = value.gender;
    this.patient.password = value.password;
    this.patient.address = value.address;
    this.patientRegister.registerPatient(this.patient).subscribe(result => {
      console.log(result);
      this.gotoUserList()
    });
  }
  gotoUserList() {
    this.router.navigate(['/patient-home']);
  }
}
