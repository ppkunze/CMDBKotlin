package com.example.demo.location.adapters.`in`.rest

import com.example.demo.location.adapters.`in`.rest.dto.LocationRequestDTO
import com.example.demo.location.adapters.`in`.rest.dto.LocationTechnologyRequestDTO
import com.example.demo.location.adapters.`in`.rest.dto.LocationTypeRequestDTO
import com.example.demo.location.domain.models.Location
import com.example.demo.location.domain.models.LocationTechnology
import com.example.demo.location.domain.models.LocationType

fun LocationRequestDTO.toDomain(
    locationType: LocationType,
    locationTechnology: LocationTechnology
): Location {
    return Location(
        name = this.name,
        address = this.address,
        locationType = locationType,
        locationTechnology = locationTechnology
    )
}

fun LocationTypeRequestDTO.toDomain(): LocationType {
    return LocationType(
        name = this.name
    )
}

fun LocationTechnologyRequestDTO.toDomain(): LocationTechnology {
    return LocationTechnology(
        name = this.name
    )
}