package com.juniior.mikasback.models

import jakarta.persistence.*

@Entity
data class Contato(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val telefone: String,

    val email: String,

    val site: String? = null // Opcional
) {
    override fun toString(): String {
        return "Contato(id=$id, telefone='$telefone', email='$email', site=$site)"
    }

    constructor() : this(
        id = 0,
        telefone = "",
        email = "",
        site = null
    ) {
        // Construtor vazio para uso em frameworks como Hibernate
    }
}
