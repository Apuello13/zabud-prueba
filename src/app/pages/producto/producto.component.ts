import { CurrencyPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from 'src/app/core/service/alert.service';
import { GenericValidateField } from 'src/app/core/utils/genericValidateField';
import { Producto } from '../models/producto';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html'
})
export class ProductoComponent implements OnInit, GenericValidateField {
  productos: Producto[] = [];
  productoForm!: FormGroup;
  constructor(
    private _producto: ProductoService,
    private formBuilder: FormBuilder,
    private _alert: AlertService,
    private pipe : CurrencyPipe
  ) {
    this.initForm();
  }

  initForm() {
    this.productoForm = this.formBuilder.group({
      id: [0],
      nombre: ['', Validators.required],
      precio: ['', Validators.required],
      cantidad: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getProductos();
    this.setPipeField();
  }

  saveProducto() {
    const producto : Producto = this.productoForm.value;
    producto.precio = this.productoForm.get('precio').value.replace(/[,]/g, '');
    this._producto.save(producto).subscribe(
      () => {
        this._alert.success('Producto creado con exito');
        this.getProductos();
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
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

  deleteById(idProducto: number) {
    this._producto.deleteById(idProducto).subscribe(
      () => {
        this._alert.success('Producto eliminado con exito');
        this.getProductos();
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  getById(idProducto: number) {
    this._producto.getById(idProducto).subscribe(
      (response) => {
        this.productoForm.setValue(response);
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  validateField(key: string) {
    return (
      (this.productoForm.get(key).dirty ||
        this.productoForm.get(key).touched) &&
      this.productoForm.get(key).invalid
    );
  }

  setPipeField(){
    this.productoForm.get('precio').valueChanges
      .subscribe((data) => {
        this.productoForm.patchValue({
          precio : this.pipe.transform(
              data.toString().replace(/\D/g, '').replace(/^/, ''),
              '',
              '',
              '1.0-0'
          )
      }, { emitEvent: false })
      })
  }
}
