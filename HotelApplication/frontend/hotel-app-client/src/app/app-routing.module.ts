import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_helpers/auth.guard';
import {ObjectsComponent} from './manager/objects/objects.component';
import {ModalComponent} from './modal/modal.component';
import {ReservationComponent} from './reservation/reservation.component';
import {ChoosingCloseToElevatorComponent} from './_reservations/choosing-close-to-elevator/choosing-close-to-elevator.component';
import {RegisterComponent} from './register/register.component';
import {ChosingBalconyComponent} from './_reservations/chosing-balcony/chosing-balcony.component';
import {ChosingBeatifulViewFromWindowsComponent} from './_reservations/chosing-beatiful-view-from-windows/chosing-beatiful-view-from-windows.component';
import {ChoosingPillowTypeComponent} from './_reservations/choosing-pillow-type/choosing-pillow-type.component';
import {ChoosingStoreyComponent} from './_reservations/choosing-storey/choosing-storey.component';
import {SummaryComponent} from './_reservations/summary/summary.component';
const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'objects', component: ObjectsComponent, canActivate: [AuthGuard] },
  { path: 'not-authorized', component: ModalComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'choosing-close-to-elevator', component: ChoosingCloseToElevatorComponent },
  { path: 'choosing-balcony', component: ChosingBalconyComponent },
  { path: 'choosing-beautiful-view-from-windows', component: ChosingBeatifulViewFromWindowsComponent },
  { path: 'choosing-pillow-type', component: ChoosingPillowTypeComponent },
  { path: 'choosing-storey', component: ChoosingStoreyComponent },
  { path: 'summary', component: SummaryComponent },
  // otherwise redirect to home
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
