import { ProfileComponent } from './profile/profile.component';
import { PatientRegiComponent } from './patient-regi/patient-regi.component';
import { BookappointmentComponent } from './bookappointment/bookappointment.component';
import { PatienthomeComponent } from './patienthome/patienthome.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HealthRecordsComponent } from './health-records/health-records.component';
import { PrescriptionComponent } from './health-records/prescription/prescription.component';
import { TestdetailsComponent } from './testdetails/testdetails.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: "", redirectTo: "register", pathMatch: "full"
  },
  {
    path: "register", component: PatientRegiComponent
  },
  {
    path: "patient-home", component: PatienthomeComponent
  },
  {
    path: "bookappointment", component: BookappointmentComponent
  },
  {
    path: "health-records", component: HealthRecordsComponent
  },
  {
    path: "testdetails", component: TestdetailsComponent
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path:"profile",component:ProfileComponent
  },
  {
    path:"sidebar",component:SidebarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
