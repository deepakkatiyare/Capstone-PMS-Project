import { ProfileComponent } from './../profile/profile.component';
import { DialogAppointmentComponent } from './../dialog-appointment/dialog-appointment.component';
import { ResetpasswordComponent } from './../resetpassword/resetpassword.component';
import { MatDialog } from '@angular/material/dialog';
import { Component ,EventEmitter, OnInit, Output} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../Patient';
import { PatientRegisterService } from '../patient-register.service';
import {LoginService} from '../login.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  formData!: FormGroup;
  showError:boolean=false;
  email = new FormControl('', [Validators.required, Validators.email]);
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'you must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  patients:Patient[]=[];
  private patient:Patient=new Patient();
  constructor(private patientRegister: PatientRegisterService,private loginservice:LoginService,private router: Router,private _snackBar: MatSnackBar,private dialog:MatDialog){}
  ngOnInit(){
    this.patientRegister.getPatients().subscribe(data =>{
      this.patients=data;
    });
  }
  openDialog3(){
    this.dialog.open(ResetpasswordComponent);
    this.router.navigate(['/login']);
  }
  flag:boolean=false;
  hide = true;
  currEmail:string="";
  currPassword:string="";
  onSubmit(value: any): void {
    if(this.loginservice.loginPatient(value.email,value.password)){
      this.loginservice.loginPatient(value.email,value.password).subscribe(data =>{
        this.patient=data;
        this.flag=true;
        this.router.navigate(['/patient-home']);
        sessionStorage.setItem("PatientId",this.patient.patientId.toString());
        if(this.flag==true){
          this._snackBar.open("Logged in Successfully","",{duration: 2000});
        }
      });
      
    }
    else{
      this.showError=true;
    }  
  }
  
}
