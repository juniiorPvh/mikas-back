package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var email: String,
    var senha: String,

    @Enumerated(EnumType.STRING)
    var papel: PapelUsuario,

    @ManyToOne
    val consultorio: Consultorio,

    @OneToOne
    val pessoa: Pessoa

) {
    constructor() : this(
        id = 0,
        email = "",
        senha = "",
        papel = PapelUsuario.PACIENTE,
        consultorio = Consultorio(),
        pessoa = Pessoa(
            nome = "",
            cpfCnpj = "",
            dataNascimento = null,
            email = "",
            endereco = Endereco(),
            contato = Contato()
        )
    ) {

    }
}

