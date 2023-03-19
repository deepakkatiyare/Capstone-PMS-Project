import { Component,ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialogRef } from '@angular/material/dialog';
export interface Prescription {
  prid: string;
  medicine: string;
  dosage: string;
  notes: string;
}
const ELEMENT_DATA: Prescription[] = [
  {prid: 'pr001' ,medicine:'Dolo',dosage:'1-1-0' ,notes:'before eat'},
  {prid: 'pr002',medicine:'Dolo',dosage:'1-1-0' ,notes:'before eat'},
  {prid: 'pr003',medicine:'Dolo',dosage:'1-1-0' ,notes:'before eat'},
  {prid: 'pr004',medicine:'Dolo',dosage:'1-1-0' ,notes:'before eat'}
];
@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent {
  displayedColumns: string[] = ['demo-prid', 'demo-medicine', 'demo-dosage', 'demo-notes'];
  dataSource = new MatTableDataSource<Prescription>(ELEMENT_DATA);
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  constructor(private dialogRef: MatDialogRef<PrescriptionComponent>){ }

closeDialog(){
  this.dialogRef.close();
}
}
