package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Endereco(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val rua: String,

    val numero: String,

    val complemento: String? = null,

    val bairro: String,

    val cidade: String,

    val estado: String,

    val cep: String
)
