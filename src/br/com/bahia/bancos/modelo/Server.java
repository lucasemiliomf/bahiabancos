package br.com.bahia.bancos.modelo;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
	Server (){
		try {
			Banco b = new BancoImpl();
			Naming.rebind("rmi://192.168.0.40:1099/Banco", b);
		}
		catch (Exception e) {
			e.printStackTrace();
	}
}
	public static void main(String[] args) throws RemoteException{
	java.rmi.registry.Registry rmiRegistry = java.rmi.registry.LocateRegistry.createRegistry(1099);
	new Server();
	}
}
