import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  nombreUsuario: string = '';
  constructor(
    private _user: UserService,
    private router : Router
  ) {}

  ngOnInit(): void {
    this.getNombreUsuario();
  }

  getNombreUsuario() {
    this.nombreUsuario = this._user.getUser().nombre;
  }

  logOut(){
    this._user.deleteUser();
    this.router.navigateByUrl('/login');
  }
}
