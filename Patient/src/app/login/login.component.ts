import { HttpClient } from '@angular/common/http';
import { Component ,EventEmitter, OnInit, Output} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../Patient';
import { PatientRegisterService } from '../patient-register.service';
import {LoginService} from '../login.service';

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
  constructor(private patientRegister: PatientRegisterService,private loginservice:LoginService,private patient:Patient,private router: Router){}
  ngOnInit(){
    this.patientRegister.getPatients().subscribe(data =>{
      this.patients=data;
    });
  }
  hide = true;
  onSubmit(value: any): void {
    for(var p of this.patients){
      if(p.email==value.email && p.password==value.password){
        this.router.navigate(['/patient-home']);
        break;
      }
      else{
        this.showError=true;
      }
    }
  }
  
}
