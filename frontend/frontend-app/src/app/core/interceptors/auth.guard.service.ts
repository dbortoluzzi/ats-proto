import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

    /**
     * Da aggiungere la logica per capire se la login e' già avvenuta o meno
     */

    // Login non avvenuto, forza la richiesta di credenziali
    //this.router.navigate(['login']);
    return true;
  }
}
