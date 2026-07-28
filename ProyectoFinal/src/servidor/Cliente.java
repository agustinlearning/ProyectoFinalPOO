package servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	public static void enviarRespaldoAlServidor() {
        
        File archivoLocal = new File("bolsa_datos.dat"); 

        if (!archivoLocal.exists()) {
            System.out.println("Error: El archivo local no existe.");
            return;
        }

        System.out.println("Intentando conectar con el servidor...");

        try (Socket socket = new Socket("localhost", 7000)) {
            System.out.println("Conexion establecida");
            
            FileInputStream lectorArchivo = new FileInputStream(archivoLocal);
            OutputStream salidaDatos = socket.getOutputStream();
            
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            
            System.out.println("Enviando archivo");
            
            while ((bytesLeidos = lectorArchivo.read(buffer)) != -1) {
                salidaDatos.write(buffer, 0, bytesLeidos);
            }
            
            salidaDatos.flush();
            lectorArchivo.close();

        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}
