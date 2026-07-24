package logico;

public class Usuario {
	private String id;
	private static int counterId = 1;
	private String username;
	private String email;
	private String contrasena;
	private String rol;
	private Persona perfilP;
	private Empresa perfilE;
	
	
	public Usuario(String email, String contrasena, String rol) {
		super();
		this.id = ""+counterId++;
		this.email = email;
		this.username = (email.split("@"))[0];	
		this.contrasena = contrasena;
		this.rol = rol;
		this.perfilE= null;
		this.perfilP = null;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Persona getPerfilP() {
		return perfilP;
	}

	public void setPerfilP(Persona perfilP) {
		this.perfilP = perfilP;
	}

	public Empresa getPerfilE() {
		return perfilE;
	}

	public void setPerfilE(Empresa perfilE) {
		this.perfilE = perfilE;
	}

	
}
