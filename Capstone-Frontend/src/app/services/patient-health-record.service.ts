import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppointmentDto } from '../model_classes/appointment';
import { PrescriptionDetails } from '../model_classes/prescription';
import { TestDetails } from '../model_classes/test';
import { PatientInfoDetails } from '../model_classes/visit_details';

@Injectable({
  providedIn: 'root'
})
export class PatientHealthRecordService {

  constructor(private http: HttpClient) { }

  public healthRecords(patientId: number): Observable<PatientInfoDetails[]> {
    return this.http.get<PatientInfoDetails[]>('http://localhost:9007/api/v1/patient/' + patientId + '/visits');
  }
  public visitDetails(visitId: number): Observable<PatientInfoDetails> {
    return this.http.get<PatientInfoDetails>('http://localhost:9007/api/v1/visitdetail/' + visitId);
  }

  public postPrescription(prescription: any) {
    return this.http.post("http://localhost:9007/api/v1/visitdetails/prescription", prescription)
  }
  public postTest(Test: any) {
    console.log("tanu")
    console.log(Test);
    return this.http.post("http://localhost:9007/api/v1/visitdetails/tests", Test)
  }
  public getTests(Id: any): Observable<TestDetails[]> {
    return this.http.get<TestDetails[]>("http://localhost:9007/api/v1/tests/" + Id);
  }

  public getNurses() {
    return this.http.get("http://localhost:9007/api/v1/nurse");
  }
  public getPrescription(id: any): Observable<PrescriptionDetails[]> {
    return this.http.get<PrescriptionDetails[]>("http://localhost:9007/api/v1/prescriptions/" + id);
  }

  public getVisitDetails(
    appointmentId: any
  ): Observable<PatientInfoDetails> {
    return this.http.get<PatientInfoDetails>(
      'http://localhost:9007/api/v1/visit/' + appointmentId
    );
  }

  public getNurseCount() {
    return this.http.get("http://localhost:9007/api/v1/nurse/count");
  }


  // to get test details

  public getTestDetails(visitId: any): Observable<TestDetails[]> {
    return this.http.get<TestDetails[]>(
      'http://localhost:9007/api/v1/visitdetails/' + visitId + '/tests'
    );
  }

  // to get Prescription Details
  public getPrescriptionDetails(
    visitId: any
  ): Observable<PrescriptionDetails[]> {
    return this.http.get<PrescriptionDetails[]>(
      'http://localhost:9007/api/v1/visitdetails/' + visitId + '/prescription'
    );
  }
}
