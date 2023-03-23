import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class Appointment {
    id:number=0;
    acceptance:string="pending";
    date:string="";
    reason:string="";
    physcianEmail:string="";
    patientId:number=0;
    submissionDate:string="";
}
