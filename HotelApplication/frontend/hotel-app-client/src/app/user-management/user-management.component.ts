import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
  confirmed = false ;

  constructor(  private route: ActivatedRoute,
                private router: Router,) { }

  ngOnInit(): void {
  }

  registerUser() {
this.router.navigate(['/register']);
  }
}
