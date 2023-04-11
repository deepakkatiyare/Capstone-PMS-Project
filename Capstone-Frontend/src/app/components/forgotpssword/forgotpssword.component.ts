import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';
import { PatientRegisterService } from 'src/app/services/patient-register.service';

@Component({
  selector: 'app-forgotpssword',
  templateUrl: './forgotpssword.component.html',
  styleUrls: ['./forgotpssword.component.css'],
  animations: [
    trigger('fadein', [
      transition('void => *', [
        style({ opacity: 0 }),
        animate(1000, style({ opacity: 1 }))
      ])
    ])
  ]
})
export class ForgotpasswordComponent implements OnInit {


  email!: string;
  newPassword!: string;
  retypePassword!: string;
  showOTP: boolean = false;
  showNewPassword: boolean = false;
  showIncorrectOTP: boolean = false;
  showPasswordMismatch: boolean = false;
  VerifyEmail: boolean = false;


  emailbutton: boolean = true
  verifybutton: boolean = true

  patiets: any[] = []

  // email:any[]=[]
  hide: boolean = true;
  hide0: boolean = true;
  emailExists: boolean | undefined;
  emailToCheck: any;
  patientemail: any;
  userEmail!: string;
  userOtp!: string;
  randomNum: any
  forgotPassword: any;
  submitted = false;
  otpVerify: any;
  password: any
  constructor(private router: Router, private service: PatientRegisterService, private patients: PatientBasicInfoService) { }

  //  
  ngOnInit(): void {
    this.forgotPassword = new FormGroup({
      userEmail: new FormControl('', [Validators.required, Validators.email])
    });
    this.otpVerify = new FormGroup({
      otp: new FormControl('', Validators.required)
    });
    this.password = new FormGroup({
      newpassword: new FormControl('', [Validators.required]),
      confirmpassword: new FormControl('', Validators.required)
    })
  }
  get forgot() {
    return this.forgotPassword.controls;
  }

  get getOtp() {
    return this.otpVerify.controls;
  }
  get register() {
    return this.password.controls;
  }
  sendOTP() {
    this.submitted = true;
    if (this.forgotPassword.valid) {
      this.patients.getPatients().subscribe((data: any) => {
        this.patiets = data
        this.emailExists = this.patiets.some(user => this.forgotPassword.value.userEmail === user.email)
        if (this.emailExists) {
          this.VerifyEmail = false
          this.showOTP = true;
          const min = 100000; // 6 digit number starting from 100000
          const max = 999999; // 6 digit number ending at 99999
          this.randomNum = Math.floor(Math.random() * (max - min + 1)) + min;

          sessionStorage.setItem("ResetOtp", this.randomNum)
          const emailData = {
            toMail: [this.forgotPassword.value.userEmail],
            subject: 'Forgot password',
            message: 'enter otp to reset password  ' + this.randomNum
          };
          this.service.forgotpassword(emailData).subscribe()
          this.emailbutton = false
        } else {
          this.VerifyEmail = true
        }
      });
    }
  }

  verifyOTP() {
    this.submitted = true;
    if (this.otpVerify.valid) {
      if (sessionStorage.getItem("ResetOtp") === this.otpVerify.value.otp) {
        this.showIncorrectOTP = false;
        this.showNewPassword = true;
        this.showOTP = false
      } else {
        this.showIncorrectOTP = true;
      }
    }
  }

  resetPassword() {
    this.submitted = true;
    if (this.password.valid) {
      console.log(this.password.value.newpassword)
      console.log(this.password.value.confirmpassword);
      if (this.password.value.newpassword === this.password.value.confirmpassword) {
        this.showPasswordMismatch = false;
        this.service.updatePatientPassword(this.forgotPassword.value.userEmail, this.password.value.newpassword).subscribe()
        this.router.navigateByUrl('/login');
      } else {
        this.showPasswordMismatch = true;
      }
    }
  }
}
