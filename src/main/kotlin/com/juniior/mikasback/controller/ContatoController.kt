package com.juniior.mikasback.controller

import com.juniior.mikasback.models.Contato
import com.juniior.mikasback.service.ContatoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contatos")
class ContatoController(private val contatoService: ContatoService) {

    @GetMapping
    fun listarTodos(): ResponseEntity<List<Contato>> {
        return ResponseEntity.ok(contatoService.findAll())
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Contato> {
        return ResponseEntity.ok(contatoService.findById(id))
    }

    @PostMapping
    fun criar(@RequestBody contato: Contato): ResponseEntity<Contato> {
        return ResponseEntity.ok(contatoService.save(contato))
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody contato: Contato): ResponseEntity<Contato> {
        val contatoAtualizado = contatoService.save(contato.copy(id = id))
        return ResponseEntity.ok(contatoAtualizado)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<Void> {
        contatoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
