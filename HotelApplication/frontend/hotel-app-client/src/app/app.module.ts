import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './_helpers/auth.interceptor';
import { ManagerComponent } from './manager/manager.component';
import { RequestComponent } from './manager/request/request.component';
import { ActivityInRequestComponent } from './manager/request/activity-in-request/activity-in-request.component';
import { NewRequestComponent } from './manager/new-request/new-request.component';
import { ModalComponent } from './modal/modal.component';
import { EditRequestComponent } from './manager/edit-request/edit-request.component';
import { NewActivityComponent } from './manager/request/new-activity/new-activity.component';
import { EditActivityComponent } from './edit-activity/edit-activity.component';
import { ActivityBaseComponent } from './activity-base/activity-base.component';
import { ObjectsComponent } from './manager/objects/objects.component';
import { NewObjectComponent } from './manager/objects/new-object/new-object.component';
import { EditObjectComponent } from './manager/objects/edit-object/edit-object.component';
import { WorkerComponent } from './worker/worker.component';
import { ActivityInWorkerComponent } from './worker/activity-in-worker/activity-in-worker.component';
import { AdminComponent } from './admin/admin.component';
import { NewUserComponent } from './admin/new-user/new-user.component';
import { EditUserComponent } from './admin/edit-user/edit-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSliderModule } from '@angular/material/slider';
import {MAT_DATE_LOCALE, MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { GreetingComponent } from './greeting/greeting.component';
import { SidePannelComponent } from './side-pannel/side-pannel/side-pannel.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ReservationComponent } from './reservation/reservation.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { RegisterComponent } from './register/register.component';
import {MatSelectModule} from '@angular/material/select';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ManagerComponent,
    RequestComponent,
    ActivityInRequestComponent,
    NewRequestComponent,
    ModalComponent,
    EditRequestComponent,
    NewActivityComponent,
    EditActivityComponent,
    ActivityBaseComponent,
    ObjectsComponent,
    NewObjectComponent,
    EditObjectComponent,
    WorkerComponent,
    ActivityInWorkerComponent,
    AdminComponent,
    NewUserComponent,
    EditUserComponent,
    GreetingComponent,
    SidePannelComponent,
    CalendarComponent,
    ReservationComponent,
    RegisterComponent,
    NewReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatSliderModule,
    MatNativeDateModule,
    MatInputModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatDividerModule,
    MatListModule,
    MatOptionModule,
    MatAutocompleteModule,
    MatSelectModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    {provide: MAT_DATE_LOCALE, useValue: 'pl-PL'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
