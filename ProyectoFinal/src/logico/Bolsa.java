package logico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Bolsa {
	private static Bolsa bolsa  = null;

	public ArrayList<Empresa> lasEmpresas;
	public ArrayList<Persona> lasPersonas;
	public ArrayList<Solicitud> lasSolicitudes;
	public ArrayList<Oferta> lasOfertas;
	public ArrayList<Usuario> losUsuarios; 
	
	private Bolsa() {
		super();
		this.lasEmpresas = new ArrayList<>();
		this.lasPersonas = new ArrayList<>();
		this.lasSolicitudes = new ArrayList<>();
		this.lasOfertas = new ArrayList<>();
		this.losUsuarios = new ArrayList<>();
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
			boolean needLicencia, boolean disMudarse, String tipoCandidato, float minCoincidencia, int cantPuestos, int anosExpRequeridos, ArrayList<String> lasHabilidades) {
		if(empresa == null) {return;}
		Oferta oferta = new Oferta(empresa, titulo, descripcion,salarioMin, salarioMax, provincia, needLicencia, disMudarse, tipoCandidato, minCoincidencia, cantPuestos, anosExpRequeridos, lasHabilidades);
		lasOfertas.add(oferta);	
	}
	
	public void crearSolicitud(Persona persona, Oferta oferta) {
		if(persona == null || oferta == null) {return;}
		Solicitud solicitud = new Solicitud(persona, oferta, LocalDate.now());
		lasSolicitudes.add(solicitud);
	}
	
	// prototipo del algoritmo de macheo
	
	public ArrayList<Persona> mejoresCandidatosOferta(Oferta oferta){
		ArrayList<Persona> estasPersonas = new ArrayList<>();
		ArrayList<CandidatoEvaluado> candidatos = new ArrayList<>();
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
			if(per.getAspSalarial() <= oferta.getSalarioMax() && per.getAspSalarial() >= oferta.getSalarioMin()) {
				puntosAcumulados += 10;
			}
			// esto evaluara años de exp si es tecnico, la carrera si es universitario, y si es obrero las habilidades
			puntosAcumulados += per.evaluarReqEspec(oferta); 
			
			if(puntosAcumulados >= oferta.getMinCoincidencia()) {
				//estasPersonas.add(per);
				CandidatoEvaluado evaluado = new CandidatoEvaluado(per, puntosAcumulados);
				candidatos.add(evaluado);
			}
		}
		candidatos.sort(Comparator.comparing(CandidatoEvaluado::getPuntajeTotal));
		for(CandidatoEvaluado cand : candidatos) {
			estasPersonas.add(cand.getCandidato());
		}
		return estasPersonas;
	}
	
	public Usuario buscarUsuarioPorUsername(String username)
	{
		for (Usuario usuario : losUsuarios) {
			if(usuario.getUsername().equalsIgnoreCase(username))
			{
				return usuario;
			}
		}
		return null;
	}
	
	
	
	
}
