package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String rnc;
	private Representante representante;
	private String razonSocial;
	private float kpi;
	private String ubicacion;
	private ArrayList<Persona> candidatosContratados;
	
	public Empresa(String id, String rnc, Representante representante, String razonSocial, String ubicacion) {
		super();
		this.id = id;
		this.rnc = rnc;
		this.representante = representante;
		this.razonSocial = razonSocial;
		this.ubicacion = ubicacion;
		this.candidatosContratados = new ArrayList<>();
	}
	
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	public Representante getRepresentante() {
		return representante;
	}
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public float getKpi() {
		return kpi;
	}
	public void setKpi(float kpi) {
		this.kpi = kpi;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getId() {
		return id;
	}

	public ArrayList<Persona> getCandidatosContratados() {
		return candidatosContratados;
	}

	public void setCandidatosContratados(ArrayList<Persona> candidatosContratados) {
		this.candidatosContratados = candidatosContratados;
	}
	
	public void contratarCandidato(Persona candidato) {
	    candidatosContratados.add(candidato);
	}
}
