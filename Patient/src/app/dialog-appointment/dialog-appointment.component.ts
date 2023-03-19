import { BookappointmentComponent } from '../bookappointment/bookappointment.component';
import { Component,Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-dialog-appointment',
  templateUrl: './dialog-appointment.component.html',
  styleUrls: ['./dialog-appointment.component.css']
})
export class DialogAppointmentComponent {
  hide=true;

  constructor(
    public dialogRef: MatDialogRef<BookappointmentComponent>) {}

  closeDialog(): void {
    this.dialogRef.close();
  }
}
