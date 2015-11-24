package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import data.CancionDTO;
import data.MiembroDTO;

public interface ITralalaFacade extends Remote {
	public boolean iniciarSesion(String username, String password) throws RemoteException;
	public void pagar(MiembroDTO miembroDTO, double importe, int tipoPago) throws RemoteException;
	public void reproducir(String username, CancionDTO cancion) throws RemoteException;
	public Set<CancionDTO> buscar(String artista) throws RemoteException;
	public void seleccionarTipoPago() throws RemoteException;
	public void seleccionarTarifa() throws RemoteException;
	public void calcularImportes() throws RemoteException;
	public int getTipoPago(MiembroDTO miembroDTO) throws RemoteException;
}
