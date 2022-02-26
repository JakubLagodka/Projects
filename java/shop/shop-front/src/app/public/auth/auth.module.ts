import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthComponent } from './auth/auth.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormlyModule } from '@ngx-formly/core';
import { FormlyMaterialModule } from '@ngx-formly/material';
import {MatButtonModule} from '@angular/material/button'; 

const routes: Routes = [
  {
    path: "",
    component:AuthComponent,
    children:[
      {
        path:"login",
        component:LoginComponent
      },
      {
        path: "register",
        component: RegisterComponent
      }
    ]
  }
]

@NgModule({
  declarations: [
    AuthComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    FormlyModule,
    FormlyMaterialModule,
    MatButtonModule
  ]
})
export class AuthModule { }
