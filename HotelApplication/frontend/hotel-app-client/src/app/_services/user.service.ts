import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {BehaviorSubject, Observable} from 'rxjs';
import {shareReplay, take} from 'rxjs/operators';
import {User} from '../_models/user';

import {Role} from '../_models/role';



@Injectable({
  providedIn: 'root'
})
export class UserService {

  private users: Observable<User[]>;
  private workers: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private clients: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private managers: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private workers$: Observable<User[]> = this.workers.asObservable();
  private clients$: Observable<User[]> = this.clients.asObservable();
 // private managers$: Observable<User[]> = this.managers.asObservable();

  private roles: BehaviorSubject<Role[]> = new BehaviorSubject([]);
  private roles$: Observable<Role[]> = this.roles.asObservable();
status = null;
  constructor(
    private http: HttpClient
  ) {}

  fetchUsers(): Observable<User[]> {
    if(!this.users && this.workers.value.length === 0 && this.clients.value.length === 0 && this.managers.value.length === 0) {
      /*this.users = this.http.get<User[]>(`${environment.apiUrl}/user`).pipe(
        shareReplay()
      );*/
      this.users = this.http.get<User[]>('${environment.apiUrl}/user');

      this.users.subscribe(x => {
        this.workers.next(x.filter(y => y.roleCode === 'WOR'));
        this.clients.next(x.filter(y => y.roleCode === 'CLI'));
      //  this.managers.next(x.filter(y => y.roleCode === 'MAN'));

      });
    }

    return this.users;
  }

  private placeUserInArray(user: User) {
    let users;
    switch (user.roleCode) {
     /* case 'MAN':
        users = this.managers.value;
        users.unshift(user);
        this.managers.next(users);
        break;*/
      case 'WOR':
        users = this.workers.value;
        users.unshift(user);
        this.workers.next(users);
        break;
      case 'CLI':
        users = this.clients.value;
        users.unshift(user);
        this.clients.next(users);
        break;
    }
  }

  private deleteUserFromArray(user: User) {
    let users;
    switch(user.roleCode) {
    /*  case 'MAN':
        users = this.managers.value;
        users.splice(users.findIndex(x => x.id === user.id), 1);
        this.managers.next(users);
        break;*/
      case 'WOR':
        users = this.workers.value;
        users.splice(users.findIndex(x => x.id === user.id), 1);
        this.workers.next(users);
        break;
      case 'CLI':
        users = this.clients.value;
        users.splice(users.findIndex(x => x.id === user.id), 1);
        this.clients.next(users);
        break;
    }
  }

  private replaceUserInArray(user: User) {
    let users;
    switch(user.roleCode) {
    /*  case 'MAN':
        users = this.managers.value;
        users[users.findIndex(x => x.id === user.id)] = user;
        this.managers.next(users);
        break;*/
      case 'WOR':
        users = this.workers.value;
        users[users.findIndex(x => x.id === user.id)] = user;
        this.workers.next(users);
        break;
      case 'CLI':
        users = this.clients.value;
        users[users.findIndex(x => x.id === user.id)] = user;
        this.clients.next(users);
        break;
    }
  }

  registerUser(userPost: User): Observable<User> {
    const user = this.http.post<User>(`${environment.apiUrl}/user/register`, userPost).pipe(shareReplay());

    user.pipe(take(1)).subscribe(x => {
      this.placeUserInArray(x);
    },
      err => {
      this.status = err.status;
      });
    return user;
  }

  updateUser(user: User, oldUser: User): Observable<User> {
    const result = this.http.patch<User>(`${environment.apiUrl}/user/` + oldUser.id + `/`, user).pipe(shareReplay());

    result.pipe(take(1)).subscribe(x => {
      if(oldUser.roleCode !== user.roleCode) {
        this.deleteUserFromArray(oldUser);
        this.placeUserInArray(x);
      }
      else
        this.replaceUserInArray(x);

    });
    return result;
  }

  getWorkers(): Observable<User[]> {
    /*if(!this.workers)
      this.workers = this.usersArray.filter(x => x.roleCode === 'WOR');

    return this.workers;*/
    return this.workers$;
  }

  getClients(): Observable<User[]> {
    /*if(!this.clients)
      this.clients = this.usersArray.filter(x => x.roleCode === 'CLI');

    return this.clients;*/
    return this.clients$;
  }

  /*getManagers(): Observable<User[]> {
    if(!this.managers)
      this.managers = this.usersArray.filter(x => x.roleCode === 'MAN');

    return this.managers;
    return this.managers$;
  }*/

  getUserById(userId: number): User {
    return this.clients.value.find(x => x.id === userId) ||
      this.workers.value.find(x => x.id === userId) || this.managers.value.find(x => x.id === userId);
  }

  getRoles(): Observable<Role[]> {
    if (this.roles.value.length === 0) {
      this.http.get<Role[]>(`${environment.apiUrl}/role`).subscribe(x => {
        this.roles.next(x);
      });
    }

    return this.roles$;
  }

}
