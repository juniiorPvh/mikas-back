package com.juniior.mikasback.repository

import com.juniior.mikasback.models.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long> {
    fun findByCpfCnpj(cpfCnpj: String): Pessoa?
}