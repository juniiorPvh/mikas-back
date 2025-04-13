package com.juniior.mikasback.controller

import com.juniior.mikasback.dto.UsuarioDTO
import com.juniior.mikasback.models.PapelUsuario
import com.juniior.mikasback.models.Usuario
import com.juniior.mikasback.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
) {

    @PostMapping
    fun criar(@RequestBody usuarioDTO: UsuarioDTO): ResponseEntity<Usuario> {
        val usuario = usuarioService.cadastrarUsuario(usuarioDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario)
    }

    // Listar todos os usuários
    @GetMapping
    fun listar(): ResponseEntity<List<Usuario>> {
        val usuarios = usuarioService.listarTodos()
        return ResponseEntity.ok(usuarios)
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Usuario> {
        val usuario = usuarioService.buscarPorId(id)
        return ResponseEntity.ok(usuario)
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody usuarioDTO: UsuarioDTO
    ): ResponseEntity<Usuario> {
        val usuarioAtualizado = usuarioService.atualizar(id, usuarioDTO)
        return ResponseEntity.ok(usuarioAtualizado)
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        usuarioService.deletar(id)
        return ResponseEntity.noContent().build()
    }

    // Buscar usuário por email
    @GetMapping("/email/{email}")
    fun buscarPorEmail(@PathVariable email: String): ResponseEntity<Usuario> {
        val usuario = usuarioService.buscarPorEmail(email)
        return ResponseEntity.ok(usuario)
    }

    // Buscar usuários por papel
    @GetMapping("/papel/{papel}")
    fun buscarPorPapel(@PathVariable papel: PapelUsuario): ResponseEntity<List<Usuario>> {
        val usuarios = usuarioService.buscarPorPapel(papel)
        return ResponseEntity.ok(usuarios)
    }
}