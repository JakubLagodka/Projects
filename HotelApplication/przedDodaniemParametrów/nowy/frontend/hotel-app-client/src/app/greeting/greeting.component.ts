import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-greeting',
  templateUrl: './greeting.component.html',
  styleUrls: ['./greeting.component.css']
})
export class GreetingComponent implements OnInit {

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
}
