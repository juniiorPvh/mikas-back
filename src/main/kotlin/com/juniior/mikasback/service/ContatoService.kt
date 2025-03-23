package com.juniior.mikasback.service

import com.juniior.mikasback.models.Contato
import com.juniior.mikasback.repository.ContatoRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class ContatoService(private val contatoRepository: ContatoRepository) {

    fun findAll(): List<Contato> {
        return contatoRepository.findAll()
    }

    fun findById(id: Long): Contato {
        return contatoRepository.findById(id)
            .orElseThrow { NoSuchElementException("Contato não encontrado com o ID: $id") }
    }

    @Transactional
    fun save(consultorio: Contato): Contato {
        return contatoRepository.save(consultorio)
    }

    @Transactional
    fun update(id: Long, consultorio: Contato): Contato {
        if (!contatoRepository.existsById(id)) {
            throw NoSuchElementException("Contato não encontrado com o ID: $id")
        }
        return contatoRepository.save(consultorio.copy(id = id))
    }

    @Transactional
    fun deleteById(id: Long) {
        if (!contatoRepository.existsById(id)) {
            throw NoSuchElementException("Contato não encontrado com o ID: $id")
        }
        contatoRepository.deleteById(id)
    }
}