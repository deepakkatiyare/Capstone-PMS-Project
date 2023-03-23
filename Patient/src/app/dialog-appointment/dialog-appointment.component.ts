import { CustomDatePipePipe } from './../custom-date-pipe.pipe';
import { BookappointmentComponent } from './../bookappointment/bookappointment.component';
import { AppointmentServiceService } from './../appointment-service.service';
import { Component, Inject, PipeTransform } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Appointment } from '../appointment';


import { MatDialogRef,MAT_DIALOG_DATA, } from '@angular/material/dialog';


@Component({
  selector: 'app-dialog-appointment',
  templateUrl: './dialog-appointment.component.html',
  styleUrls: ['./dialog-appointment.component.css']
})
export class DialogAppointmentComponent {
  hide=true;


  constructor(private appointmentService: AppointmentServiceService, private router: Router, private appointment: Appointment,private dialogRef: MatDialogRef<BookappointmentComponent>,@Inject(MAT_DIALOG_DATA) public data: BookappointmentComponent) {
  }
  onSubmit(value: any): void {
    this.appointment.id;
    this.appointment.acceptance = "pending";
    this.appointment.date = new CustomDatePipePipe('en-us').transform(value.date,'dd-MMM-yyyy');
    this.appointment.reason = value.reason;
    this.appointment.physcianEmail =this.data.dataEmail;
    console.log(this.data.dataEmail);
    this.appointment.patientId;
    this.appointment.submissionDate =new CustomDatePipePipe('en-us').transform(new Date(),'dd-MMM-yyyy');
    console.log(this.appointment);
    this.appointmentService.appointments(this.appointment).subscribe(result => {
      console.log(result);
      this.gotoPrevious();
    });
  }
  gotoPrevious() {
    this.closeDialog();
    this.router.navigate(['/bookappointment']);
  }
  closeDialog(){
    this.dialogRef.close();
  }
}

