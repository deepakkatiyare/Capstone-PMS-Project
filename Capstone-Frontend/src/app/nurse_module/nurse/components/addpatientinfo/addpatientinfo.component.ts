import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldControl } from '@angular/material/form-field';
import { Patient } from 'src/app/model_classes/Patient';
import { PatientInfoDetails } from 'src/app/model_classes/visit_details';
import { AppsubService } from 'src/app/services/appsub.service';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';
import { PrevioushistoryComponent } from '../previoushistory/previoushistory.component';
import { SubmitDialogComponent } from '../submit-dialog/submit-dialog.component';
import { AllergyService } from 'src/app/services/allergy.service';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Allergy } from 'src/app/model_classes/allergy';

@Component({
  selector: 'app-addpatientinfo',
  templateUrl: './addpatientinfo.component.html',
  styleUrls: ['./addpatientinfo.component.css']
})
export class AddpatientinfoComponent {
  public myForm!: FormGroup;
  constructor(
    public dialog: MatDialog,
    public patientService: PatientBasicInfoService,
    private shared: AppsubService,
    private allergyService: AllergyService
  ) { }
  // constructor(public patientData : AppointmentService){}

  selectedItem: any;
  nurseEmail = sessionStorage.getItem("NURSE_EMAIL");
  // toppings = new FormControl('');

  // console.log();

  toppingList: string[] = [
    'Skin Allergy',
    'Eye Allergy',
    'Nose Allergy',
    'Food Allergy',
    'Dust Allergy',
    'Dust Allergy',
    'Dust Allergy',
    'Dust Allergy',
  ];

  openDialog() {
    const dialogRef = this.dialog.open(PrevioushistoryComponent, {
      width: '80%',
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
  appointmentAppointmentsId: any;
  phys: any;
  patientData: any;
  patient!: Patient;

  allergyData: Allergy[] = [];
  allergyIds: Allergy[] = [];
  toppings = new FormControl();
  selectedToppings: [] = [];
  ailment: any;
  ngOnInit(): void {
    this.patientData = sessionStorage.getItem('arraydata');
    this.ailment = sessionStorage.getItem('ailment');
    this.patientService.getpatientdetails(this.patientData).subscribe((data) => {
      this.patient = data;
    });
    this.appointmentAppointmentsId = sessionStorage.getItem('appId');
    this.phys = sessionStorage.getItem('physicianEmail');
    this.myForm = new FormGroup({
      heightt: new FormControl('', [Validators.required]),
      bpSystolic: new FormControl('', [Validators.required]),
      weightt: new FormControl('', [Validators.required]),
      bpDiastolic: new FormControl('', [Validators.required]),
      respirationRate: new FormControl('', [Validators.required]),
      bodyTemperature: new FormControl('', [Validators.required]),
      allergies: new FormControl('', [Validators.required]),
      sugar: new FormControl('', [Validators.required]),
      somethingData: new FormControl('', [Validators.required]),
    });

    this.allergyService.getAllergies().subscribe((data: any) => {
      this.allergyData = data;
    });
  }


  public get visits() {
    return this.myForm.controls;
  }
  patientDetails: PatientInfoDetails = new PatientInfoDetails();
  patientDataa: PatientInfoDetails = new PatientInfoDetails();
  onSubmitt() {
    if (this.myForm.valid) {
      this.patientDetails.allergyId = '1';
      this.patientDetails.bloodGroup = 'O+';
      this.patientDetails.nurseEmail = this.nurseEmail;
      this.patientDetails.height = this.myForm.value.heightt;
      this.patientDetails.weight = this.myForm.value.weightt;
      this.patientDetails.bpSystolic = this.myForm.value.bpSystolic;
      this.patientDetails.bpDiastolic = this.myForm.value.bpDiastolic;
      this.patientDetails.bodyTemparature = this.myForm.value.bodyTemperature;
      this.patientDetails.respirationRate = this.myForm.value.respirationRate;
      this.patientDetails.physicianEmail = this.phys;
      this.patientDetails.appointmentId = this.appointmentAppointmentsId;
      this.patientDetails.keyNotes = this.myForm.value.somethingData;



      this.selectedToppings = this.myForm.value

      for (let j = 0; j < this.selectedToppings.length; j++) {
        for (let i = 0; i < this.allergyData.length; i++) {
          if (this.selectedToppings[j] == this.allergyData[i].allergyName) {
            this.allergyIds[j] = this.allergyData[i].allergyId;
          }
        }
      }

      this.dialog.open(SubmitDialogComponent, {
        width: '500px',
        data: {
          submitPatienttDetails: this.patientDetails,
          patientInfoId: this.patientData,
          appointmentId: this.appointmentAppointmentsId
        },
      });
    }
  }
}
