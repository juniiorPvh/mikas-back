package com.juniior.mikasback.models

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Pessoa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,

    val email: String,

    val telefone: String,

    val dataNascimento: LocalDate,

    @Enumerated(EnumType.STRING)
    val tipo: TipoPessoa,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    val endereco: Endereco,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Contato
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    val contato: Contato
)
