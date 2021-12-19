import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { LayoutComponent } from './core/layout/layout.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { FacturaComponent } from './pages/factura/factura.component';
import { UserGuard } from './pages/guards/user.guard';
import { FacturaFormComponent } from './pages/factura-form/factura-form.component';
import { NotFoundComponent } from './core/not-found/not-found.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'productos', component: ProductoComponent },
      { path: 'clientes', component: ClienteComponent },
      { path: 'facturas', component: FacturaComponent },
      { path: 'factura-form', component: FacturaFormComponent },
      { path: '', redirectTo: '/home', pathMatch: 'full' },
    ],
    canActivate: [UserGuard],
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
