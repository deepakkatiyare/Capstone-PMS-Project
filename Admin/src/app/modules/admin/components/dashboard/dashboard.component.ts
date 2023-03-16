import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService, User } from '@auth0/auth0-angular';
import { Auth0Client } from '@auth0/auth0-spa-js';
import { concatMap, map, tap } from 'rxjs';
import { UserserviceService } from 'src/app/service/userservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  constructor(public auth: AuthService) {

  }

}

