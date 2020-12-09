import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_authentication/auth.guard';
import {ReservationComponent} from './reservation/reservation.component';
import {ChoosingCloseToElevatorComponent} from './_reservations/choosing-close-to-elevator/choosing-close-to-elevator.component';
import {RegisterComponent} from './register/register.component';
import {ChosingBalconyComponent} from './_reservations/chosing-balcony/chosing-balcony.component';
import {ChosingBeatifulViewFromWindowsComponent} from './_reservations/chosing-beatiful-view-from-windows/chosing-beatiful-view-from-windows.component';
import {ChoosingPillowTypeComponent} from './_reservations/choosing-pillow-type/choosing-pillow-type.component';
import {ChoosingStoreyComponent} from './_reservations/choosing-storey/choosing-storey.component';
import {SummaryComponent} from './_reservations/summary/summary.component';
import {GreetingComponent} from './greeting/greeting.component';
import {UnauthorizedComponent} from './unauthorized/unauthorized.component';
import {MadeByGivenUserComponent} from './_reservations/made-by-given-user/made-by-given-user.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'unauthorized', component: UnauthorizedComponent },
  { path: 'choosing-close-to-elevator', component: ChoosingCloseToElevatorComponent },
  { path: 'choosing-balcony', component: ChosingBalconyComponent },
  { path: 'choosing-beautiful-view-from-windows', component: ChosingBeatifulViewFromWindowsComponent },
  { path: 'choosing-pillow-type', component: ChoosingPillowTypeComponent },
  { path: 'choosing-storey', component: ChoosingStoreyComponent },
  { path: 'greeting', component: GreetingComponent, canActivate: [AuthGuard] },
  { path: 'summary', component: SummaryComponent },
  { path: 'made-by-given-user', component: MadeByGivenUserComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
