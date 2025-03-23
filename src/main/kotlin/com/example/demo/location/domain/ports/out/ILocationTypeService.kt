package com.example.demo.location.domain.ports.out

import com.example.demo.location.domain.models.LocationType

interface ILocationTypeService {
    fun getAllLocationTypes(): List<LocationType>
    fun addLocationType(locationType: LocationType): LocationType
    fun getLocationTypeById(id: Long): LocationType?
    fun updateLocationType(locationType: LocationType): LocationType
    fun deleteLocationTypeById(id: Long)
}