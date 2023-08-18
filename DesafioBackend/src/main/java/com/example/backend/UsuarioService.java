package com.example.backend;

import com.example.backend.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import com.example.backend.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.InputMismatchException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        validarCampos(usuario);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        validarCampos(usuario);
        return usuarioRepository.save(usuario);
    }

    public void removerUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // Trate a exceção ou lance outra exceção personalizada, se necessário
            throw new IllegalArgumentException("Usuário não encontrado.", e);
        }
    }


    // Função para validar os campos do usuário
    private void validarCampos(Usuario usuario) {
        validarSenha(usuario.getPassword());
        validarTipoPessoa(usuario);
    }

    // Função para validar a senha
    private void validarSenha(String senha) {
        if (!senha.matches("(?=.*[0-9])(?=.*[A-Z]).{8,}")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos 8 caracteres, um número e uma letra maiúscula.");
        }
    }

    // Função para validar o tipo de pessoa e campos relacionados (CPF ou CNPJ)
    private void validarTipoPessoa(Usuario usuario) {
        if (usuario.getTipoPessoa().equals("FISICA")) {
            validarCPF(usuario.getCpf());
        } else if (usuario.getTipoPessoa().equals("JURIDICA")) {
            validarCNPJ(usuario.getCnpj());
        } else {
            throw new IllegalArgumentException("Tipo de pessoa inválido.");
        }
    }

    private void validarCPF(String cpf) {
        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    private boolean isValidCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private void validarCNPJ(String cnpj) {
        if (!isValidCNPJ(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
    }

    private boolean isValidCNPJ(String cnpj) {
        return cnpj.matches("\\d{14}");
    }
}