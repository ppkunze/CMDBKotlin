package com.example.demo.location.adapters.out.sql.repository

import com.example.demo.location.adapters.out.sql.entitys.LocationTechnologyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface LocationTechnologyRepository : JpaRepository<LocationTechnologyEntity, Long>