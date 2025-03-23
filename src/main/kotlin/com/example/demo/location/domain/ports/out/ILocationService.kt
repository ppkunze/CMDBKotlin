package com.example.demo.location.domain.ports.out

import com.example.demo.location.domain.models.Location

interface ILocationService {
    fun getAllLocations(): List<Location>
    fun addLocation(location: Location): Location
    fun getLocationById(id: Long): Location?
    fun updateLocation(location: Location): Location
    fun deleteLocationById(id: Long)
}