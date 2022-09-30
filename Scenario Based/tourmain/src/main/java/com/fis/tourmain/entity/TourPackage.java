package com.fis.tourmain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tour_package")
public class TourPackage {

    @Id

    private String package_id;


    private String sourcePlace;

    private int basic_fare;


    private String destinationPlace;

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }



    public int getBasic_fare() {
        return basic_fare;
    }

    public void setBasic_fare(int basic_fare) {
        this.basic_fare = basic_fare;
    }


    public String getSourcePlace() {
        return sourcePlace;
    }

    public void setSourcePlace(String sourcePlace) {
        this.sourcePlace = sourcePlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }
}
