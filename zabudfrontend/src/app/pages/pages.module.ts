import { CurrencyPipe } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ClienteComponent } from './cliente/cliente.component';
import { FacturaComponent } from './factura/factura.component';
import { HomeComponent } from './home/home.component';
import { ProductoComponent } from './producto/producto.component';
import { ClienteService } from './service/cliente.service';
import { FacturaService } from './service/factura.service';
import { ProductoService } from './service/producto.service';

@NgModule({
  declarations: [
    ProductoComponent,
    ClienteComponent,
    FacturaComponent,
    HomeComponent,
  ],
  imports: [
    SharedModule
  ],
  providers: [
    ProductoService,
    ClienteService,
    FacturaService,
    CurrencyPipe
  ]
})
export class PagesModule { }
