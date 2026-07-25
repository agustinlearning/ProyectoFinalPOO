package logico;

import java.util.ArrayList;

public class Obrero extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> habilidades;
	public Obrero(String id, String cedula, String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo, ArrayList<String> habilidades) {
		super(id,cedula, nombre, usuario, aspSalarial, licencia, dispMudar, provincia, sexo);
		// TODO Auto-generated constructor stub
		this.setHabilidades(habilidades);
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	

	@Override
	public int evaluarReqEspec(Oferta oferta) {
		int total=0;
		for(String habilidadOferta : oferta.getLasHabilidades()) {
			for(String habilidadObrero : habilidades) {
				if(habilidadObrero.equalsIgnoreCase(habilidadOferta)) {
					total += 5;
				}
			}
		}
		return total;
	}

}
