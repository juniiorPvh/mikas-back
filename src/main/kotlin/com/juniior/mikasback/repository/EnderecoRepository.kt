package com.juniior.mikasback.repository


import com.juniior.mikasback.models.Endereco
import org.springframework.data.jpa.repository.JpaRepository

interface EnderecoRepository : JpaRepository<Endereco, Long>