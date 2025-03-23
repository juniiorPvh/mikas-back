package com.juniior.mikasback.controller

import com.juniior.mikasback.models.Cliente
import com.juniior.mikasback.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
class ClienteController(private val clienteService: ClienteService) {
    @GetMapping
    fun listarTodos(): ResponseEntity<List<Cliente>> {
        val clientes = clienteService.findAll()
        return ResponseEntity.ok(clientes)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Cliente> {
        val cliente = clienteService.findById(id)
        return ResponseEntity.ok(cliente)
    }

    @PostMapping
    fun criar(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val novoCliente = clienteService.save(cliente)
        return ResponseEntity.ok(novoCliente)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val clienteExistente = clienteService.findById(id)
        val clienteAtualizado = clienteService.save(cliente.copy(id = clienteExistente.id))
        return ResponseEntity.ok(clienteAtualizado)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<Void> {
        clienteService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}