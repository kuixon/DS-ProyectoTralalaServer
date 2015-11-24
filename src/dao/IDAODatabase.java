package dao;

import java.rmi.Remote;
import java.util.Set;

import data.Cancion;
import data.Miembro;
import data.Pago;
import data.Reproduccion;

public interface IDAODatabase {
	public void storeReproduccion(Reproduccion repro);
	public void storePago(Pago pago);
	public Set<Cancion> getListaCanciones(String artista);
	public void storeMiembro(Miembro miembro);
	public void storeCancion(Cancion cancion);
	public Miembro getMiembro(String username);
	public Cancion getCancion(String titulo);
	public Set<Reproduccion> getReproducciones(Miembro miembro);
	public void crearReproduccion(String username, String titulo);
	public void crearPago(String username, double importe);
	public Set<Miembro> getListaMiembros();
	public int getTipoPago(Miembro miembro);
	public void updateMiembro(Miembro miembro);
	public void updateCancion(Cancion cancion);
}
