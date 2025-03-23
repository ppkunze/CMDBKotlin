package com.example.demo.location.adapters.out.sql

import com.example.demo.location.adapters.out.sql.entitys.LocationEntity
import com.example.demo.location.adapters.out.sql.entitys.LocationTechnologyEntity
import com.example.demo.location.adapters.out.sql.entitys.LocationTypeEntity
import com.example.demo.location.domain.models.LocationTechnology
import com.example.demo.location.domain.models.LocationType

import com.example.demo.location.domain.models.Location

fun LocationEntity.toDomain(): Location {
    return Location(
        locationId = this.locationId,
        name = this.name,
        address = this.address,
        locationType = this.locationType.toDomain(),
        locationTechnology = this.locationTechnology.toDomain()
    )
}

fun Location.toEntity(): LocationEntity {
    return LocationEntity(
        locationId = this.locationId,
        name = this.name,
        address = this.address,
        locationType = this.locationType.toEntity(),
        locationTechnology = this.locationTechnology.toEntity()
    )
}

fun LocationTechnologyEntity.toDomain(): LocationTechnology {
    return LocationTechnology(
        locationTechnologyId = this.locationTechnologyId,
        name = this.name
    )
}

fun LocationTechnology.toEntity(): LocationTechnologyEntity {
    return LocationTechnologyEntity(
        locationTechnologyId = this.locationTechnologyId,
        name = this.name
    )
}

fun LocationTypeEntity.toDomain(): LocationType {
    return LocationType(
        locationTypeId = this.locationTypeId,
        name = this.name
    )
}

fun LocationType.toEntity(): LocationTypeEntity {
    return LocationTypeEntity(
        locationTypeId = this.locationTypeId,
        name = this.name
    )
}