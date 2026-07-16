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
	
	public boolean registrarEmpresa(String rnc, Representante representante, String razonSocial, String ubicacion) {
		boolean valido = false;
		for(Empresa emp : lasEmpresas) {
			if(emp.getRnc().equalsIgnoreCase(rnc)) {return false;}
		}
		Empresa empresa = new Empresa(rnc, representante, razonSocial, ubicacion);
		lasEmpresas.add(empresa);
		valido = true;
		
		return valido;
	}
	
	public boolean registraPersona(Persona persona) {
		boolean valido=false;
		for(Persona per : lasPersonas) {
			if(per.getCedula().equalsIgnoreCase(persona.getCedula())) {return false;}
		}
		lasPersonas.add(persona);
		valido = true;
		return valido;
	}
	

	
	
	
	
}










