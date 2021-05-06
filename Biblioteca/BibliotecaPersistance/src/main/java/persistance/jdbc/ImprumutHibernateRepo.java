package persistance.jdbc;

import biblioteca.Carte;
import biblioteca.Imprumut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistance.CarteRepository;
import persistance.ImprumutRepository;

import java.util.List;

public class ImprumutHibernateRepo implements ImprumutRepository {

    static SessionFactory sessionFactory;

    public ImprumutHibernateRepo(){
        sessionFactory = HibernateUtility.getSessionFactory();
        System.out.println("ImprumutHibernateRepo" + sessionFactory);
    }

    @Override
    public void add(Imprumut imprumut) {
        try(Session session = sessionFactory.openSession()){
            Transaction tx=null;
            try{
                tx = session.beginTransaction();
                session.save(imprumut);
                System.out.println("ImprumutHibernateRepo save" + imprumut);
                tx.commit();
            }catch(RuntimeException ex){
                if (tx!=null)
                    tx.rollback();
            }
        }
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void update(Imprumut elem) {

    }

    @Override
    public Imprumut findById(Integer integer) {
        return null;
    }

    @Override
    public List<Imprumut> findAll() {
        List<Imprumut> result = null;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                result = session.createQuery("from Imprumut", Imprumut.class).list();

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
    public List<Imprumut> getImprumuturiActiveAbonat(int idAbonat) {
        List<Imprumut> result = null;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                result = session.createQuery("from Imprumut where RETURNAT is false AND ID_ABONAT = ?", Imprumut.class)
                        .setParameter(0,idAbonat).list();

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
