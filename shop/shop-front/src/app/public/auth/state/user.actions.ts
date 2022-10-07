import { LoginDto, UserDto } from "src/api/models";

export class LoginAction {
  static readonly type = '[User] LoginAction';
  constructor(public loginDto: LoginDto) { }
}
export class RegisterAction {
  static readonly type = '[User] RegisterAction';
  constructor(public userDto: UserDto) { }
}

export class LogoutAction{
  static readonly type = '[User] LogoutAction';
  constructor(){}
}