import biblioteca.Carte;
import biblioteca.Imprumut;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistance.CarteRepository;
import persistance.ImprumutRepository;
import persistance.jdbc.CarteHibernateRepo;
import persistance.jdbc.HibernateUtility;
import persistance.jdbc.ImprumutHibernateRepo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class StartServer {

    private static int defaultPort=55555;

    static class Constants {
        public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    }

    public static void main(String[] args) {

//        Imprumut test = new Imprumut(1,1, new Date(), false);
////        System.out.println("Creat: "+ test);
//        ImprumutRepository imprumutRepository = new ImprumutHibernateRepo();
////
//        List<Imprumut> lista = imprumutRepository.getImprumuturiActiveAbonat(1);
//        lista.forEach(System.out::println);
//
//        System.out.println(lista.get(3).getDataImprumut());


//        CarteRepository carteRepository = new CarteHibernateRepo();
//        List<Carte> carti = carteRepository.getCartilePtAbonat(1);
//        carti.forEach(System.out::println);

        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-server.xml");
    }
}
