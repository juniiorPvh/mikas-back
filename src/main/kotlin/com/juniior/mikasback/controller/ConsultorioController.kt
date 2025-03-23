package com.juniior.mikasback.controller

import com.juniior.mikasback.models.Consultorio
import com.juniior.mikasback.service.ConsultorioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/consultorios")
class ConsultorioController(
    private val consultorioService: ConsultorioService
) {
    // Listar todos os consultórios
    @GetMapping
    fun listarConsultorios(): List<Consultorio> {
        return consultorioService.findAll()
    }

    // Buscar um consultório por ID
    @GetMapping("/{id}")
    fun buscarConsultorioPorId(@PathVariable id: Long): Consultorio {
        return consultorioService.findById(id)
    }

    // Criar um novo consultório
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarConsultorio(@RequestBody consultorio: Consultorio): Consultorio {
        return consultorioService.save(consultorio)
    }

    // Atualizar um consultório existente
    @PutMapping("/{id}")
    fun atualizarConsultorio(
        @PathVariable id: Long,
        @RequestBody consultorio: Consultorio
    ): Consultorio {
        return consultorioService.update(id, consultorio)
    }

    // Deletar um consultório por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarConsultorio(@PathVariable id: Long) {
        consultorioService.deleteById(id)
    }
}