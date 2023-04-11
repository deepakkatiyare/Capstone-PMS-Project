import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService, User } from '@auth0/auth0-angular';
import { Auth0Client } from '@auth0/auth0-spa-js';
import { concatMap, map, tap } from 'rxjs';
import { MatTabGroup } from '@angular/material/tabs';
import { PhysicianAvailabilityService } from 'src/app/services/physician-availability.service';
import { PatientBasicInfoService } from 'src/app/services/patient-basic-info.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  doctorCount: any;
  patientCount: any;
  constructor(public auth: AuthService, private physician: PhysicianAvailabilityService, private patient: PatientBasicInfoService) {
  }

  ngOnInit(): void {
    this.physician.getCount().subscribe({
      next: (count) => {
        this.doctorCount = 0;
        if (count != 0) {
          console.log(count);
          setInterval(() => {
            if (this.doctorCount < count)
              this.doctorCount++;
          }, 500);
        }
      }
    });
    this.patient.getCount().subscribe({
      next: (count) => {
        this.patientCount = 0;
        if (count != 0) {
          console.log(count);
          setInterval(() => {
            if (this.patientCount < count)
              this.patientCount++;
          }, 500);
        }
      }
    })
  }
}

