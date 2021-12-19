import { Component, OnInit } from '@angular/core';
import { AlertService } from 'src/app/core/service/alert.service';
import { Dashboard } from '../models/dashboard';
import { DashboardService } from '../service/dashboard.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  dashboard : Dashboard = { facturas: 0, clientes: 0, productos: 0};
  constructor(
    private _dashboard : DashboardService,
    private _alert : AlertService
  ) { }

  ngOnInit(): void {
    this.getDashboard();
  }

  getDashboard(){
    this._dashboard.getDashboard()
      .subscribe(response => {
        this.dashboard = response;
      }, badRequest => {
        this._alert.error(badRequest);
      })
  }
}
