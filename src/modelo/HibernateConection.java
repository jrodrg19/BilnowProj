package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConection {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactoru() {
		return sessionFactory;
	}
	
}


