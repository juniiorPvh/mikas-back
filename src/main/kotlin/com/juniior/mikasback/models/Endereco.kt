package com.juniior.mikasback.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Endereco(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var rua: String,

    var numero: String,

    var complemento: String? = null,

    var bairro: String,

    var cidade: String,

    var estado: String,

    var cep: String
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
