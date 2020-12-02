import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Role} from '../_models/role';
import {User} from '../_models/user';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../_services/user.service';
import {take} from 'rxjs/operators';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   roles$: Observable<Role[]>;
  userPost: User = new User();
  returnUrl: string;

  constructor(
    // public modal: NgbActiveModal,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  submit() {
    // if(this.userPost.roleCode === '')
    this.userPost.roleCode = 'CLI';

    this.userService.registerUser(this.userPost).pipe(take(1)).subscribe(x => {
     // this.modal.close(x);
    });
    this.authenticationService.login(this.userPost.username, this.userPost.password);

    this.router.navigate([this.returnUrl]);
  }
dismiss(){}
  ngOnInit(): void {
    // this.roles$ = this.userService.getRoles();
    this.returnUrl = this.route.snapshot.queryParams[`returnUrl`] || '';
  }


}
