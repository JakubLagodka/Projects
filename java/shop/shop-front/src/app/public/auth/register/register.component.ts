import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

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
        key: "name",
        type: "input",
        templateOptions: {
          label: "name",
          placeholder: "enter name",
          required: true
        }
      },
        {
          key: "surname",
          type: "input",
          templateOptions: {
            label: "surname",
            placeholder: "enter surname",
            required: true
          },
    }
  ]
  
  constructor() { }

  ngOnInit(): void {
  }

}
