package gateway;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import login.IServicioAutorizacion;


public class GatewayServicioAutorizacion {
	
	private static GatewayServicioAutorizacion instance;
	private IServicioAutorizacion saService;
	
	private GatewayServicioAutorizacion() {
		setService("ServicioAutorizacion");
	}
	
	public static synchronized GatewayServicioAutorizacion getInstance() {
		if (instance == null) {
			instance = new GatewayServicioAutorizacion();
		}
		
		return instance;
	}
	
	public void setService(String s) {
    	if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
    	
    	System.out.println("Nombre del servidor " + s);
    	try {
    		saService = (IServicioAutorizacion) java.rmi.Naming.lookup(s);
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public IServicioAutorizacion getService() {
		return saService;
	}
}
