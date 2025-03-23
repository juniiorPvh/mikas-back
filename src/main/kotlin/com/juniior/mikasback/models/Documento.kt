package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Documento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "avaliacao_id", referencedColumnName = "id")
    val avaliacao: Avaliacao,

    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    val modelo: ModeloDocumento,

    val conteudoPreenchido: String // Texto gerado após preenchimento do modelo
)
