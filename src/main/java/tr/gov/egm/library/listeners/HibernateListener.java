package tr.gov.egm.library.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebListener
public class HibernateListener implements ServletContextListener {

	private static SessionFactory factory;

	public void contextInitialized(ServletContextEvent event) {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		if (factory != null) {
			factory.close();
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}