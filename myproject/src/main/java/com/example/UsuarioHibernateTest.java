package com.example;

import com.example.backend.UsuarioService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UsuarioHibernateTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private UsuarioService usuarioService;

    @Before
    public void setup() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        
        usuarioService = new UsuarioService(sessionFactory);
    }


    @After
    public void teardown() {
        transaction.rollback();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testMapeamentoUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Nome do Usuário");

        session.save(usuario);
        session.flush();

        
        Usuario usuarioSalvo = session.get(Usuario.class, usuario.getId());
        assertNotEquals(null, usuarioSalvo);
        assertEquals(usuario.getNome(), usuarioSalvo.getNome());
        
    }
}

