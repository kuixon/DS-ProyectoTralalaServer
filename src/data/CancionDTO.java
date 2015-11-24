package data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CancionDTO implements Serializable {
	private String titulo;
	private String artista;
	private int duracion;
	private String fechaSalida;
	private double precRep;
	private String letra;
	
	public CancionDTO() {
	}
	
	public CancionDTO(String titulo, String artista, int duracion,
			String fechaSalida, double precRep, String letra) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.fechaSalida = fechaSalida;
		this.precRep = precRep;
		this.letra = letra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getPrecRep() {
		return precRep;
	}

	public void setPrecRep(double precRep) {
		this.precRep = precRep;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
}
