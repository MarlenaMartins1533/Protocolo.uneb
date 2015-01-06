/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import protocolo.model.Setor;

/**
 *
 * @author Murilo
 */
public class SetorDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public void add(Setor setor){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(setor);
        transaction.commit();
        session.close();
    }
    
    public void edit(Setor setor){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(setor);
        transaction.commit();
        session.close();
    }
    
    public void delete(Setor setor){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(setor);
        transaction.commit();
        session.close();
    }
    
    public Setor getSetorById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Setor where id= :id").setParameter("id", id).list();
        transaction.commit();
        session.close();
        return (Setor) list.get(0);
    }
    
    public List getAllSetores(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Setor").list();
        transaction.commit();
        session.close();
        return list;
    }   
}
