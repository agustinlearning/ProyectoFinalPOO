package logico;

public class Universitario extends Persona {
	private String titulo;
	public Universitario(String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo, String titulo) {
		super(nombre, usuario, aspSalarial, licencia, dispMudar, provincia, sexo);
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
	public int evaluarReqEspec() {
		// TODO Auto-generated method stub
		return 0;
	}

}
