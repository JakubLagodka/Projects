import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import { User } from '../models/user';
import {Role} from '../models/role';
import {shareReplay, take} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

 /*private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = `${environment.apiUrl}/user/all`;
   }

   public getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(`${environment.apiUrl}/user/all`);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }*/
  private users: Observable<User[]>;
  private usersArray: User[];
  private workers: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private clients: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private managers: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private workers$: Observable<User[]> = this.workers.asObservable();
  private clients$: Observable<User[]> = this.clients.asObservable();
  private managers$: Observable<User[]> = this.managers.asObservable();
  private inactives: BehaviorSubject<User[]> = new BehaviorSubject([]);
  private inactives$: Observable<User[]> = this.inactives.asObservable();

  private roles: BehaviorSubject<Role[]> = new BehaviorSubject([]);
  private roles$: Observable<Role[]> = this.roles.asObservable();

  constructor(
    private http: HttpClient
  ) {}

  fetchUsers(): Observable<User[]> {
    if (!this.users && this.workers.value.length === 0 && this.clients.value.length === 0 && this.managers.value.length === 0) {
      /*this.users = this.http.get<User[]>(`${environment.apiUrl}/user`).pipe(
        shareReplay()
      );*/
      this.users = this.http.get<User[]>('${environment.apiUrl}/user');

      this.users.subscribe(x => {
        this.workers.next(x.filter(y => y.role === 'WOR'));
        this.clients.next(x.filter(y => y.role === 'CLI'));
        this.managers.next(x.filter(y => y.role === 'MAN'));
        this.inactives.next(x.filter(y => y.role === null));

      });
    }

    return this.users;
  }

  private placeUserInArray(user: User) {
    let users;
    switch (user.role) {
      case 'MAN':
        users = this.managers.value;
        users.unshift(user);
        this.managers.next(users);
        break;
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
      default:
        users = this.inactives.value;
        users.unshift(user);
        this.inactives.next(users);
        break;
    }
  }

  private deleteUserFromArray(user: User) {
    let users;
    switch (user.role) {
      case 'MAN':
        users = this.managers.value;
        users.splice(users.findIndex(x => x.id === user.id), 1);
        this.managers.next(users);
        break;
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
      default:
        users = this.inactives.value;
        users.splice(users.findIndex(x => x.id === user.id), 1);
        this.inactives.next(users);
        break;
    }
  }

  private replaceUserInArray(user: User) {
    let users;
    switch (user.role) {
      case 'MAN':
        users = this.managers.value;
        users[users.findIndex(x => x.id === user.id)] = user;
        this.managers.next(users);
        break;
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
      default:
        users = this.inactives.value;
        users[users.findIndex(x => x.id === user.id)] = user;
        this.inactives.next(users);
        break;
    }
  }

  registerUser(user: User): Observable<User> {
    const returnedUser = this.http.post<User>(`${environment.apiUrl}/user/register`, User).pipe(shareReplay());

    returnedUser.pipe(take(1)).subscribe(x => {
      this.placeUserInArray(x);
    });
    return returnedUser;
  }

  updateUser(user: User, oldUser: User): Observable<User> {
    const result = this.http.patch<User>(`${environment.apiUrl}/user/` + oldUser.id + `/`, User).pipe(shareReplay());

    result.pipe(take(1)).subscribe(x => {
      if (oldUser.role !== user.role) {
        this.deleteUserFromArray(oldUser);
        this.placeUserInArray(x);
      }
      else {
        this.replaceUserInArray(x);
      }

    });
    return result;
  }

  getWorkers(): Observable<User[]> {
    /*if(!this.workers)
      this.workers = this.usersArray.filter(x => x.roleCode === 'WOR');

    return this.workers;*/
    return this.workers$;
  }

  getInactives(): Observable<User[]> {
    return this.inactives$;
  }

  getClients(): Observable<User[]> {
    /*if(!this.clients)
      this.clients = this.usersArray.filter(x => x.roleCode === 'CLI');

    return this.clients;*/
    return this.clients$;
  }

  getManagers(): Observable<User[]> {
    /*if(!this.managers)
      this.managers = this.usersArray.filter(x => x.roleCode === 'MAN');

    return this.managers;*/
    return this.managers$;
  }

/*  getUserById(userId: number): User {


    return this.clients.value.find(x => x.id === userId) ||
      this.workers.value.find(x => x.id === userId) || this.managers.value.find(x => x.id === userId);
  }

  getRoles(): Observable<Role[]> {
    if(this.roles.value.length === 0) {
      this.http.get<Role[]>(`${environment.apiUrl}/role`).subscribe(x => {
        this.roles.next(x);
      });
    }

    return this.roles$;
  }*/
}
