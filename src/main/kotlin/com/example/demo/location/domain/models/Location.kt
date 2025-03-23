package com.example.demo.location.domain.models

data class Location (
    val locationId: Long = 0,
    val name: String,
    val address: String?,
    val locationType: LocationType,
    val locationTechnology: LocationTechnology
)