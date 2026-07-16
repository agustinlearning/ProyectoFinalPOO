package logico;

public class Empresa {

	private String id;
	private static int counterId=1;
	private String rnc;
	private Representante representante;
	private String razonSocial;
	private float kpi;
	private String ubicacion;
	
	public Empresa(String rnc, Representante representante, String razonSocial, String ubicacion) {
		super();
		this.id = ""+counterId++;
		this.rnc = rnc;
		this.representante = representante;
		this.razonSocial = razonSocial;
		this.ubicacion = ubicacion;
	}
	
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	public Representante getRepresentante() {
		return representante;
	}
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public float getKpi() {
		return kpi;
	}
	public void setKpi(float kpi) {
		this.kpi = kpi;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getId() {
		return id;
	}
}
