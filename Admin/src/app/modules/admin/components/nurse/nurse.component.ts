import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DeletePopupComponent } from '../delete-popup/delete-popup.component';
import { DialogPopComponent } from '../dialog-pop/dialog-pop.component';


export interface Availability {
  id: number;
  name1: string;
  from: number;
  till: number;
}


const PHY_DATES: Availability[] = [
  { id: 1, name1: 'Akshay', from: 1.0079, till: 12254 },
  { id: 2, name1: 'Helium', from: 11 / 11 / 2001, till: 12254 },
  { id: 3, name1: 'Lithium', from: 6.941, till: 12254 },
  { id: 4, name1: 'Beryllium', from: 9.0122, till: 12254 },
  { id: 5, name1: 'Boron', from: 10.811, till: 12254 },
  { id: 6, name1: 'Carbon', from: 12.0107, till: 12254 },
  { id: 7, name1: 'Nitrogen', from: 14.0067, till: 12254 },
  { id: 8, name1: 'Oxygen', from: 15.9994, till: 12254 },
  { id: 9, name1: 'Fluorine', from: 18.9984, till: 12254 },
  { id: 10, name1: 'Neon', from: 20.1797, till: 12254 },
  { id: 11, name1: 'Sodium', from: 22.9897, till: 12254 },
  { id: 12, name1: 'Magnesium', from: 24.305, till: 12254 },
  { id: 13, name1: 'Aluminum', from: 26.9815, till: 12254 },
  { id: 14, name1: 'Silicon', from: 28.0855, till: 12254 },
  { id: 15, name1: 'Phosphorus', from: 30.9738, till: 12254 },
  { id: 16, name1: 'Sulfur', from: 32.065, till: 12254 },
  { id: 17, name1: 'Chlorine', from: 35.453, till: 12254 },
  { id: 18, name1: 'Argon', from: 39.948, till: 12254 },
  { id: 19, name1: 'Potassium', from: 39.0983, till: 12254 },
  { id: 20, name1: 'Calcium', from: 40.078, till: 12254 },
];
@Component({
  selector: 'app-nurse',
  templateUrl: './nurse.component.html',
  styleUrls: ['./nurse.component.css']
})
export class NurseComponent {
  displayedColumns: string[] = ['id', 'name1', 'from', 'till', 'actions', 'delete'];
  dataSource = new MatTableDataSource<Availability>(PHY_DATES);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private matDialog: MatDialog) { }

  openDialog() {
    this.matDialog.open(DialogPopComponent, {
      width: '600px',
    })
  }

  deleteDialog() {
    this.matDialog.open(DeletePopupComponent, {
      width: '400px'
    })
  }



  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
