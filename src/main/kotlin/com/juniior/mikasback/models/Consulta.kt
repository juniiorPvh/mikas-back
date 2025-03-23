package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Consulta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "agendamento_id", referencedColumnName = "id", unique = true)
    val agendamento: Agendamento,

    val tempo: Int, // Tempo em minutos, por exemplo

    val valor: Double,

    val descricao: String
)