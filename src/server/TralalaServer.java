package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import dao.DAODatabase;

import remote.ITralalaFacade;
import remote.TralalaFacade;
import services.TralalaService;

public class TralalaServer {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			ITralalaFacade tralalaServer = new TralalaFacade(args[2]);
			Naming.rebind(name, tralalaServer);
//			TralalaService.getInstance();
			System.out.println("- Tralala server '" + name + "' active and waiting...");
			
			DAODatabase.getInstance();
//			System.out.println(tralalaServer.iniciarSesion("yo", "123"));
//			System.out.println(tralalaServer.buscar("Bertin").size());
//			System.out.println(tralalaServer.iniciarSesion("yo", "123"));
//			System.out.println(tralalaServer.iniciarSesion("tu", "123"));
		} catch (Exception e) {
			System.err.println("$ Tralala server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
