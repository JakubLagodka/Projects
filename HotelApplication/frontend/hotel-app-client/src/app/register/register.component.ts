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
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   roles$: Observable<Role[]>;
  userPost: User = new User();
  returnUrl: string;
  admin = false;
  userTypeControl = new FormControl('', Validators.required);
  userTypes = [ 'recepcjonista', 'klient'];
  constructor(@Inject(AppComponent) private parent: AppComponent,
    // public modal: NgbActiveModal,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  submit() {
     if(this.userTypeControl.value === 'recepcjonista')
    this.userPost.roleCode = 'WOR';
     else
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
    if(this.authenticationService.currentUserValue.roleCode === 'ADM')
      this.admin = true;

    this.returnUrl = this.route.snapshot.queryParams[`returnUrl`] || '';
  }


}
