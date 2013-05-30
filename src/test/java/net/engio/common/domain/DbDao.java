package net.engio.common.domain;

import net.engio.common.persistence.Entity;
import net.engio.common.persistence.dao.IUnitOfWork;
import net.engio.common.persistence.dao.jpa.JpaDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Service
public class DbDao extends JpaDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager entityManager() {
        return em;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <D extends Entity<?>> D persist(Class<D> domainClass, D domainObject) {
        return super.persist(domainClass, domainObject);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <D extends Entity<?>> List<D> persistAll(Class<D> domainClass, List<D> domainObjects) {
        return super.persistAll(domainClass, domainObjects);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <D extends Entity<?>> boolean deleteAll(Class<D> domainClass, Collection<D> domainObjects) {
        return super.deleteAll(domainClass, domainObjects);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <D extends Entity<?>> boolean delete(Class<D> domainClass, D domainObject) {
        return super.delete(domainClass, domainObject);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void runInTransaction(IUnitOfWork t) {
        super.runInTransaction(t);
    }
}
