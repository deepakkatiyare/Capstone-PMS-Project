import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {

  constructor(private http: HttpClient) {     
  }
  public updatePatient(patientId:number,patient:Patient):Observable<Patient>{
    console.log(patient);
    return this.http.put<Patient>('http://localhost:9002/api/v1/patient'+patientId,patient);
  }
}
