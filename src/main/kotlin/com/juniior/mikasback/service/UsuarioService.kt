package com.juniior.mikasback.service

import com.juniior.mikasback.dto.UsuarioDTO
import com.juniior.mikasback.models.*
import com.juniior.mikasback.repository.ConsultorioRepository
import com.juniior.mikasback.repository.PessoaRepository
import com.juniior.mikasback.repository.UsuarioRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val pessoaRepository: PessoaRepository,
    private val consultorioRepository: ConsultorioRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun cadastrarUsuario(usuarioDTO: UsuarioDTO): Usuario {
        // Cria e salva o endereço
        val endereco = usuarioDTO.pessoa.endereco?.let {
            Endereco(
                rua = it.rua,
                numero = usuarioDTO.pessoa.endereco.numero,
                complemento = usuarioDTO.pessoa.endereco.complemento,
                bairro = usuarioDTO.pessoa.endereco.bairro,
                cidade = usuarioDTO.pessoa.endereco.cidade,
                estado = usuarioDTO.pessoa.endereco.estado,
                cep = usuarioDTO.pessoa.endereco.cep
            )
        }

        // Cria e salva o contato
        val contato = usuarioDTO.pessoa.contato?.let {
            Contato(
                telefone = it.telefone,
                email = usuarioDTO.pessoa.contato.email,
                site = usuarioDTO.pessoa.contato.site
            )
        }

        // Cria e salva a pessoa
        val pessoa = Pessoa(
            nome = usuarioDTO.pessoa.nome,
            cpfCnpj = usuarioDTO.pessoa.cpfCnpj,
            dataNascimento = usuarioDTO.pessoa.dataNascimento,
            endereco = endereco,
            contato = contato
        )
        val pessoaSalva = pessoaRepository.save(pessoa)

        // Busca o consultório
        val consultorio = consultorioRepository.findById(usuarioDTO.consultorio.id)
            .orElseThrow { EntityNotFoundException("Consultório não encontrado") }

        // Cria e salva o usuário
        val usuario = Usuario(
            email = usuarioDTO.email,
            senha = passwordEncoder.encode(usuarioDTO.senha),
            papel = usuarioDTO.papel,
            consultorio = consultorio,
            pessoa = pessoaSalva
        )

        return usuarioRepository.save(usuario)
    }


    fun listarTodos(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Usuário não encontrado") }
    }

    @Transactional
    fun atualizar(id: Long, usuarioDTO: UsuarioDTO): Usuario {
        val usuario = buscarPorId(id)

        // Atualiza os dados do usuário
        usuario.apply {
            email = usuarioDTO.email
            if (usuarioDTO.senha.isNotBlank()) {
                senha = passwordEncoder.encode(usuarioDTO.senha)
            }
            papel = usuarioDTO.papel
        }

        // Atualiza os dados da pessoa
        usuario.pessoa.apply {
            nome = usuarioDTO.pessoa.nome
            cpfCnpj = usuarioDTO.pessoa.cpfCnpj
            dataNascimento = usuarioDTO.pessoa.dataNascimento

            // Atualiza ou remove endereço
            endereco = usuarioDTO.pessoa.endereco?.let {
                endereco?.apply {
                    rua = it.rua
                    numero = it.numero
                    complemento = it.complemento
                    bairro = it.bairro
                    cidade = it.cidade
                    estado = it.estado
                    cep = it.cep
                } ?: Endereco(
                    rua = it.rua,
                    numero = it.numero,
                    complemento = it.complemento,
                    bairro = it.bairro,
                    cidade = it.cidade,
                    estado = it.estado,
                    cep = it.cep
                )
            }

            // Atualiza ou remove contato
            contato = usuarioDTO.pessoa.contato?.let {
                contato?.apply {
                    telefone = it.telefone
                    email = it.email
                    site = it.site
                } ?: Contato(
                    telefone = it.telefone,
                    email = it.email,
                    site = it.site
                )
            }
        }

        return usuarioRepository.save(usuario)
    }

    @Transactional
    fun deletar(id: Long) {
        val usuario = buscarPorId(id)
        usuarioRepository.delete(usuario)
    }

    fun buscarPorEmail(email: String): Usuario {
        return usuarioRepository.findByEmail(email)
            ?: throw EntityNotFoundException("Usuário não encontrado")
    }

    fun buscarPorPapel(papel: PapelUsuario): List<Usuario> {
        return usuarioRepository.findByPapel(papel)
    }

    fun buscarPorConsultorio(consultorioId: Long): List<Usuario> {
        // Verifica se o consultório existe
        consultorioRepository.findById(consultorioId)
            .orElseThrow { EntityNotFoundException("Consultório não encontrado") }

        return usuarioRepository.findByConsultorioId(consultorioId)
    }
}