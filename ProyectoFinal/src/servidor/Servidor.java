package servidor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class Servidor {
	public static void main(String[] args) {
		
		try (ServerSocket serverSocket = new ServerSocket(7000)) {
            
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado: " + socketCliente.getInetAddress());
            
            InputStream entradaDatos = socketCliente.getInputStream();
            FileOutputStream escritorArchivo = new FileOutputStream("respaldo_bolsa.dat");
            
            byte[] buffer = new byte[4096]; // 4 KB
            int bytesLeidos;
            
            while ((bytesLeidos = entradaDatos.read(buffer)) != -1) {
                escritorArchivo.write(buffer, 0, bytesLeidos);
            }
            
            escritorArchivo.close();
            entradaDatos.close();
            
            System.out.println("Respaldo recibido y guardado");
            
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
	
}
