import { Component, OnInit } from '@angular/core';

import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User();
  msg='';

  constructor(private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser(){
this._service.loginUserFromRemote(this.user).subscribe(
  data => {
    console.log("response recieved")
    sessionStorage.setItem('username', this.user.name)
    this._router.navigate(['/currenciesRate'])

  },
  error => {
    console.log("exception occured");
    this.msg="Bad creditials, please enter valid email and password"
}
);
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }
  logOut() {
    sessionStorage.removeItem('username')
    this._router.navigate(['/login'])
  }
  gotoregistration(){
    this._router.navigate(['/registration'])
  }

}
