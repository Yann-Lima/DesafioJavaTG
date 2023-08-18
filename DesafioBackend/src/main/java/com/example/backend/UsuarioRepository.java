package com.example.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.ParameterMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Repository
public class UsuarioRepository {

    private final EntityManager entityManager;

    @Autowired
    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void atualizarUsuarioViaStoredProcedure(Long id, String novoNome, String novoEmail) {
        Session session = entityManager.unwrap(Session.class);

        StoredProcedureQuery query = session.createStoredProcedureQuery("atualizar_usuario");
        query.registerStoredProcedureParameter("id", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("novoNome", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("novoEmail", String.class, ParameterMode.IN);

        query.setParameter("id", id);
        query.setParameter("novoNome", novoNome);
        query.setParameter("novoEmail", novoEmail);

        query.execute();
    }
}
