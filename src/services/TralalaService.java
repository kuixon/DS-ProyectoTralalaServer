package services;

import gateway.GatewayServicioAutorizacion;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import assembler.CancionAssembler;

import dao.DAODatabase;
import dao.IDAODatabase;
import data.Cancion;
import data.CancionDTO;

public class TralalaService {
	private static TralalaService instance;
	
	private TralalaService() {
	}
	
	public static synchronized TralalaService getInstance() {
		if (instance == null) {
			instance = new TralalaService();
		}
		
		return instance;
	}
	
	public boolean iniciarSesion(String username, String password) throws RemoteException {
		System.out.println("Estoy en el TralalaService iniciando sesion");
		return GatewayServicioAutorizacion.getInstance().getService().iniciarSesion(username, password);
	}
	
	//Metodo para almacenar la reproduccion
	public void crearReproduccion(String username, CancionDTO cancionDTO) {
		DAODatabase.getInstance().crearReproduccion(username, cancionDTO.getTitulo());
	}
	
	public Set<CancionDTO> buscar(String artista) {
		Set<Cancion> canciones = DAODatabase.getInstance().getListaCanciones(artista);
		Set<CancionDTO> cancionesDTO = new HashSet<>();
		
		for(Iterator<Cancion> i = canciones.iterator(); i.hasNext();) {
			cancionesDTO.add(CancionAssembler.getInstance().entityDTO(i.next()));
		}
		
		return cancionesDTO;
	}
}
