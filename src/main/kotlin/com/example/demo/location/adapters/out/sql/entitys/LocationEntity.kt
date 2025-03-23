package com.example.demo.location.adapters.out.sql.entitys

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "location")
data class LocationEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val locationId: Long = 0,
    val name: String = "",
    val address: String? = null,

    @ManyToOne
    @JoinColumn(name = "location_type_id")
    val locationType: LocationTypeEntity,

    @ManyToOne
    @JoinColumn(name = "location_technology_id")
    val locationTechnology: LocationTechnologyEntity
)