package cr.ac.una.tareaprogramacion3.service;

import cr.ac.una.tareaprogramacion3.model.Administrador;
import cr.ac.una.tareaprogramacion3.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class AdministradorService {

    public Optional<Administrador> login(String usuario, String passwordPlain) {
        EntityManager em = JPAUtil.getEM();
        try {
            TypedQuery<Administrador> q = em.createQuery(
                "SELECT a FROM Administrador a " +
                "WHERE UPPER(a.usuario) = UPPER(:u) " +
                "AND a.passwordPlain = :p " +
                "AND a.estado = 'ACTIVO'", Administrador.class);

            q.setParameter("u", usuario);
            q.setParameter("p", passwordPlain);

            List<Administrador> res = q.getResultList();
            return res.isEmpty() ? Optional.empty() : Optional.of(res.get(0));
        } finally {
            em.close();
        }
    }
}
