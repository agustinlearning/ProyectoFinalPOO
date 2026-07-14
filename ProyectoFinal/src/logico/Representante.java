package logico;

public class Representante {

	private String id;
	private static int counterId=1;
	private String cedula;
	private String nombre;
	private String cargo;
	private Usuario usuario;
	
	public Representante(String cedula, String nombre, String cargo) {
		super();
		this.id = ""+counterId++;
		this.cedula = cedula;
		this.nombre = nombre;
		this.cargo = cargo;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getId() {
		return id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
