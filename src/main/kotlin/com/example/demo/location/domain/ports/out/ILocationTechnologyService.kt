package com.example.demo.location.domain.ports.out

import com.example.demo.location.domain.models.LocationTechnology

interface ILocationTechnologyService {
    fun getAllLocationTechnologies(): List<LocationTechnology>
    fun addLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology
    fun getLocationTechnologyById(id: Long): LocationTechnology?
    fun updateLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology
    fun deleteLocationTechnologyById(id: Long)
}