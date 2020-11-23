import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { LoginComponent } from '../login/login.component';
import { NoPermissionComponent } from '../no-permission/no-permission.component';

const HOME_ROUTES: Route[] = [
  { path: 'home', component: HomeComponent, children: [

  // TODO dodać pozostałe strony
   // { path: '**', redirectTo: '' }
  ]},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(HOME_ROUTES)
  ],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
