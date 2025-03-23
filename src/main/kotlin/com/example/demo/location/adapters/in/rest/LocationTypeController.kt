package com.example.demo.location.adapters.`in`.rest

import com.example.demo.location.adapters.`in`.rest.dto.LocationTypeRequestDTO
import com.example.demo.location.domain.models.LocationType
import com.example.demo.location.domain.ports.`in`.ILocationTypeUseCase
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
@RequestMapping("/location-type")
class LocationTypeController (
    private val locationTypeUseCase: ILocationTypeUseCase
){
    @GetMapping
    fun getAllLocationTypes(): List<LocationType> {
        return locationTypeUseCase.getAllLocationTypes()
    }

    @GetMapping("/{locationTypeId}")
    fun getLocationTypeById(locationTypeId: Long): LocationType {
        return locationTypeUseCase.getLocationTypeById(locationTypeId) ?:
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Type not found")
    }

    @PostMapping
    fun createLocationType(@RequestBody locationType: LocationTypeRequestDTO): LocationType {
        return locationTypeUseCase.createLocationType(locationType.toDomain())
    }

    @PostMapping("/{locationTypeId}")
    fun updateLocationType(@PathVariable locationTypeId: Long, @RequestBody locationType: LocationTypeRequestDTO): LocationType {
        return locationTypeUseCase.updateLocationType(locationType.toDomain().copy(locationTypeId=locationTypeId)).let {
            it ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Type not found")
        }
    }

    @DeleteMapping("/{locationTypeId}")
    fun deleteLocationType(@PathVariable locationTypeId: Long): ResponseEntity<Void> {
        locationTypeUseCase.deleteLocationTypeById(locationTypeId)
        return ResponseEntity.ok().build()
    }
}