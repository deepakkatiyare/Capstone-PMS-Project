import { Component, ViewChild } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';
import { PatientHealthRecordService } from 'src/app/services/patient-health-record.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { TestDetails } from 'src/app/model_classes/test';
import { PrescriptionDetails } from 'src/app/model_classes/prescription';
import { PatientInfoDetails } from 'src/app/model_classes/visit_details';
@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.component.html',
  styleUrls: ['./viewdetails.component.css']
})
export class ViewdetailsComponent {
  showContent = false;
  prescription: any


  testDetails: TestDetails[][] = [];
  prescriptionDetails: PrescriptionDetails[][] = [];
  @ViewChild(MatPaginator) paginator: MatPaginator[] = [];
  displayedColumnsPrescription: string[] = ['progress', 'name', 'fruit'];
  displayedColumnsTest: string[] = ['progress', 'name', 'fruit'];
  dataSourceTest: any[] = [];
  dataSourcePrescription: any[] = [];


  @ViewChild(MatSort) sort!: MatSort;

  toggleContent() {
    this.showContent = !this.showContent;
  }
  panelOpenState = false;
  status: String = "completed";
  id: any
  // let resp1=this.service.getAppointments(this.email,transformdate,this.status);
  // resp1.subscribe((data: any)=>this.patientdetails=data);
  patientdetail: any
  patientVisitdetail!: PatientInfoDetails;
  Vistdetails: any
  prescriptions: any[] = [];
  PatientsTests: any[] = [];
  appointmentsHistory: any = []
  visitID: any
  healthRecordService!: PatientHealthRecordService;
  patientHistoryVisitdetail: any[] = []
  HistoryvisitId: any
  bloodgroup: any
  lastConsultationDate: any
  lastPhysicianEmail: any
  keyNotes: any;
  constructor(

    private patientdetails: PatientBasicInfoService,
    private healthRecord: PatientHealthRecordService,
    private appointment: AppointmentService
  ) { }
  ngOnInit(): void {
    const pId = sessionStorage.getItem('Pid')
    const Aid = sessionStorage.getItem('AppointmentId')
    const details = this.patientdetails.getpatientdetails(pId)
    details.subscribe((data) => this.patientdetail = data)
    const Vistdetails = this.healthRecord.getVisitDetails(Aid);
    Vistdetails.subscribe((data) => {
      this.patientVisitdetail = data
      console.log("xxxxxxxxxxxxxxxxxxxxxxxx");
      console.log(this.patientVisitdetail);
      this.visitID = this.patientVisitdetail.visitId;
      sessionStorage.setItem("VisitId", this.patientVisitdetail.visitId)
    })

    const appointmentHistory = this.appointment.getAppointmentByStatusAndId(pId, this.status, 0, 20)
    appointmentHistory.subscribe((data) => {
      this.appointmentsHistory = data;

      for (let i = 0; i < this.appointmentsHistory.length; i++) {

        if (i == 0) {
          this.lastConsultationDate = this.appointmentsHistory[i].date;
        }
        const Vistdetails = this.healthRecord.getVisitDetails(this.appointmentsHistory[i].id);
        Vistdetails.subscribe((data) => {
          this.patientHistoryVisitdetail[i] = data
          if (i == 0) {
            this.keyNotes = data.keyNotes;
            this.lastPhysicianEmail = data.physicianEmail;
            this.bloodgroup = data.bloodGroup;
          }
          this.HistoryvisitId = this.patientHistoryVisitdetail[i].visitId;
          this.healthRecord.getPrescription(this.HistoryvisitId).subscribe((data) => {
            this.prescriptions[i] = data
            this.dataSourcePrescription[i] = new MatTableDataSource<PrescriptionDetails>(data);
            this.dataSourcePrescription[i].paginator = this.paginator[i];

          });
          this.healthRecord.getTests(this.HistoryvisitId).subscribe((data) => {
            this.PatientsTests[i] = data
            this.dataSourceTest[i] = new MatTableDataSource<TestDetails>(data);
            this.dataSourceTest[i].paginator = this.paginator[i];
          });
        });


      }
    })
  }


  medicines: any[] = [];
  newMedicine: any = { prescriptionName: '', dosage: '', prescriptionNotes: '', visitId: '' };

  addMedicine() {
    this.newMedicine.visitId = this.patientVisitdetail;
    this.medicines.push(this.newMedicine);
    this.newMedicine = { prescriptionName: '', dosage: '', prescriptionNotes: '' };
  }

  removeMedicine(medicine: any) {
    this.medicines = this.medicines.filter(m => m !== medicine);
  }

  Tests: any[] = [];
  newTest: any = { testName: '', testNotes: '', result: '', visitId: '' };

  addTest() {
    this.newTest.visitId = this.patientVisitdetail;
    this.Tests.push(this.newTest);
    this.newTest = { testName: '', testNotes: '', result: '' };
  }

  removeTest(test: any) {
    this.Tests = this.Tests.filter(m => m !== test);
  }

  submitTestAndPrescription(id: any, testss: any, value: any) {
    this.appointment.updateStatusById(sessionStorage.getItem('AppointmentId'), "completed").subscribe();
    testss.visitId = this.patientVisitdetail;
    this.Tests.push(testss);
    console.log("Deepak");
    console.log(this.Tests);
    this.healthRecord.postTest(this.Tests).subscribe();
    this.removeTest(testss);
    this.Tests = [];
    this.newTest = { testName: '', testNotes: '', result: '' };



    this.newMedicine.visitId = this.patientVisitdetail;
    this.medicines.push(value);
    console.log("katiyare");
    console.log(this.medicines);
    this.healthRecord.postPrescription(this.medicines).subscribe()
    this.removeMedicine(value);
    this.medicines = [];
    this.newMedicine = { prescriptionName: '', dosage: '', prescriptionNotes: '', visitId: '' };
    console.log("abc");
    this.ngOnInit()
  }
}
