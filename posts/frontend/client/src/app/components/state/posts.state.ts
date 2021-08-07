import { Injectable } from '@angular/core';
import { State, Action, StateContext } from '@ngxs/store';
import { LoadPostsAction } from './posts.actions';
import {HttpClient} from "@angular/common/http";
import {tap} from "rxjs/operators";
export interface  Posts{
  id: number,
  userId: number,
  title: string,
  body: string
}
export class PostsStateModel {
  public posts: Posts[];
}

const defaults = {
  posts: []
};

@State<PostsStateModel>({
  name: 'posts',
  defaults
})
@Injectable()
export class PostsState {
constructor(public httpClient: HttpClient) {
}
  @Action(LoadPostsAction)
  load({ getState, setState, patchState }: StateContext<PostsStateModel>, {  }: LoadPostsAction) {
  return this.httpClient.get<Posts[]>('https://jsonplaceholder.typicode.com/posts').pipe(tap(response =>{
patchState({posts:response})
  }));
  }

}
