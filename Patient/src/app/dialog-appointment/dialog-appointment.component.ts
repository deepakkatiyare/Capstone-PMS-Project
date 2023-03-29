import { CustomDatePipePipe } from './../custom-date-pipe.pipe';
import { BookappointmentComponent } from './../bookappointment/bookappointment.component';
import { AppointmentServiceService } from './../appointment-service.service';
import { Component, Inject, PipeTransform, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Appointment } from '../appointment';
import {MatSnackBar} from '@angular/material/snack-bar';


import { MatDialogRef,MAT_DIALOG_DATA, } from '@angular/material/dialog';
import { LoginService } from '../login.service';
import { Patient } from '../Patient';


@Component({
  selector: 'app-dialog-appointment',
  templateUrl: './dialog-appointment.component.html',
  styleUrls: ['./dialog-appointment.component.css']
})
export class DialogAppointmentComponent implements OnInit{
  hide=true;
  minDate:Date;
  maxDate:Date;
  currPatientId:number=0;

  constructor(private appointmentService: AppointmentServiceService, private router: Router, private appointment: Appointment,private loginservice:LoginService,public patient:Patient,private dialogRef: MatDialogRef<BookappointmentComponent>,@Inject(MAT_DIALOG_DATA) public data: BookappointmentComponent,private _snackBar: MatSnackBar) {
    this.minDate=new Date(this.data.dataStartDate);
    this.maxDate=new Date(this.data.dataEndDate);
  }
  ngOnInit() {
    this.currPatientId=parseInt(sessionStorage.getItem("PatientId")!,10);
  }
  onSubmit(value: any): void {
    if(value.date!=null && value.reason!=""){
      this.appointment.acceptance = "pending";
      this.appointment.date = new CustomDatePipePipe('en-us').transform(value.date,'dd-MMM-yyyy');
      this.appointment.reason = value.reason;
      this.appointment.physcianEmail =this.data.dataEmail;
      this.appointment.patientId=this.currPatientId;
      this.appointment.submissionDate =new CustomDatePipePipe('en-us').transform(new Date(),'dd-MMM-yyyy');
      this.appointmentService.appointments(this.appointment).subscribe(result => {
      console.log(result);
      this.gotoPrevious();
    });
    }
    
  }
  gotoPrevious() {
    this.closeDialog();
    this.router.navigate(['/bookappointment']);
  }
  closeDialog(){
    this.dialogRef.close();
    this._snackBar.open("Appointment Booked Successfully","",{duration: 2000});
  }
}

