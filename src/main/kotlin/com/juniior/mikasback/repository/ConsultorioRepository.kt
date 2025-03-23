package com.juniior.mikasback.repository

import com.juniior.mikasback.models.Consultorio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsultorioRepository : JpaRepository<Consultorio, Long>