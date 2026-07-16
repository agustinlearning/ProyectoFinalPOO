package logico;

public class Universitario extends Persona {
	private String titulo;
	public Universitario(String cedula, String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo, String titulo) {
		super(cedula, nombre, usuario, aspSalarial, licencia, dispMudar, provincia, sexo);
		// TODO Auto-generated constructor stub
		this.setTitulo(titulo);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	@Override
	public int evaluarReqEspec(Oferta oferta) {
		int total=0;
		if(oferta.getTitulo().equalsIgnoreCase(this.titulo)) {
			total += 5;
		}
		
		return total;
	}

}
