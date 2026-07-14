package logico;

public class Tecnico extends Persona {

	private String areaTecnica;
	private int anosExp;
	public Tecnico(String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo, String areaTecnica, int anosExp) {
		super(nombre, usuario, aspSalarial, licencia, dispMudar, provincia, sexo);
		// TODO Auto-generated constructor stub
		this.areaTecnica = areaTecnica;
		this.anosExp = anosExp;
	}

	public String getAreaTecnica() {
		return areaTecnica;
	}

	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}

	public int getAnosExp() {
		return anosExp;
	}

	public void setAnosExp(int anosExp) {
		this.anosExp = anosExp;
	}
	
	@Override
	public int evaluarReqEspec() {
		// TODO Auto-generated method stub
		return 0;
	}


}
