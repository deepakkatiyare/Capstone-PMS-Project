import { DialogAppointmentComponent } from './../dialog-appointment/dialog-appointment.component';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-bookappointment',
  templateUrl: './bookappointment.component.html',
  styleUrls: ['./bookappointment.component.css']
})
export class BookappointmentComponent {
  constructor(private dialog:MatDialog){}
  openDialog(){
    this.dialog.open(DialogAppointmentComponent);
  }
}
