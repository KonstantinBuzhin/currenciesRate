import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private loginComponent: LoginComponent,
    private router: Router) {

  }

  ngOnInit() {
    this.loginComponent.logOut();
    this.router.navigate(['login']);
  }

}
