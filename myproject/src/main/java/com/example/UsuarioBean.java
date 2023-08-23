package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.example.backend.UsuarioService;
import com.example.backend.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
public class UsuarioBean implements Serializable {
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;

    // Métodos de acesso aos usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Métodos de ação
    public void cadastrarUsuario() {
        usuarioService.cadastrarUsuario(usuario);
        usuario = new Usuario(); // Limpa o objeto após cadastro
    }

    public void atualizarUsuario() {
        usuarioService.atualizarUsuario(usuario);
        usuario = new Usuario(); // Limpa o objeto após atualização
    }

    public void removerUsuario(Long id) {
        usuarioService.removerUsuario(id);
        // Atualiza a lista de usuários após remoção
        usuarios = usuarioService.listarUsuarios();
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
