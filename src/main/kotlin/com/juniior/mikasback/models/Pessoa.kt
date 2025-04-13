package com.juniior.mikasback.models

import jakarta.persistence.*
import java.time.LocalDate
import javax.validation.constraints.NotNull

@Entity
data class Pessoa(
    @Id @GeneratedValue val id: Long? = null,

    val nome: String,

    @Column(nullable = false, unique = true)
    @NotNull(message = "CPF/CNPJ não pode ser nulo")
    val cpfCnpj: String,

    val dataNascimento: LocalDate,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    val endereco: Endereco,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Contato
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    val contato: Contato
)
