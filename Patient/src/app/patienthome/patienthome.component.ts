import { Component, OnInit } from '@angular/core';
import { Patient } from '../Patient';
import { PatientRegisterService } from '../patient-register.service';

@Component({
  selector: 'app-patienthome',
  templateUrl: './patienthome.component.html',
  styleUrls: ['./patienthome.component.css']
})
export class PatienthomeComponent implements OnInit {
  constructor(public patientService: PatientRegisterService, public patient: Patient) { }
  ngOnInit(): void {
    this.patientService.loginPatient().subscribe(data => { this.patient = data,this.patient=data });
  }

}
