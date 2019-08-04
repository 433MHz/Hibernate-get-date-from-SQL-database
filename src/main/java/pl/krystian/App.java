package pl.krystian;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
            SettersGetters settersGetters = new SettersGetters();

            Configuration con = new Configuration().configure().addAnnotatedClass(SettersGetters.class);

            ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

            SessionFactory sf = con.buildSessionFactory(reg);

            Session session = sf.openSession();

            Transaction tx = session.beginTransaction();

            settersGetters = (SettersGetters) session.get(SettersGetters.class, 2);

            tx.commit();

        System.out.println(settersGetters.getId());
        System.out.println(settersGetters.getMarka());
        System.out.println(settersGetters.getPrzebieg());
        System.out.println(settersGetters.getRocznik());
    }
}
