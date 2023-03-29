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
        return this.http.post<String>('http://localhost:9002/api/v1/patient',password,{params:queryParams});
      }
}