package com.example.demo.location.adapters.`in`.rest.dto

data class LocationRequestDTO(
    val name: String,
    val address: String?,
    val locationTypeId: Long,
    val locationTechnologyId: Long
)
