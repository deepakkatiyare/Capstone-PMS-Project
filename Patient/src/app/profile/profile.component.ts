import { ResetpasswordComponent } from './../resetpassword/resetpassword.component';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Patient } from '../Patient';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  currEmail:string | null="";
  currPassword:string | null="";
  constructor(private loginservice:LoginService,public patient:Patient) {}
   ngOnInit() {
    this.currEmail=sessionStorage.getItem("email");
    this.currPassword=sessionStorage.getItem("password");
    this.loginservice.loginPatient(this.currEmail!,this.currPassword!).subscribe(data =>{
      this.patient=data;
    });
   }


  
}
