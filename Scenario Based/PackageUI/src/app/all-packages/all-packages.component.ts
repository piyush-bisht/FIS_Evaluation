import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-packages',
  templateUrl: './all-packages.component.html',
  styleUrls: ['./all-packages.component.css']
})

export class AllPackagesComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }
  
  


   allPackages:any
  
  handleAllPackages(){
    console.log("METHOD CALLED");

    
     
      this.httpClient.get<any>(`http://localhost:8080/tourPackages`)
      .subscribe((data)=>{
        
        this.allPackages=data
        console.log(this.allPackages)
      });
        
    }
  
}
