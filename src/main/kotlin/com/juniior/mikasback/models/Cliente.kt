package com.juniior.mikasback.models

import jakarta.persistence.*


@Entity
data class Cliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    val pessoa: Pessoa,

    @ManyToOne
    @JoinColumn(name = "plano_saude_id", referencedColumnName = "id")
    val planoSaude: PlanoSaude?,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    val endereco: Endereco?,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Contato
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    val contato: Contato?
)
