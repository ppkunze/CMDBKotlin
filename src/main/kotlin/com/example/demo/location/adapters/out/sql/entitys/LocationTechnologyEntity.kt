package com.example.demo.location.adapters.out.sql.entitys

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "location_technology")
data class LocationTechnologyEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val locationTechnologyId: Long = 0,
    val name: String
)