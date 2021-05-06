package persistance.jdbc;

import biblioteca.Bibliotecar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import persistance.BibliotecarRepository;

import java.util.List;

public class BibliotecarHibernateRepo implements BibliotecarRepository {

    static SessionFactory sessionFactory;

    public BibliotecarHibernateRepo(HibernateUtility hibernateUtility){
        sessionFactory = hibernateUtility.getSessionFactory();
        System.out.println("BibliotecarHibernateRepo" + sessionFactory);
    }


    @Override
    public Bibliotecar findBibliotecarByUsernameParola(String username, String parola) {
        Bibliotecar result = null;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                result = session.createQuery("from Bibliotecar where username = ? and parola = ?", Bibliotecar.class)
                        .setParameter(0,username).setParameter(1,parola).uniqueResult();

                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if(transaction !=null)
                    transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public void add(Bibliotecar elem) throws Exception {

    }

    @Override
    public void delete(Bibliotecar elem) {

    }

    @Override
    public void update(Bibliotecar elem) {

    }

    @Override
    public Bibliotecar findById(Integer integer) {
        return null;
    }

    @Override
    public List<Bibliotecar> findAll() {
        return null;
    }
}
