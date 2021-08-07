import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Posts} from "./components/state/posts.state";
import {Select, Store} from "@ngxs/store";
import {LoadPostsAction} from "./components/state/posts.actions";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'client';
  @Select(state => state.posts.posts)
  posts$: Observable<Posts[]>;



  constructor(public store: Store) {}

  ngOnInit(){
    this.store.dispatch(new LoadPostsAction())
  };
}
