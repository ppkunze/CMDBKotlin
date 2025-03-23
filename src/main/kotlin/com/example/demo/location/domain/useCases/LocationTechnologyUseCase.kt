package com.example.demo.location.domain.useCases


import com.example.demo.location.domain.models.LocationTechnology
import com.example.demo.location.domain.ports.`in`.ILocationTechnologyUseCase
import com.example.demo.location.domain.ports.out.ILocationTechnologyService
import org.springframework.stereotype.Service

@Service
class LocationTechnologyUseCase (
    private val locationTechnologyService: ILocationTechnologyService
) : ILocationTechnologyUseCase {
    override fun getAllLocationTechnologies(): List<LocationTechnology> {
        return locationTechnologyService.getAllLocationTechnologies()
    }

    override fun getLocationTechnologyById(locationTechnologyId: Long): LocationTechnology? {
        return locationTechnologyService.getLocationTechnologyById(locationTechnologyId)
    }

    override fun createLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology {
        return locationTechnologyService.addLocationTechnology(locationTechnology)
    }

    override fun updateLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology? {
        return locationTechnologyService.getLocationTechnologyById(locationTechnology.locationTechnologyId)?.let {
            locationTechnologyService.updateLocationTechnology(locationTechnology)
        }
    }

    override fun deleteLocationTechnologyById(locationTechnologyId: Long) {
        locationTechnologyService.deleteLocationTechnologyById(locationTechnologyId)
    }
}