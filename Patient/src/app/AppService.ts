import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Patient } from './Patient';

@Injectable()
export class AppService {
    constructor(private http: HttpClient) {}
    public getPatientByEmail(email:string,password:string):Observable<Patient>{
        let queryParams = new HttpParams();
        queryParams = queryParams.append("password",password);
        return this.http.get<Patient>('http://localhost:9004/api/v1/patient/'+email,{params:queryParams});
      }
}