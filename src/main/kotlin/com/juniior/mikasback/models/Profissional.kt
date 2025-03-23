package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Profissional(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    val pessoa: Pessoa,

    val especialidade: String
)