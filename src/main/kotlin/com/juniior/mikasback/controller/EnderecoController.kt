package com.juniior.mikasback.controller


import com.juniior.mikasback.models.Endereco
import com.juniior.mikasback.service.EnderecoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/enderecos")
class EnderecoController(private val enderecoService: EnderecoService) {

    @GetMapping
    fun listarTodos(): ResponseEntity<List<Endereco>> {
        return ResponseEntity.ok(enderecoService.findAll())
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Endereco> {
        return ResponseEntity.ok(enderecoService.findById(id))
    }

    @PostMapping
    fun criar(@RequestBody endereco: Endereco): ResponseEntity<Endereco> {
        return ResponseEntity.ok(enderecoService.save(endereco))
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody endereco: Endereco): ResponseEntity<Endereco> {
        val enderecoAtualizado = enderecoService.save(endereco.copy(id = id))
        return ResponseEntity.ok(enderecoAtualizado)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<Void> {
        enderecoService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}