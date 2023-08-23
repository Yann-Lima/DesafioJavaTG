package com.example.backend;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

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
            throw new IllegalArgumentException("Usuário não encontrado.", e);
        }
    }

    private void validarCampos(Usuario usuario) {
        validarSenha(usuario.getPassword());
        validarTipoPessoa(usuario);
    }

    private void validarSenha(String senha) {
        if (!senha.matches("(?=.*[0-9])(?=.*[A-Z]).{8,}")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos 8 caracteres, um número e uma letra maiúscula.");
        }
    }

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
