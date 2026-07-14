package logico;

public class Usuario {
	private String id;
	private static int counterId;
	private String emal;
	private String contrasena;
	private String rol;
	
	public Usuario(String emal, String contrasena, String rol) {
		super();
		this.id = ""+counterId++;
		this.emal = emal;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	public String getEmal() {
		return emal;
	}
	public void setEmal(String emal) {
		this.emal = emal;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getId() {
		return id;
	}
}
