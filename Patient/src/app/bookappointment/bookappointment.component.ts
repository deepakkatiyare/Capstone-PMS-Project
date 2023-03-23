import { Physician } from './../physician';
import { DisplayDoctorsService } from './../display-doctors.service';
import { DialogAppointmentComponent } from './../dialog-appointment/dialog-appointment.component';
import { Component,OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FormControl } from '@angular/forms';



@Component({
  selector: 'app-bookappointment',
  templateUrl: './bookappointment.component.html',
  styleUrls: ['./bookappointment.component.css']
})
export class BookappointmentComponent implements OnInit{
  physician: Physician[] = [];
  dataEmail: string="";
  constructor(private dialog:MatDialog,private physicianService:DisplayDoctorsService){

  }
ngOnInit(){
  this.physicianService.findPhysician().subscribe(data =>{
    this.physician=data;
  });
  
}
  openDialog(value:any){
    console.log(value);
    this.dialog.open(DialogAppointmentComponent,{data:{dataEmail:value}});
  }

}
