package assembler;

import data.Miembro;
import data.MiembroDTO;

public class MiembroAssembler {
	private static MiembroAssembler instance;
	
	private MiembroAssembler() {
	}
	
	public static synchronized MiembroAssembler getInstance() {
		if (instance == null) {
			instance = new MiembroAssembler();
		}
		
		return instance;
	}
	
	public MiembroDTO entityDTO(Miembro miembro) {
		return new MiembroDTO(miembro.getNombre(), miembro.getUsername());
	}
	
	public Miembro entity(MiembroDTO miembroDTO) {
		return new Miembro(miembroDTO.getNombre(), miembroDTO.getUsername());
	}
}
