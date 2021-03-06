import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../_services/authentication.service';


@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    const currentUser = this.authenticationService.currentUserValue;

    if (this.authenticationService.isUserLoggedIn) {

      if (state.url === '/greeting' && currentUser.roleCode === 'CLI') {
        this.router.navigate(['/made-by-given-user'], {skipLocationChange: true});
        return false;
      }

      return true;
    }

    return false;
  }


}
