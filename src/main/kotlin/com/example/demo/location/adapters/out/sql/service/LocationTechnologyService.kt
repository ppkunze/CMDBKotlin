package com.example.demo.location.adapters.out.sql.service

import com.example.demo.location.adapters.out.sql.repository.LocationTechnologyRepository
import com.example.demo.location.adapters.out.sql.toDomain
import com.example.demo.location.adapters.out.sql.toEntity
import com.example.demo.location.domain.models.LocationTechnology
import com.example.demo.location.domain.ports.out.ILocationTechnologyService
import org.springframework.stereotype.Service

@Service
class LocationTechnologyService(private val locationTechnologyRepository: LocationTechnologyRepository) : ILocationTechnologyService {
    override fun getAllLocationTechnologies(): List<LocationTechnology> {
        return locationTechnologyRepository.findAll().map { it.toDomain() }
    }

    override fun addLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology {
        return locationTechnologyRepository.save(locationTechnology.toEntity()).toDomain()
    }

    override fun getLocationTechnologyById(id: Long): LocationTechnology? {
        return locationTechnologyRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun updateLocationTechnology(locationTechnology: LocationTechnology): LocationTechnology {
        return locationTechnologyRepository.save(locationTechnology.toEntity()).toDomain()
    }

    override fun deleteLocationTechnologyById(id: Long) {
        locationTechnologyRepository.deleteById(id)
    }
}