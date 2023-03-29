import { UpdateProfileComponent } from './../update-profile/update-profile.component';
import { ResetpasswordComponent } from './../resetpassword/resetpassword.component';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Patient } from '../Patient';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  currPatientId:number=0;;
  constructor(private loginservice:LoginService,public patient:Patient,private dialog:MatDialog) {}
   ngOnInit() {
    this.currPatientId=parseInt(sessionStorage.getItem("PatientId")!,10);
  
    this.loginservice.getPatient(this.currPatientId).subscribe(data =>{
      this.patient=data;
    });
   }
   openDialogBox(){
    this.dialog.open(UpdateProfileComponent)
   }

  
}
