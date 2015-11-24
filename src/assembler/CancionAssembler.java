package assembler;

import data.Cancion;
import data.CancionDTO;

public class CancionAssembler {
	private static CancionAssembler instance;
	
	private CancionAssembler() {
	}
	
	public static synchronized CancionAssembler getInstance() {
		if (instance == null) {
			instance = new CancionAssembler();
		}
		
		return instance;
	}
	
	public CancionDTO entityDTO(Cancion cancion) {
		return new CancionDTO(cancion.getTitulo(), cancion.getArtista(), cancion.getDuracion(),
				cancion.getFechaSalida(), cancion.getPrecRep(), cancion.getLetra());
	}
	
	public Cancion entity(CancionDTO cancionDTO) {
		return new Cancion(cancionDTO.getTitulo(), cancionDTO.getArtista(), cancionDTO.getDuracion(),
				cancionDTO.getFechaSalida(), cancionDTO.getPrecRep(), cancionDTO.getLetra());
	}
}
