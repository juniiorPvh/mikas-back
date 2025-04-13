package com.juniior.mikasback.models

import jakarta.persistence.*

data class Usuario(
    @Id @GeneratedValue val id: Long? = null,
    val email: String,
    val senha: String,

    @Enumerated(EnumType.STRING)
    val papel: PapelUsuario,

    @ManyToOne
    val consultorio: Consultorio,

    @OneToOne
    val pessoa: Pessoa

)

