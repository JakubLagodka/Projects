import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import {Observable} from 'rxjs';
import {User} from '../_models/user';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
  confirmed = false ;
users$: Observable<User[]>;
  constructor(  private route: ActivatedRoute,
                private router: Router,
                private userService: UserService) { }

  ngOnInit(): void {
    this.users$ = this.userService.getUsers();
  }

  registerUser() {
this.router.navigate(['/register']);
  }

  deleteUser() {
    this.confirmed = true;
  }
}
