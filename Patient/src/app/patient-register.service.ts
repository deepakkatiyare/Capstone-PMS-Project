import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientRegisterService {

  private registerUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'http://localhost:9004/api/v1/patient/register';

  }

  public loginPatient(): Observable<Patient> {
    return this.http.get<Patient>(this.registerUrl);
  }

  public registerPatient(patient: Patient) {
    console.log(patient);
    return this.http.post<Patient>(this.registerUrl, patient);
  }
}
