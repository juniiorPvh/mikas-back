package com.juniior.mikasback.repository

import com.juniior.mikasback.models.PapelUsuario
import com.juniior.mikasback.models.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {
    fun findByEmail(email: String): Usuario?
    fun findByPapel(papel: PapelUsuario): List<Usuario>
}