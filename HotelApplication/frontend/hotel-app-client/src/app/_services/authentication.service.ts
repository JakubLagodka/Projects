import {Injectable, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../_models/user';
import {Token} from '../_models/token';
import {ActivatedRoute, Router} from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthenticationService implements OnInit{
  private loggedUserSubject: BehaviorSubject<User>;
  public loggedUser: Observable<User>;

  constructor(private http: HttpClient,
              private route: ActivatedRoute,
              private router: Router) {
    if (!this.isUserLoggedIn) { // make sure to delete data from previous login
      localStorage.removeItem('token');
      localStorage.removeItem('currentUser');

      this.loggedUserSubject = new BehaviorSubject(new User());
    }
    else
    {
      this.loggedUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
    }
    this.loggedUser = this.loggedUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.loggedUserSubject.value;
  }
ngOnInit() {
  this.loggedUser = this.loggedUserSubject.asObservable();
}

  public get isUserLoggedIn() {
    const token: Token = JSON.parse(localStorage.getItem('token'));
    if (!token) {
      return false;
    }

    const date = new Date();
    const expirationDate = Date.parse(token.expirationDate);
    return date.getTime() < expirationDate;
  }

  login(username: string, password: string) {
    return this.http.post<Token>(`localhost:8080/api/login`, { username, password })
      .pipe(map(token => {

        localStorage.setItem('token', JSON.stringify(token));
        // this.http.get<User>(`localhost:8080/api/users`)
        //   .subscribe(user => {
        //     this.loggedUserSubject.next(user);
        //     localStorage.setItem('currentUser', JSON.stringify(user));
        //
        //   });
        this.loggedUser = this.loggedUserSubject.asObservable();
      }));
  }
  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('token');
    localStorage.removeItem('currentUser');
    this.loggedUserSubject.next(new User());
    this.loggedUser = this.loggedUserSubject.asObservable();

    this.router.navigate(['/']);
  }
}
