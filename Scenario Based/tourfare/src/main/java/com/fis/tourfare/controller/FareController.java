package com.fis.tourfare.controller;

import com.fis.tourfare.entity.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class FareController {

   @Autowired
    RestTemplate restTemplate;

    public double getDiscount(int days)
    {
        if(days<=5)
            return 0;
        else if(days>5 && days<=8)
            return 0.03;
        else if(days >8 && days<=10)
            return 0.05;
        else
            return 0.07;

    }
    public double getTotalCost(int fare,int days)
    {
        double totalPrice=(fare*days);
        double discountValue=getDiscount(days)*totalPrice;
        double priceAfterDiscount=totalPrice - discountValue;
        System.out.println("Total Price= "+totalPrice);
        System.out.println("AFTER DISCOUNT= "+priceAfterDiscount);
        double GSTApplicable=priceAfterDiscount*0.12;
        System.out.println("GST Applicable= "+GSTApplicable);
        return priceAfterDiscount+GSTApplicable;
    }
    @GetMapping("/totalFare/{sourcePlace}/{destinationPlace}/{days}")
    public ResponseEntity getTotalFare(@PathVariable String sourcePlace,@PathVariable String destinationPlace, @PathVariable int days)
    {
        Map<String,String> data=new HashMap<>();
        System.out.println(sourcePlace+" "+destinationPlace+" "+days);
        data.put("sourcePlace",sourcePlace);
        data.put("destinationPlace",destinationPlace);

        ResponseEntity rs=restTemplate.getForEntity("http://localhost:8080/tourPackages/{sourcePlace}/{destinationPlace}", TourPackage.class,data);
        if(rs.getStatusCode().equals(HttpStatus.FOUND))
        {
            TourPackage foundPackage=(TourPackage) rs.getBody();
            foundPackage.setTotalFare(this.getTotalCost(foundPackage.getBasic_fare(),days));

            return new ResponseEntity<>(foundPackage,HttpStatus.OK);
        }
        return rs;
    }

}
