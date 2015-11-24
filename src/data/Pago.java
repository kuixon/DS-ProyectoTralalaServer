package data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Pago implements Serializable{
	private String fechaPago;
	private double cantidad;
	private Miembro miembro;
	
	public Pago() {
	}

	public Pago(String fechaPago, double cantidad, Miembro miembro) {
		this.fechaPago = fechaPago;
		this.cantidad = cantidad;
		this.miembro = miembro;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}
}
