package com.juniior.mikasback.models

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Avaliacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val data: LocalDate,

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    val cliente: Pessoa,

    @ManyToOne
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    val profissional: Pessoa,

    val descricao: String
)
