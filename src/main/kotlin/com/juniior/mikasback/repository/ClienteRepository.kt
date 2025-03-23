package com.juniior.mikasback.repository

import com.juniior.mikasback.models.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long> {
}