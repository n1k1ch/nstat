package com.n1k1ch.nstat.db.service;

import com.n1k1ch.nstat.db.entity.Entry;

import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Stateless
@LocalBean
public class EntryDbService {

	@PersistenceContext(unitName = "nstat")
	private EntityManager em;

	@PermitAll
	public List<Entry> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Entry> query = cb.createQuery(Entry.class);
		Root<Entry> root = query.from(Entry.class);
		query.select(root);
		return em.createQuery(query).getResultList();
	}

	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Long saveEntry(Entry entry) {
		em.persist(entry);
		return entry.getId();
	}

	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Optional<Entry> updateEntry(Long id, Entry entry) {
		Entry existingEntry = em.find(Entry.class, id);

		if (existingEntry == null) {
			return Optional.empty();
		}

		cloneEntry(entry, existingEntry);
		return Optional.of(existingEntry);
	}

	private void cloneEntry(Entry source, Entry target) {
		target.setAmount(source.getAmount());
		target.setComment(source.getComment());
		target.setCurrency(source.getCurrency());
		target.setDate(source.getDate());
		target.setName(source.getName());
	}

	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean delete(Long id) {
		Entry entry = em.find(Entry.class, id);

		if (entry == null) {
			return false;
		}

		em.remove(entry);
		return true;
	}
}
