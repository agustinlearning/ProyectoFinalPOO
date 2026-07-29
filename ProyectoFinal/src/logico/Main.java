package logico;

import visual.Principal;

public class Main {

	public static void main(String[] args) {
		Bolsa bolsa = Bolsa.getBolsa();
		// la linea de abajo es para que no de warning
		//System.out.println(bolsa.lasEmpresas.get(0));
		
		Usuario user = new Usuario(bolsa.generarIdUsuarios(),"Admin@gmail.com","admin","admin");
		Sesion sesion = new Sesion(user);
		bolsa.registrarUsuario(user);
		Principal main = new Principal(sesion);
		main.setVisible(true);
		//System.out.println(user.getUsername());
		

	}

}
