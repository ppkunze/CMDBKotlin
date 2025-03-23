package com.example.demo.location.adapters.out.sql.entitys

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "location_type")
data class LocationTypeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val locationTypeId: Long = 0,
    val name: String
)