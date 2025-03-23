package com.juniior.mikasback.models

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class Agendamento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val data: LocalDate,

    val horario: LocalTime,

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    val cliente: Pessoa,

    @ManyToOne
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    val profissional: Pessoa
)
