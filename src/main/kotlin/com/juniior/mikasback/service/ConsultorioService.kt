package com.juniior.mikasback.service

import com.juniior.mikasback.models.Consultorio
import com.juniior.mikasback.repository.ConsultorioRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class ConsultorioService(private val consultorioRepository: ConsultorioRepository) {
    // Buscar todos os consultórios
    fun findAll(): List<Consultorio> {
        return consultorioRepository.findAll()
    }

    // Buscar um consultório por ID
    fun findById(id: Long): Consultorio {
        return consultorioRepository.findById(id)
            .orElseThrow { NoSuchElementException("Consultório não encontrado com o ID: $id") }
    }

    // Salvar um consultório
    @Transactional
    fun save(consultorio: Consultorio): Consultorio {
        return consultorioRepository.save(consultorio)
    }

    // Atualizar um consultório
    @Transactional
    fun update(id: Long, consultorio: Consultorio): Consultorio {
        if (!consultorioRepository.existsById(id)) {
            throw NoSuchElementException("Consultório não encontrado com o ID: $id")
        }
        return consultorioRepository.save(consultorio.copy(id = id))
    }

    // Deletar um consultório por ID
    @Transactional
    fun deleteById(id: Long) {
        if (!consultorioRepository.existsById(id)) {
            throw NoSuchElementException("Consultório não encontrado com o ID: $id")
        }
        consultorioRepository.deleteById(id)
    }
}