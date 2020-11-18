import { AuthGuard } from './auth/auth.guard';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Route } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NoPermissionComponent } from './no-permission/no-permission.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UserListComponent } from './model-lists/user-list.component';
import { RegisterComponent } from './register/register.component';
import { CalendarComponent } from './calendar/calendar/calendar.component';
const APP_ROUTES: Route[] = [
  { path: '', pathMatch: 'full', redirectTo: 'home', canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  {  path: 'not-found', component: NotFoundComponent },
  { path: 'no-permission', component: NoPermissionComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: RegisterComponent },

  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(APP_ROUTES, { relativeLinkResolution: 'legacy' })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
