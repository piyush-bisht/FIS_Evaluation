import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllPackagesComponent } from './all-packages/all-packages.component';
import { CreatePackageComponent } from './create-package/create-package.component';
import { LandingComponent } from './landing/landing.component';
import { TotalCostComponent } from './total-cost/total-cost.component';

const routes: Routes = [
  {path:"",pathMatch:"full",component:LandingComponent},
  {path:"createPackage",component:CreatePackageComponent},
  {path:"getTotalCost",component:TotalCostComponent},
  {path:"getAllPackages",component:AllPackagesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
