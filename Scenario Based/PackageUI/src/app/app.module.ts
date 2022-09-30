import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePackageComponent } from './create-package/create-package.component';
import { TotalCostComponent } from './total-cost/total-cost.component';
import { LandingComponent } from './landing/landing.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AllPackagesComponent } from './all-packages/all-packages.component'
@NgModule({
  declarations: [
    AppComponent,
    CreatePackageComponent,
    TotalCostComponent,
    LandingComponent,
    AllPackagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
