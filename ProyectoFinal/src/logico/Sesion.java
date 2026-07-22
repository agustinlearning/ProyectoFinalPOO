package logico;

public class Sesion
{
	boolean activa;
	Usuario user;
	
	public Sesion(Usuario user) {
		super();
		this.user = user;
		this.activa = true;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	

}
