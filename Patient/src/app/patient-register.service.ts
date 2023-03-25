import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientRegisterService {

  private registerUrl: string;
  private getPatientsUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'http://localhost:9004/api/v1/patient/register';
    this.getPatientsUrl='http://localhost:9002/api/v1/patient';

  }

  public getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.getPatientsUrl);
  }

  public registerPatient(patient: Patient) {
    console.log(patient);
    return this.http.post<Patient>(this.registerUrl, patient);
  }
}
