import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from 'src/app/core/service/alert.service';
import { closeModal } from 'src/app/core/utils/closeModal';
import { GenericValidateField } from 'src/app/core/utils/genericValidateField';
import { Cliente } from '../models/cliente';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html'
})
export class ClienteComponent implements OnInit, GenericValidateField {
  clienteForm!: FormGroup;
  clientes: Cliente[] = [];
  constructor(
    private formBuilder: FormBuilder,
    private _cliente: ClienteService,
    private _alert: AlertService
  ) {
    this.initForm();
  }

  initForm() {
    this.clienteForm = this.formBuilder.group({
      id: [0],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      email: ['', Validators.required],
      telefono: ['', Validators.required],
      numeroDocumento: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getClientes();
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

  getById(idCliente: number) {
    this._cliente.getById(idCliente).subscribe(
      (response) => {
        this.clienteForm.setValue(response);
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  saveCliente() {
    this._cliente.save(this.clienteForm.value).subscribe(
      () => {
        this._alert.success('Cliente creado con exito');
        this.getClientes();
        closeModal();
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  deleteById(idCliente: number) {
    this._cliente.deleteById(idCliente).subscribe(
      () => {
        this._alert.success('Cliente eliminado con exito');
        this.getClientes();
      },
      (badRequest) => {
        this._alert.error(badRequest);
      }
    );
  }

  cleanForm() {
    this.clienteForm.reset();
  }

  validateField(key: string) {
    return (
      (this.clienteForm.get(key).dirty ||
      this.clienteForm.get(key).touched) &&
      this.clienteForm.get(key).invalid
    );
  }
}
