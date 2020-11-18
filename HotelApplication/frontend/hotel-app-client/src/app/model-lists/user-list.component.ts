import { HttpService } from './../services/http.service';
import { UserService } from '../services/user.service';
import { User } from '../models/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Array<User>;

  constructor(private httpService: HttpService) { }

  ngOnInit(): void {
    this.httpService.getHotels().subscribe(data => {
     this.users = data;
    });
   }

   getUsers(){
    this.httpService.getHotels().subscribe(data => {
      this.users = data;
    });

   }

}
