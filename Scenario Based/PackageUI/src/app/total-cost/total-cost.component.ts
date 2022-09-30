import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-total-cost',
  templateUrl: './total-cost.component.html',
  styleUrls: ['./total-cost.component.css']
})
export class TotalCostComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  totalFareForm=new FormGroup({

   
    sourcePlace:new FormControl(),
    
    destinationPlace:new FormControl(),
    days:new FormControl()
    
    
  })
  handleSubmit(){
    console.log(this.totalFareForm.value)
    let {sourcePlace,destinationPlace,days}=this.totalFareForm.value;
    if(sourcePlace==null||destinationPlace==null||days==null)
      alert("Kindly fill out all the fields")
    else
      this.httpClient.get<any>(`http://localhost:8081/totalFare/${sourcePlace}/${destinationPlace}/${days}`)
    .subscribe((data)=>{console.log(data);
      alert("Total Fare for the Package is : "+data.totalFare)
  },(error)=>{
    alert("Cannot find this tour package, please try again!")
  })
  }
}
