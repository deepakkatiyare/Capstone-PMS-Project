import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Physician } from './physician';

@Injectable({
  providedIn: 'root'
})
export class DisplayDoctorsService {
    private registerUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'http://localhost:8080/api/v1/patient/physician';
  }

  public findPhysician(): Observable<Physician[]> {
    return this.http.get<Physician[]>(this.registerUrl);
  }
}
