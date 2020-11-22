import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService
    ) { this.user = new User();
  }
  ngOnInit(): void {

  }

onSubmit(){
  /*this.userService.save(this.user).subscribe(result =>
    this.goToUserList());
}
goToUserList(){
  this.router.navigate(['/users']);*/
}
}
