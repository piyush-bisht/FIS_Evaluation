package com.fis.tourmain.controller;

import com.fis.tourmain.entity.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TourPackageController {

    @Autowired
    TourPackageRepo tourPackageRepo;

    @GetMapping("/tourPackages")
    public List viewAllPackages(){

        return tourPackageRepo.findAll();
//        return new ResponseEntity<>(packageList, HttpStatus.OK);
    }

    @PostMapping("/tourPackages")
    public ResponseEntity createPackage(@RequestBody TourPackage newPackage){

        try {
            Optional<TourPackage> tp=tourPackageRepo.findBySourcePlaceAndDestinationPlace(newPackage.getSourcePlace(), newPackage.getDestinationPlace());
            if(tp.isPresent())
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            else {
                tourPackageRepo.save(newPackage);
                return new ResponseEntity<>(newPackage, HttpStatus.CREATED);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/tourPackages/{sourcePlace}/{destinationPlace}")
    public ResponseEntity getPackageByAttributes(@PathVariable String sourcePlace, @PathVariable String destinationPlace)
    {
//        System.out.println(sourcePlace+" "+destinationPlace);
        Optional<TourPackage> foundPackage=tourPackageRepo.findBySourcePlaceAndDestinationPlace(sourcePlace,destinationPlace);
        if(foundPackage.isPresent())
            return new ResponseEntity<>(foundPackage.get(),HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
