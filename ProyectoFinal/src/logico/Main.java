package logico;

public class Main {

	public static void main(String[] args) {
		//Bolsa bolsa = Bolsa.getBolsa();
		// la linea de abajo es para que no de warning
		//System.out.println(bolsa.lasEmpresas.get(0));
		
		Usuario user = new Usuario("Juancitobonilla58@gmail.com","8299724988","persona");
		
		System.out.println(user.getUsername());
		

	}

}
