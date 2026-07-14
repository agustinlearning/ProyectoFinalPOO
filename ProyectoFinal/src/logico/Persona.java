package logico;

public abstract class Persona {
	private String id;
	private static int counterId;
	private String nombre;
	private Usuario usuario;
	private float aspSalarial;
	private boolean licencia;
	private boolean dispMudar;
	private String provincia;
	private String sexo;
	
	public Persona(String nombre, Usuario usuario, float aspSalarial, boolean licencia, boolean dispMudar,
			String provincia, String sexo) {
		super();
		this.id = ""+counterId++;
		this.nombre = nombre;
		this.usuario = usuario;
		this.aspSalarial = aspSalarial;
		this.licencia = licencia;
		this.dispMudar = dispMudar;
		this.provincia = provincia;
		this.sexo = sexo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public float getAspSalarial() {
		return aspSalarial;
	}
	public void setAspSalarial(float aspSalarial) {
		this.aspSalarial = aspSalarial;
	}
	public boolean isLicencia() {
		return licencia;
	}
	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}
	public boolean isDispMudar() {
		return dispMudar;
	}
	public void setDispMudar(boolean dispMudar) {
		this.dispMudar = dispMudar;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getId() {
		return id;
	}
	
	public abstract int evaluarReqEspec();
	
}