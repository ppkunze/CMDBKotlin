package com.example.demo.location.adapters.`in`.rest

import com.example.demo.location.adapters.`in`.rest.dto.LocationTechnologyRequestDTO
import com.example.demo.location.domain.models.LocationTechnology
import com.example.demo.location.domain.ports.`in`.ILocationTechnologyUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/location-technology")
class LocationTechnologyController (
    private val locationTechnologyUseCase: ILocationTechnologyUseCase
) {
    @GetMapping
    fun getAllLocationTechnology(): List<LocationTechnology> {
        return locationTechnologyUseCase.getAllLocationTechnologies()
    }

    @GetMapping("/{locationTechnologyId}")
    fun getLocationTypeById(@PathVariable locationTechnologyId: Long): LocationTechnology {
        return locationTechnologyUseCase.getLocationTechnologyById(locationTechnologyId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Technology not found")
    }

    @PostMapping
    fun createLocationType(@RequestBody locationTechnology: LocationTechnologyRequestDTO): LocationTechnology {
        return locationTechnologyUseCase.createLocationTechnology(locationTechnology.toDomain())
    }

    @PostMapping("/{locationTechnologyId}")
    fun updateLocationType(@PathVariable locationTechnologyId: Long, @RequestBody locationTechnology: LocationTechnologyRequestDTO): LocationTechnology {
        return locationTechnologyUseCase.updateLocationTechnology(locationTechnology.toDomain().copy(locationTechnologyId=locationTechnologyId)).let {
            it ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Technology not found")
        }
    }

    @DeleteMapping("/{locationTechnologyId}")
    fun deleteLocationType(@PathVariable locationTechnologyId: Long): ResponseEntity<Void> {
        locationTechnologyUseCase.deleteLocationTechnologyById(locationTechnologyId)
        return ResponseEntity.ok().build()
    }
}