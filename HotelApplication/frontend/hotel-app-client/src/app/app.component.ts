import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {User} from './_models/user';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from './_services/authentication.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatSidenav} from '@angular/material/sidenav';
import {first} from 'rxjs/operators';
import {CalendarService} from './_services/calendar.service';
import {CalendarComponent} from './calendar/calendar.component';
import {Reservation} from './_models/reservation';
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
  minDate: Date;
  maxDate: Date;
  reservation: Reservation;
  notLogged = false;
  range = new FormGroup({
    start: new FormControl(['', Validators.required]),
    end: new FormControl(['', Validators.required])
  });
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    public authenticationService: AuthenticationService,
    private calendarService: CalendarService
  ) {
      this.userSub = this.authenticationService.loggedUser.subscribe(x => this.loggedUser = x);
      const currentYear = new Date().getFullYear();
      const currentMonth = new Date().getMonth();
      const currentDay = new Date().getDate();

      this.minDate = new Date(currentYear, currentMonth, currentDay);
      this.maxDate = new Date(currentYear + 10, currentMonth, currentDay);
    }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams[`returnUrl`] || '/';
  }
  calendarSubmit() {
     this.submitted = true;
    // stop here if form is invalid
    if (this.calendarService.range.invalid) {
      return;
    }
    this.notLogged = true;
    this.calendarService.takeDates( this.range);
    this.sidenav.close();
    this.router.navigate(['/reservation']);
  }
  onSubmit() {
    this.submitted = true;
    this.notLogged = false;
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

    this.subscription = this.authenticationService.loggedUser.subscribe(x => {
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
