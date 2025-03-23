package com.example.demo.location.adapters.out.sql.repository

import com.example.demo.location.adapters.out.sql.entitys.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository<LocationEntity, Long>, JpaSpecificationExecutor<LocationEntity>