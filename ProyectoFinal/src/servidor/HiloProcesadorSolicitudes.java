package servidor;

import logico.Bolsa;
import logico.Solicitud;
import logico.Universitario;
import logico.Tecnico;
import logico.Obrero;
import logico.Oferta;
import logico.Persona;



public class HiloProcesadorSolicitudes implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				for(Solicitud sol : Bolsa.getBolsa().lasSolicitudes) {
					if(sol.getEstado().equalsIgnoreCase("disponible")) {
						sol.setEstado("revision");
						continue;
					}
					
					if(sol.getEstado().equalsIgnoreCase("revision")) {
						Persona candidato = sol.getCandidato();
						Oferta ofer = sol.getOferta();
						boolean rechazo = false;
						
						if (ofer.isNeedLicencia() && !candidato.isLicencia()) {
                            rechazo = true;
                        }
						
						String tipo = ofer.getTipoCandidato();
						if(tipo.equalsIgnoreCase("Universitario") && !(candidato instanceof Universitario)) {
							rechazo = true;
						}
						if(tipo.equalsIgnoreCase("Tecnico") && !(candidato instanceof Tecnico)) {
							rechazo = true;
						}
						if(tipo.equalsIgnoreCase("obrero") && !(candidato instanceof Obrero)) {
							rechazo = true;
						}
						
						if (rechazo) {
                            sol.setEstado("Rechazada/o");
                        } else {
                            sol.setEstado("Aprobada/o para Entrevista");
                        }
					}
					
					
				}
				Thread.sleep(600000);
			} catch(InterruptedException e){
				break;
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
		
	}

}
