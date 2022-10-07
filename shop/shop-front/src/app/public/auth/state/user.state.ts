import { Injectable } from '@angular/core';
import { Navigate } from '@ngxs/router-plugin';
import { State, Action, StateContext } from '@ngxs/store';
import { catchError, tap } from 'rxjs';
import { LoginControllerService, UserControllerService } from 'src/api/services';
import { LoginAction, LogoutAction, RegisterAction } from './user.actions';

export class UserStateModel {
  public token: string
}

const defaults = {
  token: null
};

@State<UserStateModel>({
  name: 'user',
  defaults
})
@Injectable()
export class UserState {
  constructor(private readonly userControllerService: UserControllerService, private readonly loginControllerService: LoginControllerService) {
  }
  @Action(LoginAction)
  login({ patchState }: StateContext<UserStateModel>, { loginDto }: LoginAction) {
    return this.loginControllerService.login({ body: loginDto }).pipe(
      tap(response => {
        console.log(response)
        patchState({
          token: response.token
        })
        localStorage.setItem("token", response.token)
      })
    )
  }
  @Action(RegisterAction)
  register({ dispatch }: StateContext<UserStateModel>, { userDto }: RegisterAction) {
    return this.userControllerService.saveUser({ body: userDto }).pipe(
      tap(response => dispatch(new Navigate(["/auth/login"])))
    )

  }
  @Action(LogoutAction)
  logout({ patchState }: StateContext<UserStateModel>) {

    localStorage.removeItem("token")
    patchState({
      token: null
    })
  }
}
