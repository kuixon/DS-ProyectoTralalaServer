package gateway;

import data.Miembro;

public interface IGateway {
	public void pagar(Miembro miembro, double importe);
}
