import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:9004/api/v1/patient/login';
  }

  public loginPatient(email:string,password:string): Observable<Patient> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append("email",email);
    queryParams = queryParams.append("password",password);
    return this.http.get<Patient>(this.loginUrl,{params:queryParams});
  }

  public getPatient(patientId:number):Observable<Patient>{
    return this.http.get<Patient>('http://localhost:9004/api/v1/patient/'+patientId);
  }
}
