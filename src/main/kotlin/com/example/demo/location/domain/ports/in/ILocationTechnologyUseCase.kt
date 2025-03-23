package com.example.demo.location.domain.ports.`in`

import com.example.demo.location.domain.models.LocationTechnology

interface ILocationTechnologyUseCase {
    fun getAllLocationTechnologies(): List<LocationTechnology>
    fun getLocationTechnologyById(locationTechnologyId: Long): LocationTechnology?
    fun createLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology
    fun updateLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology?
    fun deleteLocationTechnologyById(locationTechnologyId: Long)
}