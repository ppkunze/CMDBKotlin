package com.example.demo.location.adapters.`in`.rest

import com.example.demo.location.adapters.`in`.rest.dto.LocationRequestDTO
import com.example.demo.location.domain.models.Location
import com.example.demo.location.domain.ports.`in`.ILocationTechnologyUseCase
import com.example.demo.location.domain.ports.`in`.ILocationTypeUseCase
import com.example.demo.location.domain.ports.`in`.ILocationUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/location")
class LocationController (
    private val locationUseCase: ILocationUseCase,
    private val locationTypeUseCase: ILocationTypeUseCase,
    private val locationTechnologyUseCase: ILocationTechnologyUseCase
){
    @GetMapping
    fun getAllLocations(): List<Location> {
        return locationUseCase.getAllLocations()
    }

    @GetMapping("/{locationId}")
    fun getLocationById(@PathVariable locationId: Long): Location {
        return locationUseCase.getLocationById(locationId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location not found")
    }

    @PostMapping
    fun createLocation(@RequestBody location: LocationRequestDTO): Location {
        val locationType = locationTypeUseCase.getLocationTypeById(location.locationTypeId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Type not found")
        val locationTechnology = locationTechnologyUseCase.getLocationTechnologyById(location.locationTechnologyId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Technology not found")
        return locationUseCase.createLocation(location.toDomain(locationType, locationTechnology))
    }

    @PostMapping("/{locationId}")
    fun updateLocation(@PathVariable locationId: Long, @RequestBody location: LocationRequestDTO): Location {
        val locationType = locationTypeUseCase.getLocationTypeById(location.locationTypeId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Type not found")
        val locationTechnology = locationTechnologyUseCase.getLocationTechnologyById(location.locationTechnologyId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Technology not found")
        return locationUseCase.updateLocation(location.toDomain(locationType, locationTechnology).copy(locationId=locationId)).let {
            it ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location not found")
        }
    }

    @DeleteMapping("/{locationId}")
    fun deleteLocation(@PathVariable locationId: Long): ResponseEntity<Void>  {
        locationUseCase.deleteLocationById(locationId)
        return ResponseEntity.ok().build()
    }
}