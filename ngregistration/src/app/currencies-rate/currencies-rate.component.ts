import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../item';
import { Loginservice } from '../loginservice';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-currencies-rate',
  templateUrl: './currencies-rate.component.html',
  styleUrls: ['./currencies-rate.component.css']
})
export class CurrenciesRateComponent implements OnInit {
  items: Item[] | undefined;
  

  constructor(private itemService: AuthenticationService, private _router : Router) {
  }

  ngOnInit() {
    this.itemService.findAll().subscribe(data => {
      this.items = data;
    });
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

}
