package logico;

import java.util.ArrayList;

public class Obrero extends Persona {

	private ArrayList<String> habilidades;
	public Obrero(String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo, ArrayList<String> habilidades) {
		super(nombre, usuario, aspSalarial, licencia, dispMudar, provincia, sexo);
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
	public int evaluarReqEspec() {
		// TODO Auto-generated method stub
		return 0;
	}

}
