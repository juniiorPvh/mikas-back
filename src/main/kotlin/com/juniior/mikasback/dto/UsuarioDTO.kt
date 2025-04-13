package com.juniior.mikasback.dto

import com.juniior.mikasback.models.PapelUsuario

data class UsuarioDTO(
    val email: String,
    val senha: String,
    val papel: PapelUsuario,
    val consultorioId: Long,
    val pessoa: PessoaDTO
)
