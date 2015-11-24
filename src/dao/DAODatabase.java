package dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Cancion;
import data.Miembro;
import data.Pago;
import data.Reproduccion;

public class DAODatabase implements IDAODatabase {

	private static DAODatabase instance;
	private PersistenceManagerFactory pmf;
	
	public static synchronized DAODatabase getInstance() {
		if(instance == null) {
			instance = new DAODatabase();
		}
		
		return instance;
	}
	
	private DAODatabase() {
		Cancion cancion1 = new Cancion("1", "Raphael", 250, "22/10/1001", 1.49,
				"aquarioooooooooos");
		Cancion cancion2 = new Cancion("2", "Bertin", 300, "31/10/1980", 0.49,
				"buenas noches senioraaaaaaa");
		Cancion cancion3 = new Cancion("3", "Raphael", 280, "12/05/1990", 2.49,
				"nananananananaaaaaaaa");
		Cancion cancion4 = new Cancion("4", "Bertin", 230, "02/02/1992", 3.49,
				"hasta la vistaaaaaaaaa");
		Miembro miembro1= new Miembro("Pepe", "yo", 0, 0);
		Miembro miembro2= new Miembro("Paca", "tu", 0, 0);
		Miembro miembro3= new Miembro("Paco", "el", 0, 0);
		
		pmf = JDOHelper.getPersistenceManagerFactory("Tralala");
		PersistenceManager pm = null;
		Transaction tx = null;
		
		System.out.println("- Store objects in the DB");			
		
		try {
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(cancion1);
			pm.makePersistent(cancion2);	
			pm.makePersistent(cancion3);
			pm.makePersistent(cancion4);
			pm.makePersistent(miembro1);
			pm.makePersistent(miembro2);
			pm.makePersistent(miembro3);
			
			//End the transaction
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	@Override
	public void storeReproduccion(Reproduccion repro) {
		this.storeObject(repro);		
	}

	@Override
	public void storePago(Pago pago) {
		this.storeObject(pago);
	}

	@Override
	public Set<Cancion> getListaCanciones(String artista) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
		Set<Cancion> canciones = new HashSet<>();
		
		try {
			System.out.println (" * Querying canciones de: " + artista);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Cancion.class.getName() + " WHERE artista == '" + artista + "'");
	    	
	    	for (Cancion cancion : (Collection<Cancion>)query.execute()) {
				canciones.add(cancion);
			}
			
	        tx.commit();
		} catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
		  	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	    }
		
		return canciones;
	}

	@Override
	public void storeMiembro(Miembro miembro) {
		this.storeObject(miembro);
	}

	@Override
	public void storeCancion(Cancion cancion) {
		this.storeObject(cancion);
	}

	@Override
	public Miembro getMiembro(String username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Miembro miembro = null;
	    
		try {
			System.out.println ("   * Querying miembro: " + username);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Miembro.class.getName() + " WHERE username == '" + username + "'");
	    	query.setUnique(true);
	    	miembro = (Miembro)query.execute();	    	
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	    
	    return miembro;
	}

	@Override
	public Cancion getCancion(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Cancion cancion = null;
	    
		try {
			System.out.println ("   * Querying cancion: " + titulo);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Cancion.class.getName() + " WHERE titulo == '" + titulo + "'");
	    	query.setUnique(true);
	    	cancion = (Cancion)query.execute();	    	
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	    
	    return cancion;
	}
	
	@Override
	public Set<Reproduccion> getReproducciones(Miembro miembro) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
		Set<Reproduccion> repros = new HashSet<>();
		
		try {
			System.out.println (" * Querying canciones de: " + miembro.getUsername());
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Reproduccion.class.getName());
	    	query.setUnique(true);
	    	for (Reproduccion reproduccion : (Set<Reproduccion>)query.execute()) {
				if(reproduccion.getMiembro().getUsername().equals(miembro.getUsername()))
	    			repros.add(reproduccion);
			}
			
	        tx.commit();
		} catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
		  	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	    }
		
		return repros;
	}

	@Override
	public void crearReproduccion(String username, String titulo) {
		Miembro miembro = getMiembro(username);
		Cancion cancion = getCancion(titulo);
		Calendar c = Calendar.getInstance();
		String dia, mes, anio, hora, minutos, segundos, fecha, reloj;
		
		dia = Integer.toString(c.get(Calendar.DATE));
		if(dia.length() < 2)
			dia = "0"+dia;
		mes = Integer.toString(c.get(Calendar.MONTH) + 1);
		if(mes.length() < 2)
			mes = "0"+mes;
		anio = Integer.toString(c.get(Calendar.YEAR));
		anio = anio.substring(anio.length()-2, anio.length());
		
		hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
		if(hora.length() < 2)
			hora = "0"+hora;
		minutos = Integer.toString(c.get(Calendar.MINUTE));
		if(minutos.length() < 2)
			minutos = "0"+minutos;
		segundos = Integer.toString(c.get(Calendar.SECOND));
		if(segundos.length() < 2)
			segundos = "0"+segundos;
		
		fecha = dia+"/"+mes+"/"+anio;
		reloj = hora+":"+minutos+":"+segundos;
		
		Reproduccion repro = new Reproduccion(fecha, reloj, miembro, cancion);
		System.out.println("Nueva reproduccion creada "+fecha+", "+reloj+", "+miembro.getNombre()+", "+cancion.getLetra());
		
		miembro.addReproduccion(repro);
		cancion.addReproduccion(repro);
		
		updateMiembro(miembro);
		updateCancion(cancion);
		storeReproduccion(repro);
	}

	@Override
	public void crearPago(String username, double importe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Miembro> getListaMiembros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTipoPago(Miembro miembro) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}

	@Override
	public void updateMiembro(Miembro miembro) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(miembro);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}

	@Override
	public void updateCancion(Cancion cancion) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(cancion);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
}
