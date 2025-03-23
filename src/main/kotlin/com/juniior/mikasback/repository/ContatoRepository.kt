package com.juniior.mikasback.repository

import com.juniior.mikasback.models.Contato
import org.springframework.data.jpa.repository.JpaRepository

interface ContatoRepository : JpaRepository<Contato, Long>