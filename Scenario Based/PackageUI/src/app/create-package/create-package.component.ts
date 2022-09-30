import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-package',
  templateUrl: './create-package.component.html',
  styleUrls: ['./create-package.component.css']
})
export class CreatePackageComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  packageForm=new FormGroup({

    package_id:new FormControl(),
    sourcePlace:new FormControl(),
    basic_fare:new FormControl(),
    destinationPlace:new FormControl()
    
    
  })
  handleSubmit(){
    console.log(this.packageForm.value)
    let {package_id,sourcePlace,basic_fare,destinationPlace}=this.packageForm.value;
    if(package_id==null||sourcePlace==null||basic_fare==null||destinationPlace==null)
      alert("Kindly fill out all the fields")
    else if(this.packageForm.value.package_id.length <7)
      alert('Kindly set package id to more than 7 chars')
    else
      this.httpClient.post<any>("http://localhost:8080/tourPackages",this.packageForm.value)
      .subscribe((data)=>{console.log(data)
      alert("created package successfully!")},
      (error)=>{
      alert("Cannot create this tour package, either this already exist or please try again with different entries")})
  }
}
