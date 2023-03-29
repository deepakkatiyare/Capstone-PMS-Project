import { LoginService } from './../login.service';
import { AppService } from './../AppService';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../Patient';

@Component({
  selector: 'app-patienthome',
  templateUrl: './patienthome.component.html',
  styleUrls: ['./patienthome.component.css']
})
export class PatienthomeComponent  implements OnInit{
  currPatientId:number=0;
  constructor(private loginservice:LoginService,public patient:Patient) {}
   ngOnInit() {
    this.currPatientId=parseInt(sessionStorage.getItem("PatientId")!,10);
    this.loginservice.getPatient(this.currPatientId).subscribe(data =>{
      this.patient=data;
    });
   }
    
}
