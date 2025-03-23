package com.juniior.mikasback.service

import com.juniior.mikasback.models.Cliente
import com.juniior.mikasback.repository.ClienteRepository
import com.juniior.mikasback.repository.PessoaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository,
    private val pessoaRepository: PessoaRepository
) {
    fun findAll(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun findById(id: Long): Cliente {
        return clienteRepository.findById(id)
            .orElseThrow { NoSuchElementException("Cliente não encontrado com o ID: $id") }
    }

    @Transactional
    fun save(cliente: Cliente): Cliente {
        // Verifica se a pessoa já existe antes de salvar
        val pessoaExistente = pessoaRepository.findByCpfCnpj(cliente.pessoa.cpfCnpj)
        if (pessoaExistente != null && pessoaExistente.id != cliente.pessoa.id) {
            throw RuntimeException("CPF/CNPJ já cadastrado para outra pessoa")
        }

        pessoaRepository.save(cliente.pessoa) // Salva a Pessoa antes
        return clienteRepository.save(cliente)
    }

    @Transactional
    fun deleteById(id: Long) {
        if (!clienteRepository.existsById(id)) {
            throw NoSuchElementException("Cliente não encontrado com o ID: $id")
        }
        clienteRepository.deleteById(id)
    }


}