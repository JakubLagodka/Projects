import {AfterContentInit, AfterViewInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';

@Component({
  selector: 'app-greeting',
  templateUrl: './greeting.component.html',
  styleUrls: ['./greeting.component.css']
})
export class GreetingComponent implements AfterContentInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthenticationService) { }

  ngAfterContentInit(): void {

    const currentUser = this.authenticationService.currentUserValue;

    if (this.authenticationService.isUserLoggedIn){
      if (currentUser.roleCode === 'ADM') {
        this.router.navigate(['/administrator-panel']);
      }
      else if (currentUser.roleCode === 'WOR')
      {
        this.router.navigate(['/reception-panel']);
      }
      else if (currentUser.roleCode === 'CLI')
      {
        this.router.navigate(['/client-panel']);
      }
    }
  }

  goToOccupancyPreview() {
    this.router.navigate(['/']);
  }

  goToReservationPreview() {
    this.router.navigate(['/made-by-given-user']);
  }
}
