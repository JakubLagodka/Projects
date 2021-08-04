import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PostCurrentComponent } from './merce_test_desktop_strona_glowna/posts/post-current/post-current.component';

@NgModule({
  declarations: [
    AppComponent,

    PostCurrentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
