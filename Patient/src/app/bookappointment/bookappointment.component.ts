import { Physician } from './../physician';
import { DisplayDoctorsService } from './../display-doctors.service';
import { DialogAppointmentComponent } from './../dialog-appointment/dialog-appointment.component';
import { Component,OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-bookappointment',
  templateUrl: './bookappointment.component.html',
  styleUrls: ['./bookappointment.component.css']
})
export class BookappointmentComponent implements OnInit{
  physician: Physician[] = [];
  constructor(private dialog:MatDialog,private physicianService:DisplayDoctorsService){

  }
ngOnInit(){
  this.physicianService.findPhysician().subscribe(data =>{
    this.physician=data;
  });

}
  openDialog(){
    this.dialog.open(DialogAppointmentComponent);
  }
}
