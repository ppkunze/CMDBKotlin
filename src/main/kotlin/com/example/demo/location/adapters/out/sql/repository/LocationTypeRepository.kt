package com.example.demo.location.adapters.out.sql.repository


import com.example.demo.location.adapters.out.sql.entitys.LocationTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationTypeRepository : JpaRepository<LocationTypeEntity, Long>