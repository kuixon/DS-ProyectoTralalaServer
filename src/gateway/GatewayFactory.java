package gateway;

public class GatewayFactory {
	private static GatewayFactory instance;
	
	private GatewayFactory() {
	}
	
	public static synchronized GatewayFactory getInstance() {
		if (instance == null) {
			instance = new GatewayFactory();
		}
		
		return instance;
	}
	
	public static IGateway createIGateway(int type, String address) {		
		if(type == 0)
		{
			return new PayPal(address); 
		} else if(type == 1) {
			return new Barclays(address); 
		}
		
		return null;
	}
}
