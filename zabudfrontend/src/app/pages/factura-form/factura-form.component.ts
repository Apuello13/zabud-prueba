import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertService } from 'src/app/core/service/alert.service';
import { UserService } from 'src/app/core/service/user.service';
import { GenericValidateField } from 'src/app/core/utils/genericValidateField';
import { Cliente } from '../models/cliente';
import { Producto } from '../models/producto';
import { ClienteService } from '../service/cliente.service';
import { FacturaService } from '../service/factura.service';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-factura-form',
  templateUrl: './factura-form.component.html',
})
export class FacturaFormComponent implements OnInit, GenericValidateField {
  facturaForm!: FormGroup;
  productos: Producto[] = [];
  clientes: Cliente[] = [];
  constructor(
    private _factura: FacturaService,
    private _producto: ProductoService,
    private _alert: AlertService,
    private _user: UserService,
    private _cliente: ClienteService,
    private formBuilder: FormBuilder,
    private router : Router
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
    this.getProductos();
    this.getClientes();
  }

  getProductos() {
    this._producto.getAll().subscribe(
      (response) => {
        this.productos = response;
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  getClientes() {
    this._cliente.getAll().subscribe(
      (response) => {
        this.clientes = response;
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  saveFactura(){
    this.facturaForm.get('idCajero').setValue(this._user.getUser().id);
    this._factura.save(this.facturaForm.value)
      .subscribe(() => {
        this._alert.success('Factura registrada con exito');
        this.router.navigateByUrl('/facturas');
      }, badRequest => {
        this._alert.error(badRequest);
      })
  }

  validateField(key: string) {
    return (
      (this.facturaForm.get(key).touched ||
        this.facturaForm.get(key).touched) &&
      this.facturaForm.get(key).invalid
    );
  }
}
