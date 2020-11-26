import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_helpers/auth.guard';
import {ObjectsComponent} from './manager/objects/objects.component';
import {ModalComponent} from './modal/modal.component';
import {ReservationComponent} from './reservation/reservation.component';
import {RegisterComponent} from './register/register.component';
const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'objects', component: ObjectsComponent, canActivate: [AuthGuard] },
  { path: 'not-authorized', component: ModalComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'register', component: RegisterComponent },
  // otherwise redirect to home
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
