import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Role} from '../_models/role';
import {User} from '../_models/user';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../_services/user.service';
import {take} from 'rxjs/operators';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   roles$: Observable<Role[]>;
  userPost: User = new User();
  returnUrl: string;

  constructor(@Inject(AppComponent) private parent: AppComponent,
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
    setTimeout(() => {
      if (this.userService.status !== null)
      {
        if(this.userService.status === 409)
        {
          setTimeout(() => {
            this.parent.userAlreadyExists = false;
          }, 5000);
          this.parent.userAlreadyExists = true;
        }
        else {
          setTimeout(() => {
            this.parent.userNotCreated = false;
          }, 5000);
          this.parent.userNotCreated = true;
        }
        this.userService.status = null;
      }
      else
      {
        setTimeout(() => {
          this.parent.createdNewUser = false;
        }, 5000);
        this.parent.createdNewUser = true;
        this.router.navigate([this.returnUrl]);
      }
    }, 50);


  }
dismiss(){}
  ngOnInit(): void {
    // this.roles$ = this.userService.getRoles();
    this.returnUrl = this.route.snapshot.queryParams[`returnUrl`] || '';
  }


}