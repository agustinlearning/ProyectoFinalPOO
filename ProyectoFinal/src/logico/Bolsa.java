package logico;

import java.util.ArrayList;

public class Bolsa {
	private static Bolsa bolsa;

	public ArrayList<Empresa> lasEmpresas;
	public ArrayList<Persona> lasPersonas;
	public ArrayList<Solicitud> lasSolicitudes;
	public ArrayList<Oferta> lasOfertas;
	
	private Bolsa() {
		super();
		this.lasEmpresas = new ArrayList<>();
		this.lasPersonas = new ArrayList<>();
		this.lasSolicitudes = new ArrayList<>();
		this.lasOfertas = new ArrayList<>();
	}

	
	public static Bolsa getBolsa() {
		if(bolsa == null) {
			bolsa = new Bolsa();
		}
		return bolsa;
	}
	
	public ArrayList<Persona> conectarCandidatos(Oferta oferta){
		return null;
	}
}
