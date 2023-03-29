import { ProfileComponent } from './../profile/profile.component';
import { UpdateService } from './../update.service';
import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Patient } from '../Patient';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {
  email = new FormControl('', [Validators.required, Validators.email]);
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'you must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  hide = true;
  patient:Patient=new Patient();
  constructor(private updateservice:UpdateService,private router: Router,private dialogRef: MatDialogRef<ProfileComponent>,private _snackBar: MatSnackBar){}
  onSubmit(value:any){
    this.patient.firstName=value.firstname;
    this.patient.lastName=value.lastname;
    this.patient.address=value.address;
    this.patient.contactNumber=value.contact;
    this.patient.email=value.email;
    this.patient.patientId=parseInt(sessionStorage.getItem("PatientId")!,10)
    this.updateservice.updatePatient(this.patient.patientId,this.patient).subscribe(result => {
      console.log(result);
      this.dialogRef.close();
      this.router.navigate(['/profile']);
      this._snackBar.open("Updated Successfully","",{duration: 2000});
    });
  }

}
