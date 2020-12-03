import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './_authentication/auth.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSliderModule } from '@angular/material/slider';
import {MAT_DATE_LOCALE, MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { GreetingComponent } from './greeting/greeting.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ReservationComponent } from './reservation/reservation.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { RegisterComponent } from './register/register.component';
import {MatSelectModule} from '@angular/material/select';
import { ChoosingCloseToElevatorComponent } from './_reservations/choosing-close-to-elevator/choosing-close-to-elevator.component';
import { ChosingBalconyComponent } from './_reservations/chosing-balcony/chosing-balcony.component';
import { ChosingBeatifulViewFromWindowsComponent } from './_reservations/chosing-beatiful-view-from-windows/chosing-beatiful-view-from-windows.component';
import { ChoosingPillowTypeComponent } from './_reservations/choosing-pillow-type/choosing-pillow-type.component';
import { ChoosingStoreyComponent } from './_reservations/choosing-storey/choosing-storey.component';
import { SummaryComponent } from './_reservations/summary/summary.component';
import { UnauthorizedComponent } from './unauthorized/unauthorized.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    GreetingComponent,
    CalendarComponent,
    ReservationComponent,
    RegisterComponent,
    ChoosingCloseToElevatorComponent,
    ChosingBalconyComponent,
    ChosingBeatifulViewFromWindowsComponent,
    ChoosingPillowTypeComponent,
    ChoosingStoreyComponent,
    SummaryComponent,
    UnauthorizedComponent,
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
