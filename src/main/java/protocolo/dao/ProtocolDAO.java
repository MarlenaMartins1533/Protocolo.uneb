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
import protocolo.model.Protocol;

/**
 *
 * @author Murilo
 */
public class ProtocolDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public void add(Protocol protocol){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(protocol);
        transaction.commit();
        session.close();
    }
    
    public void edit(Protocol protocol){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(protocol);
        transaction.commit();
        session.close();
    }
    
    public void delete(Protocol protocol){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(protocol);
        transaction.commit();
        session.close();
    }
    
    public Protocol getProtocolById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Protocol where id= :id")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();
        return (Protocol) list.get(0);
    }
    
    public Protocol getProtocolByCodigo(String codigo){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Protocol where codigo= :codigo")
                .setParameter("codigo", codigo)
                .list();
        transaction.commit();
        session.close();
        if(list.isEmpty()){
            return null;
        }
        return (Protocol) list.get(0);
    }
    
    public List getAllProtocols(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Protocol")
                .list();
        transaction.commit();
        session.close();
        return list;
    }   
}
