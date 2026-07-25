package servidor;

import logico.Bolsa;
import logico.Solicitud;


public class HiloProcesadorSolicitudes implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				for(Solicitud sol : Bolsa.getBolsa().lasSolicitudes) {
					if(sol.getEstado().equalsIgnoreCase("disponible")) {
						if(sol.getOferta().isNeedLicencia()) {
							
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
