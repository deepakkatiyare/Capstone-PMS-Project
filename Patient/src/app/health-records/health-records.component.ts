import { PrescriptionComponent } from './prescription/prescription.component';
import { TestdetailsComponent } from './../testdetails/testdetails.component';
import { MatPaginator } from '@angular/material/paginator';
import { Component,ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';

// export interface Appointments {
//   aid: string;
//   adate: string;
//   reason: string;
//   acceptance: string;
//   doctor:string;
// }
// const ELEMENT_DATA: Appointments [] = [
//   {aid: 'A001', adate: '19-03-2023' ,doctor:'krishna',reason: 'fever', acceptance:'accepted'},
//   {aid: 'A003', adate: '20-03-2023' ,doctor:'krishna',reason: 'pain', acceptance:'accepted'},
//   {aid: 'A004', adate: '21-03-2023' ,doctor:'krishna',reason: 'headache', acceptance:'accepted'},
//   {aid: 'A005', adate: '22-03-2023' ,doctor:'krishna',reason: 'cold', acceptance:'accepted'},
// ];
@Component({
  selector: 'app-health-records',
  templateUrl: './health-records.component.html',
  styleUrls: ['./health-records.component.css']
})
export class HealthRecordsComponent {
  // displayedColumns: string[] = ['demo-aid', 'demo-adate', 'demo-reason','demo-doctor', 'demo-acceptance',"demo-info"];
  // dataSource =new MatTableDataSource<Appointments>(ELEMENT_DATA);
  // @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;

  // ngAfterViewInit() {
  //   this.dataSource.paginator = this.paginator;
  // }
  longtext= "dfdsfivdjkjiajkxnbdsvgyuwijklaxnbvgu";

  constructor(public dialog: MatDialog) {}

  openDialog() {
    const dialogRef = this.dialog.open(TestdetailsComponent);
  }

  openDialog1() {
    const dialogRef = this.dialog.open(PrescriptionComponent);
  }
}
