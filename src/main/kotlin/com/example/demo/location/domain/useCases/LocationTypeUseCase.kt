package com.example.demo.location.domain.useCases

import com.example.demo.location.domain.models.LocationType
import com.example.demo.location.domain.ports.`in`.ILocationTypeUseCase
import com.example.demo.location.domain.ports.out.ILocationTypeService
import org.springframework.stereotype.Service


@Service
class LocationTypeUseCase (
    private val locationTypeService: ILocationTypeService
) : ILocationTypeUseCase {
    override fun getAllLocationTypes(): List<LocationType> {
        return locationTypeService.getAllLocationTypes()
    }

    override fun getLocationTypeById(locationTypeId: Long): LocationType? {
        return locationTypeService.getLocationTypeById(locationTypeId)
    }

    override fun createLocationType(locationType: LocationType): LocationType {
        return locationTypeService.addLocationType(locationType)
    }

    override fun updateLocationType(locationType: LocationType): LocationType? {
        return locationTypeService.getLocationTypeById(locationType.locationTypeId)?.let {
            locationTypeService.updateLocationType(locationType)
        }
    }

    override fun deleteLocationTypeById(locationTypeId: Long) {
        locationTypeService.deleteLocationTypeById(locationTypeId)
    }

}