import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../AppService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  credentials = { username: '', password: '' };
  error: any;
  constructor(private app: AppService, private http: HttpClient, private router: Router) {
  }
  login() {
    this.app.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/patient-home');
    });
    return false;
  }
}
