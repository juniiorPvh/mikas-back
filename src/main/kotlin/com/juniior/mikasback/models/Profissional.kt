package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Profissional(
    @Id @GeneratedValue val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    val pessoa: Pessoa,

    val especialidade: String,

    @ManyToOne
    val consultorio: Consultorio
)