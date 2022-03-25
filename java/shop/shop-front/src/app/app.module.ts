import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './menu/menu.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { PublicModule } from './public/public.module';
import { PrivateModule } from './private/private.module';
import { NgxsModule } from '@ngxs/store';
import { HttpClientModule } from '@angular/common/http';
import { NgxsReduxDevtoolsPluginModule } from '@ngxs/devtools-plugin'
import { NgxsRouterPluginModule } from '@ngxs/router-plugin';
import { AbstractControl } from '@angular/forms';
import { FormlyModule } from '@ngx-formly/core';
import { ApiModule } from 'src/api/api.module';
import { environment } from 'src/environments/environment';

export function minlengthValidationMessages(err, field) {
  return `Should have atleast ${field.templateOptions.minLength} characters`;
}

export function fieldMatchValidator(control: AbstractControl) {
  const { password, confirmPassword } = control.value;

  // avoid displaying the message error when values are empty
  if (!confirmPassword || !password) {
    return null;
  }

  if (confirmPassword === password) {
    return null;
  }

  return { fieldMatch: { message: 'Password Not Matching' } };
}

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    PublicModule,
    PrivateModule,
    NgxsModule.forRoot(),
    HttpClientModule,
    NgxsReduxDevtoolsPluginModule.forRoot(),
    NgxsRouterPluginModule.forRoot(),
    FormlyModule.forRoot({
      validators: [
        { name: 'fieldMatch', validation: fieldMatchValidator },
      ],
      validationMessages: [
        { name: 'required', message: 'This field is required' },
        { name: 'minlength', message: minlengthValidationMessages },
      ],
    }),
    ApiModule.forRoot({
      rootUrl: environment.backendUrl
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
