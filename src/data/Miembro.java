package data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Miembro implements Serializable{
	private String nombre;
	private String username;
	private int tipoPago;
	private int tarifa;
	private Set<Reproduccion> repros = new HashSet<>();
	private Set<Pago> pagos = new HashSet<>();
	
	public Miembro() {
	}
	
	public Miembro(String nombre, String username) {
		this.nombre = nombre;
		this.username = username;
	}
	
	public Miembro(String nombre, String username,
			int tipoPago, int tarifa) {
		this.nombre = nombre;
		this.username = username;
		this.tipoPago = tipoPago;
		this.tarifa = tarifa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	
	public void addReproduccion(Reproduccion repro) {
		repros.add(repro);
	}

	public void removeReproduccion(Reproduccion repro) {
		repros.remove(repro);
	}

	public int getNumberOfRepros() {
		return repros.size();
	}	
	
	public Set<Reproduccion> getRepros() {
		return repros;
	}

	public void setRepros(Set<Reproduccion> repros) {
		this.repros = repros;
	}
	
	public void addPago(Pago pago) {
		pagos.add(pago);
	}

	public void removePago(Pago pago) {
		pagos.remove(pago);
	}

	public int getNumberOfPagos() {
		return pagos.size();
	}	
	
	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}
}
