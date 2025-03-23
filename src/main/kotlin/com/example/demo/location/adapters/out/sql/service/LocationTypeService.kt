package com.example.demo.location.adapters.out.sql.service

import com.example.demo.location.adapters.out.sql.repository.LocationTypeRepository
import com.example.demo.location.adapters.out.sql.toDomain
import com.example.demo.location.adapters.out.sql.toEntity
import com.example.demo.location.domain.models.LocationType
import com.example.demo.location.domain.ports.out.ILocationTypeService
import org.springframework.stereotype.Service

@Service
class LocationTypeService(private val locationTypeRepository: LocationTypeRepository) : ILocationTypeService {
    override fun getAllLocationTypes(): List<LocationType> {
        return locationTypeRepository.findAll().map { it.toDomain() }
    }

    override fun addLocationType(locationType: LocationType): LocationType {
        return locationTypeRepository.save(locationType.toEntity()).toDomain()
    }

    override fun getLocationTypeById(id: Long): LocationType? {
        return locationTypeRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun updateLocationType(locationType: LocationType): LocationType {
        return locationTypeRepository.save(locationType.toEntity()).toDomain()
    }

    override fun deleteLocationTypeById(id: Long) {
        locationTypeRepository.deleteById(id)
    }
}