package servidor;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    
    // Ahora recibe la IP y el puerto por parámetro
    public static void enviarRespaldoAlServidor(String ip, int puerto) {
        
        File archivoLocal = new File("bolsa_datos.dat"); 

        if (!archivoLocal.exists()) {
            System.out.println("Error: El archivo local no existe.");
            return;
        }

        System.out.println("Intentando conectar con el servidor en " + ip + ":" + puerto);

        try (Socket socket = new Socket(ip, puerto)) {
            System.out.println("Conexion establecida");
            
            FileInputStream lectorArchivo = new FileInputStream(archivoLocal);
            DataOutputStream salidaDatos = new DataOutputStream(socket.getOutputStream());
            
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaFormateada = ahora.format(formateador);
            
            salidaDatos.writeUTF(fechaFormateada);
            System.out.println("Fecha enviada: " + fechaFormateada);
            
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            
            System.out.println("Enviando archivo...");
            
            while ((bytesLeidos = lectorArchivo.read(buffer)) != -1) {
                salidaDatos.write(buffer, 0, bytesLeidos);
            }
            
            salidaDatos.flush();
            lectorArchivo.close();
            System.out.println("Respaldo enviado exitosamente.");

        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}