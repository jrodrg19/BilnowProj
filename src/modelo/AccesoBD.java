package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modeloBD.Cita;
import modeloBD.Mascota;
import modeloBD.Productos;
import modeloBD.Productosreservados;
import modeloBD.Reserva;
import modeloBD.Usuario;

/**
 * 
 * @author Javier
 *
 */
public class AccesoBD {

	private Statement declaracion;

	private ResultSet datos;
	
	private Session session;


	/**
	 * 
	 */
	public AccesoBD() {


		Conecta nuevo=new Conecta();

		Connection conexion=nuevo.getConexion();

		try {

			declaracion=conexion.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}


	/**
	 * 
	 * @param fileName
	 */
	public static void backupBD(File fileName) {
	
		try {
			String rutaMySqlDump = "C:\\Archivos de programa\\MySQL\\MySQL Server 5.0\\bin\\mysqldump.exe";
			String contrasenia ="";
			String usuario = "root";
			String dataBase = "bilnow_db";
	
			String cad = "\"" + rutaMySqlDump + "\" --opt --password=" + contrasenia + " --user=" + usuario + " " + dataBase + " > \"" + fileName.getAbsolutePath()+".sql" +"\"\n";
	
	
			File fcopi = new File("copia_seguridad.bat");
			FileWriter fw = new FileWriter(fcopi);
			fw.write(cad, 0, cad.length());
			fw.close();
			Runtime.getRuntime().exec("copia_Seguridad.bat");
	
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}


	public boolean estaLibreHora(Date cita_Fecha, String hora) {
	
		boolean esta=false;
	
		try {
			datos=declaracion.executeQuery("Select * from `cita` where `fecha_cita` = '"+new java.sql.Date(cita_Fecha.getTime())+"' and `hora_Cita` = '"+hora+"';");
	
			if(datos.next()==false) {
				esta=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return esta;
	}


	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public Usuario getUsuaioBD(String id_Usuario){

		
		  session = HibernateConection.getSessionFactoru().openSession();
		  Usuario user=null;
	      Transaction tx = null;
	      try {
	    	  user = (Usuario) session.createQuery("from Usuario where id_Usuario='"+id_Usuario+"'").uniqueResult();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return user;
		
	}


	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Productos> getProductosBD(){

		List<Productos> prodAlm=null;
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         prodAlm = session.createQuery("from Productos").list(); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return prodAlm;
		
	}


	/**
	 * 
	 * @return
	 */
	public ResultSet getNumProductosBD() {

		try {
			datos=declaracion.executeQuery("SELECT count(*) from productos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;
	}

	/**
	 * 
	 * @param id_Mascota 
	 * 
	 */
	public ResultSet getNumCitasBD(String id_Mascota) {
		// TODO Auto-generated method stub
		
		try {
			datos=declaracion.executeQuery("SELECT count(*) from cita where id_Mascota ='"+id_Mascota+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;

	}


	/**
	 * @param string 
	 * @return 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Cita> getCitasMascotaBD(String id_Mascota) {

		List<Cita> citasMasc=null;
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         citasMasc = session.createQuery("from Cita where id_mascota='"+id_Mascota+"'").list(); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return citasMasc;
	      
	}


	/**
	 * 
	 * @param id_Usuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Mascota> getMascotasUsuarioBD(String id_Usuario) {
		// TODO Auto-generated method stub
		List<Mascota> mascotasuser=null;
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         mascotasuser = session.createQuery("from Mascota where id_Duenio='"+id_Usuario+"'").list(); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return mascotasuser;
	}


	/**
	 * 
	 * @param id_Usuarios
	 * @param fecha
	 * @return
	 */
	@SuppressWarnings("unused")
	public int getId_ReservaBD(String id_Usuarios, Date fecha) {
		// TODO Auto-generated method stub

		 session = HibernateConection.getSessionFactoru().openSession();
		  Reserva reserva=null;
	      Transaction tx = null;
	      try {
	    	  reserva = (Reserva) session.createQuery("from Reserva where id_Usuario='"+id_Usuarios+"' and fecha_Pedido='"+fecha+"'").uniqueResult();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return reserva.getIdReserva();
		
	}


	/**
	 * 
	 * @param id_Prod
	 * @param id_Reserva
	 */
	public void aniadirReservaProductoBD(Productosreservados nuevo) {
		// TODO Auto-generated method stub
	
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nuevo); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	
	}


	/**
	 * 
	 * @param nuevo
	 */
	public void aniadir_UsuarioBD(Usuario nuevo) {
		// TODO Auto-generated method stub
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nuevo); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}


	/**
	 * 
	 * @param nueva
	 */
	public void aniadir_MascotaBD(Mascota nueva) {
		// TODO Auto-generated method stub
		
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nueva); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}
		


	/**
	 * 
	 * @param nuevo
	 */
	public void aniadir_ProductoBD(Productos nuevo) {
		// TODO Auto-generated method stub
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nuevo); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}


	/**
	 * 
	 * @param id_Usuario
	 * @param fecha
	 */
	public void aniadir_ReservaBD(Reserva nueva) {

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nueva); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}		
		
	}


	/**
	 * 
	 * @param nueva
	 */
	public void aniadirCitaBD(Cita nueva) {
		// TODO Auto-generated method stub
	
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(nueva); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	
	}


	/**
	 * 
	 * @param dni_Mascota
	 * @return
	 */
	public boolean existeMascotaBD(String dni_Mascota) {

		boolean esta=true;

		try {
			datos=declaracion.executeQuery("Select * from `mascota` where `id_Mascota` = '"+dni_Mascota+"';");

			if(datos.next()==false) {
				esta=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esta;
	}


	/**
	 * 
	 * @param dni_usuario
	 * @return
	 */
	public boolean existeUserBD(String dni_usuario) {
	
		boolean esta=true;
	
		try {
			datos=declaracion.executeQuery("Select * from `usuario` where `id_Usuario` = '"+dni_usuario+"';");
	
			if(datos.next()==false) {
				esta=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return esta;
	
	}


	/**
	 * 
	 * @param pw_usuario
	 * @param dni_usuario
	 * @return
	 */
	public boolean existePasswdBD(String pw_usuario,String dni_usuario) {
	
		boolean esta=true;
	
		try {
			datos=declaracion.executeQuery("SELECT * FROM `usuario` WHERE `id_Usuario`='"+dni_usuario+"' and `pswd_Usuario`='"+pw_usuario+"';");
	
			if(datos.next()==false) {
				esta=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return esta;
	
	}


	/**
	 * 
	 * @param id_Producto
	 * @return
	 */
	public boolean existeProductoBD(String id_Producto) {

		boolean esta=true;

		try {
			datos=declaracion.executeQuery("Select * from `productos` where `id_Producto` = '"+id_Producto+"';");

			if(datos.next()==false) {
				esta=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esta;
	}


	/**
	 * 
	 * @param id_Producto
	 */
	public void borrar_ProductoBD(String id_Producto) {
	
		try {
			declaracion.execute("DELETE FROM `productos` WHERE`id_Producto` = '"+id_Producto+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}


	/**
	 * 
	 * @param dni_Mascota
	 */
	public void eliminarMascotaBD(String dni_Mascota) {
	
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Mascota mascotaDel = (Mascota)session.get(Mascota.class, dni_Mascota); 
			session.delete(mascotaDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	
	}


	/*
	 * 
	 * 
	 */
	public void eliminarCitaBD(long id_Cita) {
		// TODO Auto-generated method stub
	
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			modeloBD.Cita mascotaDel = (Cita)session.get(Cita.class, id_Cita); 
			session.delete(mascotaDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	
	
	}


	/**
	 * 
	 * @param id_Prod
	 */
	public void eliminarProductoBD(String id_Prod) {

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Productos procDel = (Productos)session.get(Productos.class, id_Prod); 
			session.delete(procDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}


	public void eliminarCitaMascotaBD(String dni_Mascota) {

		try {
			declaracion.execute("DELETE FROM `cita` WHERE`id_Mascota` = '"+dni_Mascota+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void eliminarUsuarioBD(String dni_usuario) {

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Usuario userDel = (Usuario)session.get(Usuario.class, dni_usuario); 
			session.delete(userDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

}
