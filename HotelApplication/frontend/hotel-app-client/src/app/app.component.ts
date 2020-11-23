import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {User} from './_models/user';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from './_services/authentication.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatSidenav} from '@angular/material/sidenav';
import {first} from 'rxjs/operators';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'hotel-app-client';
  loggedUser: User;
  userSub: Subscription;
  name = Array<User>();
  loginForm: FormGroup;
  @ViewChild('sidenav') sidenav: MatSidenav;
  reason = '';
  mode = new FormControl('over');
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';
  subscription: Subscription;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    public authenticationService: AuthenticationService
  ) {
     this.userSub = this.authenticationService.currentUser.subscribe(x => this.loggedUser = x);
// redirect to home if already logged in
    if (this.authenticationService.currentUserValue) {
      this.router.navigate(['/']);
    }
  }
  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams[`returnUrl`] || '/';
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.authenticationService.login(this.loginForm.controls.username.value, this.loginForm.controls.password.value)
      .pipe(first())
      .subscribe(
        data => {

        },
        error => {
          this.error = error;
          this.loading = false;
        });

    this.subscription = this.authenticationService.currentUser.subscribe(x => {
      this.router.navigate([this.returnUrl]);
    });
  }
  logout() {
    this.loading = false;
    this.submitted = false;
    this.authenticationService.logout();
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
  }
}
