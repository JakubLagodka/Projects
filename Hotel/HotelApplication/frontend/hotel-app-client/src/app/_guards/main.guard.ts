import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../_services/authentication.service';


@Injectable({ providedIn: 'root' })
export class MainGuard implements CanActivate {
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    const currentUser = this.authenticationService.currentUserValue;

    if (this.authenticationService.isUserLoggedIn){
     if (currentUser.roleCode === 'ADM') {
       this.router.navigate(['/administrator-panel'], {skipLocationChange: true});
     }
     else if (currentUser.roleCode === 'WOR')
     {
       this.router.navigate(['/reception-panel'], {skipLocationChange: true});
     }
   else if (currentUser.roleCode === 'CLI')
     {
       this.router.navigate(['/client-panel'], {skipLocationChange: true});
     }
     return true;
    }

    return false;
  }


}
