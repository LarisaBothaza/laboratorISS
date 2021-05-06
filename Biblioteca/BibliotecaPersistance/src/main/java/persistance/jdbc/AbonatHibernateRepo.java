package persistance.jdbc;

import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistance.AbonatRepository;

import java.util.List;

public class AbonatHibernateRepo implements AbonatRepository {

    static SessionFactory sessionFactory;

    public AbonatHibernateRepo(){
        sessionFactory = HibernateUtility.getSessionFactory();
        System.out.println("AbonatHibernateRepo" + sessionFactory);
    }

    @Override
    public Abonat findAbonatByUsernameParola(String username, String parola) {
        Abonat result = null;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                result = session.createQuery("from Abonat where username = ? and parola = ?", Abonat.class)
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
    public void add(Abonat elem) throws Exception {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void update(Abonat elem) {

    }

    @Override
    public Abonat findById(Integer integer) {
        return null;
    }

    @Override
    public List<Abonat> findAll() {
        return null;
    }
}
