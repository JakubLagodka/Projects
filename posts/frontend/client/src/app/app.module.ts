import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PostCurrentComponent } from './merce_test_desktop_strona_glowna/posts/post-current/post-current.component';
import {NgxsModule} from "@ngxs/store";
import {PostsState} from "./components/state/posts.state";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,

    PostCurrentComponent
  ],
  imports: [
    BrowserModule,
    NgxsModule.forRoot([PostsState]),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
