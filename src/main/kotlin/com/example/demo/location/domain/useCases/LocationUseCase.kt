package com.example.demo.location.domain.useCases

import com.example.demo.location.domain.models.Location
import com.example.demo.location.domain.ports.`in`.ILocationUseCase
import com.example.demo.location.domain.ports.out.ILocationService
import org.springframework.stereotype.Service


@Service
class LocationUseCase (
    private val locationService: ILocationService
) : ILocationUseCase {
    override fun getAllLocations(): List<Location> {
        return locationService.getAllLocations()
    }

    override fun createLocation(location: Location): Location {
        return locationService.addLocation(location)
    }

    override fun getLocationById(id: Long): Location? {
        return locationService.getLocationById(id)
    }

    override fun updateLocation(location: Location): Location? {
        return locationService.getLocationById(location.locationId)?.let {
            locationService.updateLocation(location)
        }
    }

    override fun deleteLocationById(id: Long) {
        locationService.deleteLocationById(id)
    }
}