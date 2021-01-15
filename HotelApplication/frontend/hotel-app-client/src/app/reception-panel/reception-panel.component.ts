import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-reception-panel',
  templateUrl: './reception-panel.component.html',
  styleUrls: ['./reception-panel.component.css']
})
export class ReceptionPanelComponent implements OnInit {
  constructor(private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
  }

  goToOccupancyPreview() {
    this.router.navigate(['/occupancy-preview']);
  }

  goToReservationPreview() {
    this.router.navigate(['/made-by-given-user']);
  }

}
