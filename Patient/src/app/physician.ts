import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class Physician {
    physicianEmail:string="";
    availability:string="";
    date:string="";
}
