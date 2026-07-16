package logico;

import java.time.LocalDate;
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
	
	public void crearOferta(Empresa empresa, String titulo, String descripcion, int salarioMin, int salarioMax, String provincia,
			boolean needLicencia, boolean disMudarse, String tipoCandidato, float minCoincidencia, int cantPuestos) {
		if(empresa == null) {return;}
		Oferta oferta = new Oferta(empresa, titulo, descripcion,salarioMin, salarioMax, provincia, needLicencia, disMudarse, tipoCandidato, minCoincidencia, cantPuestos);
		lasOfertas.add(oferta);	
	}
	
	public void crearSolicitud(Persona persona, Oferta oferta) {
		if(persona == null || oferta == null) {return;}
		Solicitud solicitud = new Solicitud(persona, oferta, LocalDate.now());
		lasSolicitudes.add(solicitud);
	}
	
	// prototipo del algoritmo de maceho
	
	public ArrayList<Persona> mejoresCandidatosOferta(Oferta oferta){
		ArrayList<Persona> estasPersonas = new ArrayList<>();
		int puntosAcumulados=0;
		for(Persona per : lasPersonas) {
			
			if(oferta.isNeedLicencia() && !per.isLicencia()) {continue;}
			if(oferta.getTipoCandidato().equalsIgnoreCase("universitario") && (per instanceof Obrero)) {continue;}
			
			if(oferta.getProvincia().equalsIgnoreCase(per.getProvincia())) { 
				puntosAcumulados += 10;
			} else if(per.isDispMudar()) {
				puntosAcumulados += 5;
			}
			
			// si esta en el rango salarial.
			if(per.getAspSalarial() <= oferta.getSalarioMax() || per.getAspSalarial() >= oferta.getSalarioMin()) {
				puntosAcumulados += 10;
			}
			// esto evaluara años de exp si es tecnico, la carrera si es universitario, y si es obrero las habilidades
			puntosAcumulados += per.evaluarReqEspec(oferta); 
			
			if(puntosAcumulados >= oferta.getMinCoincidencia()) {
				estasPersonas.add(per);
			}
		}
		// resolver la falta del puntosAcumulados en las personas para obtener criterio de ordenamiento
		//estasPersonas.sort(c);
				
		
		return estasPersonas;
	}
	
	
	
}










