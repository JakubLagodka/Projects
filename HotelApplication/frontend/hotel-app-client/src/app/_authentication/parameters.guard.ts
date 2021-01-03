import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../_services/authentication.service';


@Injectable({ providedIn: 'root' })
export class ParametersGuard implements CanActivate {
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    const currentUser = this.authenticationService.currentUserValue;

    if (this.authenticationService.isUserLoggedIn) {
      if (currentUser.roleCode === 'ADM') {
        this.router.navigate(['/edit-parameters'], {skipLocationChange: true});
        return true;
      }

      return false;
    }

  }
}
