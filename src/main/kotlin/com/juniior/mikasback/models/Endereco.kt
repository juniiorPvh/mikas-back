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
) {
    override fun toString(): String {
        return "Endereco(id=$id, rua='$rua', numero='$numero', complemento=$complemento, bairro='$bairro', cidade='$cidade', estado='$estado', cep='$cep')"
    }

    constructor() : this(
        id = 0,
        rua = "",
        numero = "",
        complemento = null,
        bairro = "",
        cidade = "",
        estado = "",
        cep = ""
    ) {
        // Construtor vazio para uso em frameworks como Hibernate
    }
}
