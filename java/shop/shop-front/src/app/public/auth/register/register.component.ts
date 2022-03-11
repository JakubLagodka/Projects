import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';
import { Store } from '@ngxs/store';
import { RegisterAction } from '../state/user.actions';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  formGroup: FormGroup = new FormGroup({});
  formFields: FormlyFieldConfig[] = [
    {
      key: "login",
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
    },
    {
      key: "confirmPassword",
      type: "input",
      templateOptions: {
        label: "password",
        placeholder: "confirm your password",
        required: true,
        type: "password"
      }
    },
    {
      key: "mail",
      type: "input",
      templateOptions: {
        label: "mail",
        placeholder: "enter mail",
        required: true,
      }
    },
      {
        key: "firstName",
        type: "input",
        templateOptions: {
          label: "name",
          placeholder: "enter name",
          required: true
        }
      },
        {
          key: "lastName",
          type: "input",
          templateOptions: {
            label: "surname",
            placeholder: "enter surname",
            required: true
          },
    }
  ]
  
  constructor(private readonly store: Store) { }

  ngOnInit(): void {
  }

  submit(){
    console.log("submit")
    this.store.dispatch(new RegisterAction(this.formGroup.value))
  }
}
