import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_guards/auth.guard';
import { AdminGuard } from './_guards/admin.guard';
import { ReceptionGuard } from './_guards/reception.guard';
import { ClientGuard } from './_guards/client.guard';
import { MainGuard } from './_guards/main.guard';
import {ReservationComponent} from './_reservations/reservation/reservation.component';
import {RegisterComponent} from './register/register.component';
import {SummaryComponent} from './_reservations/summary/summary.component';
import {GreetingComponent} from './greeting/greeting.component';
import {MadeByGivenUserComponent} from './_reservations/made-by-given-user/made-by-given-user.component';
import {EditParametersComponent} from './edit-parameters/edit-parameters.component';
import {AdministrationPanelComponent} from './administration-panel/administration-panel.component';
import {ClientPanelComponent} from './client-panel/client-panel.component';
import {ReceptionPanelComponent} from './reception-panel/reception-panel.component';
import {EditRoomsComponent} from './edit-rooms/edit-rooms.component';
import {UserManagementComponent} from './user-management/user-management.component';
import {OccupacyPreviewComponent} from './_reservations/occupacy-preview/occupacy-preview.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'greeting', component: GreetingComponent, canActivate: [MainGuard] },
  { path: 'summary', component: SummaryComponent },
  { path: 'made-by-given-user', component: MadeByGivenUserComponent, canActivate: [AuthGuard] },
  { path: 'administrator-panel', component: AdministrationPanelComponent, canActivate: [AdminGuard] },
  { path: 'edit-parameters', component: EditParametersComponent, canActivate: [AdminGuard] },
  { path: 'client-panel', component: ClientPanelComponent, canActivate: [ClientGuard] },
  { path: 'reception-panel', component: ReceptionPanelComponent, canActivate: [ReceptionGuard] },
  { path: 'occupancy-preview', component: OccupacyPreviewComponent, canActivate: [ReceptionGuard] },
  { path: 'edit-rooms', component: EditRoomsComponent, canActivate: [AdminGuard] },
  { path: 'user-management', component: UserManagementComponent, canActivate: [AdminGuard] },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
