import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { AppointmentDto } from 'src/app/model_classes/appointment';
import { Patient } from 'src/app/model_classes/Patient';
import { AgePipe } from 'src/app/Pipes/age.pipe';
import { AppointmentService } from 'src/app/services/appointment.service';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';


export class Appointment {

  id: any
  patientId: any
  patientName: any
  patientEmail: any
  date: any;
  age: any;
  gender: any;
  contact: any;
  ailment: any;
}
@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  length: number;
  pageSize = 10;
  pageIndex = 0;
  pageEvent!: PageEvent;

  appointmentArr: Appointment[] = [];
  app: AppointmentDto[] = [];
  patientData: Patient[] = [];
  variable: any;
  dataSource: any;
  particularPatient: any;
  constructor(public patientInfo: PatientBasicInfoService, private appointment: AppointmentService) {
    this.length = 0;
  }

  ngOnInit(): void {
    this.getAcceptanceCount();
    this.getAppointments(this.pageIndex, this.pageSize);
  }
  getAcceptanceCount() {
    this.appointment.getAllAcceptanceAppointmentCount().subscribe(count => {
      this.length = new Number(count).valueOf();
    })
  }

  getAppointments(index: number, size: number) {
    this.appointment.getAppointments(index, size).subscribe((data: AppointmentDto[]) => {
      console.log(data);
      this.app = data;
      for (let i = 0; i < this.app.length; i++) {
        this.patientInfo
          .getpatientdetails(this.app[i].patientId)
          .subscribe((data1: Patient) => {
            this.patientData[i] = data1;
            this.appointmentArr[i] = new Appointment();
            this.appointmentArr[i].id = this.app[i].id;
            this.appointmentArr[i].patientId = this.patientData[i].patientId;
            this.appointmentArr[i].patientName = this.patientData[i].title + " " + this.patientData[i].firstName + " " + this.patientData[i].lastName;
            this.appointmentArr[i].patientEmail = this.patientData[i].email;
            this.appointmentArr[i].date = this.app[i].date;
            this.appointmentArr[i].age = new AgePipe().transform(this.patientData[i].dob);
            this.appointmentArr[i].gender = this.patientData[i].gender;
            this.appointmentArr[i].contact = this.patientData[i].contactNumber;
            this.appointmentArr[i].ailment = this.app[i].reason;
          });
      }
      this.dataSource = new MatTableDataSource<Appointment>(this.appointmentArr);
    });
  }


  id(data: any, appId: any, phyEmail: any, ailment: any) {
    sessionStorage.setItem('arraydata', this.patientData[data].patientId);
    sessionStorage.setItem('appId', appId);
    sessionStorage.setItem('physicianEmail', phyEmail);
    sessionStorage.setItem("ailment", ailment);
    console.log(this.patientData[data].patientId);
    console.log('appointment id is');

    console.log(appId);
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  handlePageEvent(e: PageEvent) {
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    console.log(this.pageIndex + "pagenIndexs");
    this.appointmentArr = [];
    this.getAppointments(this.pageIndex, this.pageSize)
  }
}
