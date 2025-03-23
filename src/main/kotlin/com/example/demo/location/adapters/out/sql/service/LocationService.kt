package com.example.demo.location.adapters.out.sql.service

import com.example.demo.location.adapters.out.sql.repository.LocationRepository
import com.example.demo.location.adapters.out.sql.toDomain
import com.example.demo.location.adapters.out.sql.toEntity
import com.example.demo.location.domain.models.Location
import com.example.demo.location.domain.ports.out.ILocationService
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository): ILocationService {
    override fun getAllLocations(): List<Location> {
        return locationRepository.findAll().map { it.toDomain() }
    }

    override fun addLocation(location: Location): Location {
        return locationRepository.save(location.toEntity()).toDomain()
    }

    override fun getLocationById(id: Long): Location? {
        return locationRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun updateLocation(location: Location): Location {
        return locationRepository.save(location.toEntity()).toDomain()
    }

    override fun deleteLocationById(id: Long) {
        return locationRepository.deleteById(id)
    }
}