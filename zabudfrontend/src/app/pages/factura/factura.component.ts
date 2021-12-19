import { Component, OnInit } from '@angular/core';
import { AlertService } from 'src/app/core/service/alert.service';
import { Factura } from '../models/factura';
import { FacturaService } from '../service/factura.service';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
})
export class FacturaComponent implements OnInit {
  facturas: Factura[] = [];
  factura: Factura = null;
  constructor(private _factura: FacturaService, private _alert: AlertService) {}

  ngOnInit(): void {
    this.getFacturas();
    this.initFactura();
  }

  getFacturas() {
    this._factura.getAll().subscribe(
      (response) => {
        this.facturas = response;
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  getById(idCliente: number) {
    this._factura.getById(idCliente).subscribe(
      (response) => {
        this.factura = response;
        console.log(response);
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  deleteById(idFactura: number) {
    this._factura.deleteById(idFactura).subscribe(
      () => {
        this._alert.success('Factura eliminada con exito');
        this.getFacturas();
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  initFactura() {
    this.factura = {
      id: 0,
      cliente: '',
      numeroFactura: '',
      productos: [],
      created: '',
      metodoPago: '',
    };
  }
}
