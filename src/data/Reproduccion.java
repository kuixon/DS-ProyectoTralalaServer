package data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Reproduccion implements Serializable{
	private String fechaRepro;
	private String hora;
	private Miembro miembro;
	private Cancion cancion;
	
	public Reproduccion() {
	}

	public Reproduccion(String fechaRepro, String hora, Miembro miembro,
			Cancion cancion) {
		this.fechaRepro = fechaRepro;
		this.hora = hora;
		this.miembro = miembro;
		this.cancion = cancion;
	}

	public String getFechaRepro() {
		return fechaRepro;
	}

	public void setFechaRepro(String fechaRepro) {
		this.fechaRepro = fechaRepro;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}

	public Cancion getCancion() {
		return cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}
}
