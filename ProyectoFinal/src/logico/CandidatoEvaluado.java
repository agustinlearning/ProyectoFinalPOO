package logico;

public class CandidatoEvaluado {
	private Persona candidato;
	private int puntajeTotal;
	
	public CandidatoEvaluado(Persona candidato, int puntajeTotal) {
		super();
		this.candidato = candidato;
		this.puntajeTotal = puntajeTotal;
	}
	
	public Persona getCandidato() {
		return candidato;
	}
	public void setCandidato(Persona candidato) {
		this.candidato = candidato;
	}
	public int getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
}
