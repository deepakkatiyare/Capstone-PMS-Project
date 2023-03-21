import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientRegisterService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8080/api/v1/patient/login';
  }

  public loginPatient(): Observable<Patient> {
    return this.http.get<Patient>(this.loginUrl);
  }
}
