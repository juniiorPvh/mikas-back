package com.juniior.mikasback.dto

import java.time.LocalDate

data class PessoaDTO(
    val nome: String,
    val cpfCnpj: String,
    val dataNascimento: LocalDate,
    val endereco: EnderecoDTO?,
    val contato: ContatoDTO?
)
