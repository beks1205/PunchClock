package ch.zli.m223.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        LocalDateTime checkIn = entry.getCheckIn();
        LocalDateTime checkOut = entry.getCheckOut();
        if (checkIn.isBefore(checkOut)) {
            entityManager.persist(entry);
            return entry;
        }
        return null;
    }

    @Transactional
    public Entry deleteEntry(Long id) {
        List<Entry> entriesList = findAll();

        for (Entry entry : entriesList) {
            if (entry.getId() == id) {
                entityManager.remove(entry);
                return entry;
            }
        }
        return null;
    }

    @Transactional
    public Entry updateEntry(Entry entry) {
        for (Entry oldentry : findAll()) {
            if (oldentry.getId() == entry.getId()) {
                return entityManager.merge(entry);
            }

        }
        return null;
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }
}
