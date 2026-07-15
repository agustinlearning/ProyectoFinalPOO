package logico;

public class Main {

	public static void main(String[] args) {
		Bolsa bolsa = Bolsa.getBolsa();
		// la linea de abajo es para que no de warning
		System.out.println(bolsa.lasEmpresas.get(0));

	}

}
