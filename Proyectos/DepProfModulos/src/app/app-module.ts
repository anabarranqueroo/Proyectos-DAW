import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { provideHttpClient } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ListDept } from './components/list-dept/list-dept';
import { ListProf } from './components/list-prof/list-prof';
import { FormDept } from './components/form-dept/form-dept';
import { FormProf } from './components/form-prof/form-prof';


@NgModule({
  declarations: [
    App,
    ListDept,
    ListProf,
    FormDept,
    FormProf
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(), 
    provideHttpClient()
  ],
  bootstrap: [App]
})
export class AppModule { }
