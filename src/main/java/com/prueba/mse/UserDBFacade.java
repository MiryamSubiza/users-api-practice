package com.prueba.mse;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author msubiza
 */
@Repository
@Transactional
public class UserDBFacade {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<UserDB> findAll() {
        try {
            return (List<UserDB>) em.createNamedQuery("UserDB.findAll").getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public UserDB findByEmail(String email) {
        return (UserDB) em.createNamedQuery("UserDB.findByEmail").setParameter("email", email).getSingleResult();
    }

    public void create(UserDB user) {
        String sql = "INSERT INTO UserDB VALUES('" + user.getEmail() + "','" + user.getName() + "'," + user.getAge() + ",'" + user.getPassword() + "')";
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
    }

    public UserDB login(String email, String password) {
        try {
            UserDB u = (UserDB) em.createNamedQuery("UserDB.findByEmail").setParameter("email", email).getSingleResult();
            if (u.getPassword().equals(password)) {
                return u;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
