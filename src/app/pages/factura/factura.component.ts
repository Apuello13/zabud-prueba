import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from 'src/app/core/service/alert.service';
import { Factura } from '../models/factura';
import { FacturaService } from '../service/factura.service';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html'
})
export class FacturaComponent implements OnInit {
  facturaForm!: FormGroup;
  facturas: Factura[] = [];
  constructor(
    private _factura: FacturaService,
    private _alert: AlertService,
    private formBuilder: FormBuilder
  ) {
    this.initForm();
  }

  initForm() {
    this.facturaForm = this.formBuilder.group({
      id: [0],
      idCliente: ['', Validators.required],
      idCajero: [''],
      productos: ['', Validators.required],
      metodoPago: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getFacturas();
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
      (response) => {},
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
}
