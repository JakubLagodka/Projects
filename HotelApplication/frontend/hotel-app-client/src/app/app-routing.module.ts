import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_authentication/auth.guard';
import { AdminGuard } from './_authentication/admin.guard';
import { ReceptionGuard } from './_authentication/reception.guard';
import { ClientGuard } from './_authentication/client.guard';
import { MainGuard } from './_authentication/main.guard';
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
import {EditParametersComponent} from './edit-parameters/edit-parameters.component';
import {AdministrationPanelComponent} from './administration-panel/administration-panel.component';
import {ClientPanelComponent} from './client-panel/client-panel.component';
import {ReceptionPanelComponent} from './reception-panel/reception-panel.component';
import {EditRoomsComponent} from './edit-rooms/edit-rooms.component';
import {UserManagementComponent} from './user-management/user-management.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'unauthorized', component: UnauthorizedComponent },
  { path: 'choosing-close-to-elevator', component: ChoosingCloseToElevatorComponent },
  { path: 'choosing-balcony', component: ChosingBalconyComponent },
  { path: 'choosing-beautiful-view-from-windows', component: ChosingBeatifulViewFromWindowsComponent },
  { path: 'choosing-pillow-type', component: ChoosingPillowTypeComponent },
  { path: 'choosing-storey', component: ChoosingStoreyComponent },
  { path: 'greeting', component: GreetingComponent, canActivate: [MainGuard] },
  { path: 'summary', component: SummaryComponent },
  { path: 'made-by-given-user', component: MadeByGivenUserComponent, canActivate: [AuthGuard] },
  { path: 'administrator-panel', component: AdministrationPanelComponent, canActivate: [AdminGuard] },
  { path: 'edit-parameters', component: EditParametersComponent, canActivate: [AdminGuard] },
  { path: 'client-panel', component: ClientPanelComponent, canActivate: [ClientGuard] },
  { path: 'reception-panel', component: ReceptionPanelComponent, canActivate: [ReceptionGuard] },
  { path: 'edit-rooms', component: EditRoomsComponent, canActivate: [AdminGuard] },
  { path: 'user-management', component: UserManagementComponent, canActivate: [AdminGuard] },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
