package com.example.demo.location.domain.ports.`in`

import com.example.demo.location.domain.models.Location

interface ILocationUseCase {
    fun getAllLocations(): List<Location>
    fun createLocation(location: Location): Location
    fun getLocationById(id: Long): Location?
    fun updateLocation(location: Location): Location?
    fun deleteLocationById(id: Long)
}