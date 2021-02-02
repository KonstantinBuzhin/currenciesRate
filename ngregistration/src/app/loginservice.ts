import { Router } from "@angular/router"

export class Loginservice {
    
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }
  logOut(_router:Router) {
    sessionStorage.removeItem('username')
    _router.navigate(['/login'])
  }
}
