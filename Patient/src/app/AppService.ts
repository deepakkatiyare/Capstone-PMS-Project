import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class AppService {
    constructor(private http: HttpClient) {}
    public getPatientByEmail(email:string,password:string):Observable<String>{
        let queryParams = new HttpParams();
        queryParams = queryParams.append("emailId",email);
        queryParams=queryParams.append("password",password)
        return this.http.get<String>('http://localhost:9002/api/v1/patientByEmail',{params:queryParams});
      }
}