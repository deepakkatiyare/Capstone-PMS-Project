import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class Patient {
    title: string = "";
    firstName: string = "";
    lastName: string = "";
    email: string = "";
    contactNumber: string = "";
    dob: string = "";
    gender: string = "";
    password: string = "";
    address: string = "";

}