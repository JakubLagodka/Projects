import { UserService } from './services/user.service';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth/auth.guard';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpService } from './services/http.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { NoPermissionComponent } from './no-permission/no-permission.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeRoutingModule } from './home/home-routing.module';

import { HomeModule } from './home/home.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserListComponent } from './model-lists/user-list.component';
import { CalendarComponent } from './calendar/calendar/calendar.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSliderModule } from '@angular/material/slider';
import { MatNativeDateModule } from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { GreetingComponent } from './greeting/greeting.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NoPermissionComponent,
    NotFoundComponent,
    UserListComponent,
    RegisterComponent,
    CalendarComponent,
    GreetingComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    AppRoutingModule,
    HomeRoutingModule,
    HomeModule,
    MatDatepickerModule,        // <----- import(must)
    MatSliderModule,
    MatNativeDateModule,
    MatInputModule,
    MatSidenavModule,
    MatCheckboxModule
  ],
  providers: [HttpService, AuthGuard, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }