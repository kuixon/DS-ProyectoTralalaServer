package services;

import java.util.ArrayList;
import java.util.List;

import gateway.GatewayFactory;
import gateway.IGateway;

public class PagoService {
	private static PagoService instance;
	private static List<IGateway> lista = new ArrayList<IGateway>();
	
	private PagoService() {
	}
	
	public static synchronized PagoService getInstance() {
		if (instance == null) {
			instance = new PagoService();
		}
		
		return instance;
	}
	
	public void createIGateways() {
		lista.add(GatewayFactory.createIGateway( 0, "//127.0.0.1:1099/paypal"));
		lista.add(GatewayFactory.createIGateway( 1, "//127.0.0.1:1099/barclays"));
	}
}
