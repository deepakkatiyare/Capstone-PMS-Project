import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Allergy } from '../model_classes/allergy';

@Injectable({
  providedIn: 'root'
})
export class AllergyService {
  allergy: string;
  allergyById: string;
  appointmentEvent: any;
  constructor(public http: HttpClient) {
    this.allergy = "a1babe5c5496d4464806264dd7d66802-637222683.us-west-2.elb.amazonaws.com:9002/api/v1/allergy ";
    this.allergyById = "a1babe5c5496d4464806264dd7d66802-637222683.us-west-2.elb.amazonaws.com:9002/api/v1/allergy "
  }
  public getAllergies(): Observable<Allergy[]> {
    return this.http.get<Allergy[]>(this.allergy);
  }

  public getAllergyById(id: any): Observable<Allergy> {
    return this.http.get<Allergy>(this.allergyById + "/" + { id });
  }
  public getAppointmentEvent() {
    return this.appointmentEvent;
  }
  public setAppointmentEvent(event: any) {
    this.appointmentEvent = event;
  }
}
