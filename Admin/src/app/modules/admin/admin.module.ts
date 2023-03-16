import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NurseComponent } from './components/nurse/nurse.component';
import { PhysicianComponent } from './components/physician/physician.component';
import { SideNavItemsComponent } from './components/side-nav-items/side-nav-items.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDividerModule } from '@angular/material/divider';
import { PatientComponent } from './components/patient/patient.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { DeletePopupComponent } from './components/delete-popup/delete-popup.component';
import { DialogPopComponent } from './components/dialog-pop/dialog-pop.component';
import { MatDialogActions, MatDialogModule } from '@angular/material/dialog';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { AdminComponent } from './components/admin/admin.component';
import { AuthModule } from '@auth0/auth0-angular';


@NgModule({
  declarations: [
    DeletePopupComponent,
    DialogPopComponent,
    DashboardComponent,
    NurseComponent,
    PhysicianComponent,
    SideNavItemsComponent,
    ToolbarComponent,
    PatientComponent,
    AdminComponent,
  ],
  imports: [
    MatDialogModule,
    MatDatepickerModule,
    CommonModule,
    AdminRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatExpansionModule,
    MatDividerModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatTableModule,
    AuthModule.forRoot({
      domain: 'dev-85rf4haa0cxb2bmc.us.auth0.com',
      clientId: 'IGRLRye0FaLsqkzrmUjb7xUz50h6Nn2C',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    })
  ]
})
export class AdminModule { }
