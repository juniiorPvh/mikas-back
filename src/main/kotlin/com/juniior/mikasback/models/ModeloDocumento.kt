package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class ModeloDocumento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,

    val conteudo: String, // Texto com placeholders

    @Enumerated(EnumType.STRING)
    val tipo: TipoDocumento
)
