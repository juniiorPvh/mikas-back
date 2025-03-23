package com.juniior.mikasback.models

import jakarta.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["cnpj"])]) // Garante que o CNPJ seja único
data class Consultorio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,

    @Column(nullable = false, unique = true) // Garante que o CNPJ não seja nulo e seja único
    @NotNull(message = "CNPJ não pode ser nulo")
    val cnpj: String,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    val endereco: Endereco,

    @ManyToOne(cascade = [CascadeType.ALL]) // Relacionamento com Contato
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    val contato: Contato
)
