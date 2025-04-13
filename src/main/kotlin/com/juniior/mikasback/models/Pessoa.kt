package com.juniior.mikasback.models

import jakarta.persistence.*
import java.time.LocalDate
import javax.validation.constraints.NotNull

@Entity
data class Pessoa(
    @Id @GeneratedValue val id: Long? = null,

    var nome: String,

    @Column(nullable = false, unique = true)
    @NotNull(message = "CPF/CNPJ não pode ser nulo")
    var cpfCnpj: String,

    var dataNascimento: LocalDate?,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    var endereco: Endereco? = null,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Contato
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    var contato: Contato? = null
) {
    constructor() : this(
        id = null,
        nome = "",
        cpfCnpj = "",
        dataNascimento = null,
        endereco = null,
        contato = null
    ) {

    }
}
