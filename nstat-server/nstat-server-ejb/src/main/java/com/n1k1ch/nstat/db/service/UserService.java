package com.n1k1ch.nstat.db.service;

import com.n1k1ch.nstat.db.entity.User;
import com.n1k1ch.nstat.db.util.PasswordEncryptor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * Created by ncherevkov on 8/19/2016.
 */
@Stateless
@LocalBean
public class UserService {

    @Inject
    private PasswordEncryptor passwordEncryptor;

    @PersistenceContext(unitName = "nstat")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public User create(User user) throws NoSuchAlgorithmException {
        Objects.requireNonNull(user.getPassword());
        user.setPasswordHash(passwordEncryptor.encrypt(user.getPassword()));

        em.persist(user);
        return user;
    }

    public List<User> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
