import { Component,ViewChild } from '@angular/core';
import {MatAccordion} from '@angular/material/expansion';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  @ViewChild(MatAccordion)
  accordian!:MatAccordion;
  constructor(private _snackBar: MatSnackBar){}
  snackBar(){
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("password");
    this._snackBar.open("LoggedOut","",{duration: 2000});
  }
}
