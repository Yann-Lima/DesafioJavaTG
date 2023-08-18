package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private SessionFactory sessionFactory;

    public UsuarioServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(usuario); // Salva o usuário no banco de dados
            transaction.commit();
            return usuario; // Retorna o usuário cadastrado
        } catch (Exception e) {
            transaction.rollback();
            throw e; // Lança a exceção para que possa ser tratada em outro lugar
        } finally {
            session.close();
        }
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(usuario); // Atualiza o usuário no banco de dados
            transaction.commit();
            return usuario; // Retorna o usuário atualizado
        } catch (Exception e) {
            transaction.rollback();
            throw e; // Lança a exceção para que possa ser tratada em outro lugar
        } finally {
            session.close();
        }
    }


    @Override
    public void removerUsuario(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        // Lógica para remover o usuário
        
        transaction.commit();
        session.close();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        Session session = sessionFactory.openSession();
        // Lógica para listar usuários
        session.close();
        
        return null;
    }
}
