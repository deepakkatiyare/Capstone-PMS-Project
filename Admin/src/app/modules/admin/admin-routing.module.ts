import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NurseComponent } from './components/nurse/nurse.component';
import { PatientComponent } from './components/patient/patient.component';
import { PhysicianComponent } from './components/physician/physician.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';

const routes: Routes = [{
  path: "", component: ToolbarComponent,
  children: [
    { path: "dashboard", component: DashboardComponent },
    { path: "", redirectTo: "/admin/dashboard", pathMatch: "full" },
    { path: "patient", component: PatientComponent },
    { path: "physician", component: PhysicianComponent },
    { path: "nurse", component: NurseComponent },
    { path: "details", component: AdminComponent }]
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
