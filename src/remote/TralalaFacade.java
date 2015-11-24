package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import services.PagoService;
import services.TralalaService;

import data.CancionDTO;
import data.MiembroDTO;

public class TralalaFacade extends UnicastRemoteObject implements ITralalaFacade {
	private String serverName;
	
	public TralalaFacade(String serverName) throws RemoteException {
		this.serverName = serverName;
		PagoService.getInstance().createIGateways();
	}

	public boolean iniciarSesion(String username, String password) throws RemoteException {
		System.out.println("Estoy en la fachada iniciando sesion");
		return TralalaService.getInstance().iniciarSesion(username, password);
	}
	
	public void pagar(MiembroDTO miembroDTO, double importe, int tipoPago)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void reproducir(String username, CancionDTO cancionDTO) {
		TralalaService.getInstance().crearReproduccion(username, cancionDTO);
	}

	public Set<CancionDTO> buscar(String artista) {
		return TralalaService.getInstance().buscar(artista);
	}

	public void seleccionarTipoPago() {
		// TODO Auto-generated method stub
		System.out.println("kakakakakakakaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	public void seleccionarTarifa() {
		// TODO Auto-generated method stub
		
	}

	public void calcularImportes() {
		// TODO Auto-generated method stub
		
	}

	public int getTipoPago(MiembroDTO miembroDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
}
