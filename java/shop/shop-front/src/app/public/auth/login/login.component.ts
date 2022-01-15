import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';
import { Store } from '@ngxs/store';
import { LoginAction } from '../state/user.actions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  formGroup: FormGroup = new FormGroup({});
  formFields: FormlyFieldConfig[] = [
    {
      key: "username",
      type: "input",
      templateOptions: {
        label: "login",
        placeholder: "enter login",
        required: true
      }
    },
    {
      key: "password",
      type: "input",
      templateOptions: {
        label: "password",
        placeholder: "enter password",
        required: true,
        type: "password"
      }
    }
  ]
  constructor(private readonly store: Store) { }

  ngOnInit(): void {
  }

  submit(){
    this.store.dispatch(new LoginAction(this.formGroup.value))
  }
}