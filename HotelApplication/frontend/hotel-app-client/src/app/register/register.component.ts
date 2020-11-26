import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Role} from '../_models/role';
import {User} from '../_models/user';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../_services/user.service';
import {take} from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  roles$: Observable<Role[]>;
  userPost: User = new User();

  constructor(
    public modal: NgbActiveModal,
    private userService: UserService

  ) { }

  submit() {
    if(this.userPost.roleCode === 'null')
      this.userPost.roleCode = null;

    this.userService.registerUser(this.userPost).pipe(take(1)).subscribe(x => {
      this.modal.close(x);
    });
  }

  ngOnInit(): void {
   // this.roles$ = this.userService.getRoles();
  }


}
