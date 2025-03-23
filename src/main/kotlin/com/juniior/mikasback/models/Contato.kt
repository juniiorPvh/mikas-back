package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Contato(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val telefone: String,

    val email: String,

    val site: String? = null // Opcional
)
