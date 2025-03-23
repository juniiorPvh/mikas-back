package com.juniior.mikasback.repository

import com.juniior.mikasback.models.Cliente
import com.juniior.mikasback.models.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long> {
    fun findByPessoa(pessoa: Pessoa): Cliente?
}