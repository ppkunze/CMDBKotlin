package com.example.demo.location.domain.ports.`in`

import com.example.demo.location.domain.models.LocationType

interface ILocationTypeUseCase {
    fun getAllLocationTypes(): List<LocationType>
    fun getLocationTypeById(locationTypeId: Long): LocationType?
    fun createLocationType(locationType: LocationType): LocationType
    fun updateLocationType(locationType: LocationType): LocationType?
    fun deleteLocationTypeById(locationTypeId: Long)
}