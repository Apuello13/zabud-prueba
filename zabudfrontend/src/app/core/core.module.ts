import { NgModule } from '@angular/core';
import { HeaderComponent } from './header/header.component';
import { LayoutComponent } from './layout/layout.component';
import { SharedModule } from '../shared/shared.module';
import { AlertComponent } from './alert/alert.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    HeaderComponent,
    LayoutComponent,
    AlertComponent,
    NotFoundComponent
  ],
  imports: [
    SharedModule
  ],
  exports: [
    AlertComponent
  ]
})
export class CoreModule { }
