package com.juniior.mikasback.service

import com.juniior.mikasback.models.Endereco
import com.juniior.mikasback.repository.EnderecoRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class EnderecoService(private val enderecoRepository: EnderecoRepository) {

    fun findAll(): List<Endereco> {
        return enderecoRepository.findAll()
    }

    fun findById(id: Long): Endereco {
        return enderecoRepository.findById(id)
            .orElseThrow { NoSuchElementException("Endereco não encontrado com o ID: $id") }
    }

    @Transactional
    fun save(consultorio: Endereco): Endereco {
        return enderecoRepository.save(consultorio)
    }

    @Transactional
    fun update(id: Long, consultorio: Endereco): Endereco {
        if (!enderecoRepository.existsById(id)) {
            throw NoSuchElementException("Endereco não encontrado com o ID: $id")
        }
        return enderecoRepository.save(consultorio.copy(id = id))
    }

    @Transactional
    fun deleteById(id: Long) {
        if (!enderecoRepository.existsById(id)) {
            throw NoSuchElementException("Endereco não encontrado com o ID: $id")
        }
        enderecoRepository.deleteById(id)
    }
}