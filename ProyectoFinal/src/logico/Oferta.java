package logico;

public class Oferta {
	public Oferta(Empresa empresa, String titulo, String descripcion, int salarioMin, int salarioMax, String provincia,
			boolean needLicencia, boolean disMudarse, String tipoCandidato, float minCoincidencia, int cantPuestos,
			int puestosTomados, String estado) {
		super();
		this.id = ""+counterId++;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.salarioMin = salarioMin;
		this.salarioMax = salarioMax;
		this.provincia = provincia;
		this.needLicencia = needLicencia;
		this.disMudarse = disMudarse;
		this.tipoCandidato = tipoCandidato;
		this.minCoincidencia = minCoincidencia;
		this.cantPuestos = cantPuestos;
		this.puestosTomados = puestosTomados;
		this.estado = estado;
	}
	private String id;
	private static int counterId=1;
	private Empresa empresa;
	private String titulo;
	private String descripcion;
	private int salarioMin;
	private int salarioMax;
	private String provincia;
	private boolean needLicencia;
	private boolean disMudarse;
	private String tipoCandidato; // conciderar usar un enum
	private float minCoincidencia;
	private int cantPuestos;
	private int puestosTomados;
	private String estado;
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getSalarioMin() {
		return salarioMin;
	}
	public void setSalarioMin(int salarioMin) {
		this.salarioMin = salarioMin;
	}
	public int getSalarioMax() {
		return salarioMax;
	}
	public void setSalarioMax(int salarioMax) {
		this.salarioMax = salarioMax;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean isNeedLicencia() {
		return needLicencia;
	}
	public void setNeedLicencia(boolean needLicencia) {
		this.needLicencia = needLicencia;
	}
	public boolean isDisMudarse() {
		return disMudarse;
	}
	public void setDisMudarse(boolean disMudarse) {
		this.disMudarse = disMudarse;
	}
	public String getTipoCandidato() {
		return tipoCandidato;
	}
	public void setTipoCandidato(String tipoCandidato) {
		this.tipoCandidato = tipoCandidato;
	}
	public float getMinCoincidencia() {
		return minCoincidencia;
	}
	public void setMinCoincidencia(float minCoincidencia) {
		this.minCoincidencia = minCoincidencia;
	}
	public int getCantPuestos() {
		return cantPuestos;
	}
	public void setCantPuestos(int cantPuestos) {
		this.cantPuestos = cantPuestos;
	}
	public int getPuestosTomados() {
		return puestosTomados;
	}
	public void setPuestosTomados(int puestosTomados) {
		this.puestosTomados = puestosTomados;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	
	
	
}
