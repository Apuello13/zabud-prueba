import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AlertService } from 'src/app/core/service/alert.service';
import { UserService } from 'src/app/core/service/user.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(
    private _user : UserService,
    private _alert : AlertService,
    private router : Router
  ){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(!this._user.isLoginUser()){
      this._alert.info('No se encuentra logueado en el sistema');
      this.router.navigateByUrl('/login');
      return false;
    }
    return true;
  }
  
}
