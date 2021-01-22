import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './_guards/auth.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSliderModule } from '@angular/material/slider';
import {MAT_DATE_LOCALE, MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { GreetingComponent } from './greeting/greeting.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ReservationComponent } from './_reservations/reservation/reservation.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { RegisterComponent } from './register/register.component';
import {MatSelectModule} from '@angular/material/select';
import { SummaryComponent } from './_reservations/summary/summary.component';
import { MadeByGivenUserComponent } from './_reservations/made-by-given-user/made-by-given-user.component';
import { EditParametersComponent } from './edit-parameters/edit-parameters.component';
import { AdministrationPanelComponent } from './administration-panel/administration-panel.component';
import { ReceptionPanelComponent } from './reception-panel/reception-panel.component';
import { ClientPanelComponent } from './client-panel/client-panel.component';
import { EditParametersDialogComponent } from './edit-parameters/edit-parameters.component';
import {EditRoomsComponent, EditRoomsDialogComponent} from './edit-rooms/edit-rooms.component';
import { UserManagementComponent } from './user-management/user-management.component';
import {OccupacyPreviewComponent, OccupancyPreviewDialogComponent} from './_reservations/occupacy-preview/occupacy-preview.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GreetingComponent,
    CalendarComponent,
    ReservationComponent,
    RegisterComponent,
    SummaryComponent,
    MadeByGivenUserComponent,
    EditParametersComponent,
    AdministrationPanelComponent,
    ReceptionPanelComponent,
    ClientPanelComponent,
    EditParametersDialogComponent,
    EditRoomsDialogComponent,
    EditRoomsComponent,
    UserManagementComponent,
    OccupacyPreviewComponent,
    BookingDetailsComponent,
    OccupancyPreviewDialogComponent
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
