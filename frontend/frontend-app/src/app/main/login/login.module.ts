import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { CoreModule } from 'src/app/core/core.module';


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    CoreModule,
    LoginRoutingModule
  ],
  exports: [
    CoreModule
  ]
})
export class LoginModule { }
