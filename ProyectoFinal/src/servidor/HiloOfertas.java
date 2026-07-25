package servidor;

import java.time.LocalDate;

import logico.Bolsa;
import logico.Oferta;
import logico.Solicitud;

public class HiloOfertas implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
                LocalDate hoy = LocalDate.now();

                for (Oferta oferta : Bolsa.getBolsa().lasOfertas) { 
                    if (oferta.getEstado().equalsIgnoreCase("disponible") && oferta.getFechaLimite().isBefore(hoy)) {
                        oferta.setEstado("Cerrada"); 
                        for (Solicitud sol : Bolsa.getBolsa().lasSolicitudes) {
                            if (sol.getOferta().getId().equals(oferta.getId()) && sol.getEstado().equals("Pendiente")) {
                                sol.setEstado("Cerrada");
                                //System.out.println(sol.getId() + " actualizada.");
                            }
                        }
                    }
    				Thread.sleep(60000); // 1 min
                }
                
			} catch(InterruptedException e) {
				break;
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
	}

}
