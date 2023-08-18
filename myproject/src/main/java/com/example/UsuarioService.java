package com.example;

import java.util.List;


public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Usuario usuario);
    void removerUsuario(Long id);
    List<Usuario> listarUsuarios();
}