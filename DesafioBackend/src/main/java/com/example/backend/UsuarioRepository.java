package com.example.backend;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
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
        query.registerStoredProcedureParameter("id", Long.class, ParameterMode.IN).bindValue(id);
        query.registerStoredProcedureParameter("novoNome", String.class, ParameterMode.IN).bindValue(novoNome);
        query.registerStoredProcedureParameter("novoEmail", String.class, ParameterMode.IN).bindValue(novoEmail);

        query.execute();
    }
}
