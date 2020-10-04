import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = `${environment.apiUrl}/user/all`;
   }

   public getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(`${environment.apiUrl}/user/all`);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }
}
