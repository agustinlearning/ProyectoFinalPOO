package servidor;

import java.time.LocalDate;

import logico.Bolsa;
import logico.Oferta;

public class HiloOfertas implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
                LocalDate hoy = LocalDate.now();

                for (Oferta oferta : Bolsa.getBolsa().lasOfertas) { 
                    if (oferta.getEstado().equalsIgnoreCase("disponible") && oferta.getFechaLimite().isBefore(hoy)) {
                        oferta.setEstado("agotada"); 
                        
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
