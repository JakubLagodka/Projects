import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';
import { User } from '../_models/user';
import {Token} from '../_models/token';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  private loggedUserSubject: BehaviorSubject<User>;
  public loggedUser: Observable<User>;

  constructor(private http: HttpClient) {
    if (!this.isUserLoggedIn) { // make sure to delete data from previous login
      localStorage.removeItem('token');
      localStorage.removeItem('currentUser');
    }
    this.loggedUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
    this.loggedUser = this.loggedUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.loggedUserSubject.value;
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
    return this.http.post<Token>(`${environment.apiUrl}/authentication/login`, { username, password })
      .pipe(map(token => {

        localStorage.setItem('token', JSON.stringify(token));
        this.http.get<User>(`${environment.apiUrl}/user/self`)
          .subscribe(user => {
            this.loggedUserSubject.next(user);
            localStorage.setItem('currentUser', JSON.stringify(user));

          });
        return token;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('token');
    localStorage.removeItem('currentUser');
    this.loggedUserSubject.next(null);
  }
}
