package com.juniior.mikasback.service

import com.juniior.mikasback.models.Pessoa
import com.juniior.mikasback.repository.PessoaRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class PessoaService(private val pessoaRepository: PessoaRepository) {
    fun findAll(): List<Pessoa> {
        return pessoaRepository.findAll()
    }

    fun findById(id: Long): Pessoa {
        return pessoaRepository.findById(id)
            .orElseThrow { NoSuchElementException("Pessoa não encontrado com o ID: $id") }
    }

    fun buscarPorCpfCnpj(cpfCnpj: String): Pessoa? =
        pessoaRepository.findByCpfCnpj(cpfCnpj)

    @Transactional
    fun save(consultorio: Pessoa): Pessoa {
        return pessoaRepository.save(consultorio)
    }

    @Transactional
    fun update(id: Long, consultorio: Pessoa): Pessoa {
        if (!pessoaRepository.existsById(id)) {
            throw NoSuchElementException("Pessoa não encontrado com o ID: $id")
        }
        return pessoaRepository.save(consultorio.copy(id = id))
    }

    @Transactional
    fun deleteById(id: Long) {
        if (!pessoaRepository.existsById(id)) {
            throw NoSuchElementException("Pessoa não encontrado com o ID: $id")
        }
        pessoaRepository.deleteById(id)
    }
}