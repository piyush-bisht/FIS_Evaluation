package com.fis.tourmain.controller;

import com.fis.tourmain.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourPackageRepo extends JpaRepository<TourPackage, Integer> {

    Optional<TourPackage> findBySourcePlaceAndDestinationPlace(String sourcePlace, String destinationPlace);
}
