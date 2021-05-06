package persistance.jdbc;

import biblioteca.Bibliotecar;
import biblioteca.Carte;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistance.CarteRepository;

import java.util.List;

public class CarteHibernateRepo implements CarteRepository {

    static SessionFactory sessionFactory;

    public CarteHibernateRepo(HibernateUtility hibernateUtility){
        sessionFactory = hibernateUtility.getSessionFactory();
        System.out.println("CarteHibernateRepo" + sessionFactory);
    }

    @Override
    public void add(Carte carte) throws Exception {
        try(Session session = sessionFactory.openSession()){
            Transaction tx=null;
            try{
                tx = session.beginTransaction();
                session.save(carte);
                tx.commit();
            }catch(RuntimeException ex){
                if (tx!=null)
                    tx.rollback();
            }
        }
    }

    @Override
    public void delete(Carte elem) {

    }

    @Override
    public void update(Carte elem) {

    }

    @Override
    public Carte findById(Integer integer) {
        return null;
    }

    @Override
    public List<Carte> findAll() {
        List<Carte> result = null;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                result = session.createQuery("from Carte as c order by c.titlu asc ", Carte.class).list();

                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if(transaction !=null)
                    transaction.rollback();
            }
        }
        return result;
    }
}
