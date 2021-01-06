import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-administration-panel',
  templateUrl: './administration-panel.component.html',
  styleUrls: ['./administration-panel.component.css']
})
export class AdministrationPanelComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
  }

  goToOccupancyPreview() {
    this.router.navigate(['/']);
  }

  goToReservationPreview() {
    this.router.navigate(['/made-by-given-user']);
  }

  goToEditParameters() {
    this.router.navigate(['/edit-parameters']);
  }

  goToEditRooms() {
    this.router.navigate(['/edit-rooms']);
  }

  goToUserManagement() {
    this.router.navigate(['/user-management']);
  }
}
