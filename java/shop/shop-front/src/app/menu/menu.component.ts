import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Select, Store } from '@ngxs/store';
import { LogoutAction } from '../public/auth/state/user.actions';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  @Select(state => state.user.token)
  token$: Observable<string>

  constructor(private breakpointObserver: BreakpointObserver, private readonly store: Store) { }

  logout() {
    this.store.dispatch(new LogoutAction())
  }
}
