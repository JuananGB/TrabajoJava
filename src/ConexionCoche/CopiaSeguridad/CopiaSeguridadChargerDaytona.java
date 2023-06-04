
package ConexionCoche.CopiaSeguridad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaSeguridadChargerDaytona {
        
      public static void guardarDatosEnArchivo(int idCliente, String marca, String modelo, String agno, String color, String matricula, double kilometraje, double precio, int capacidadPasajeros, String tipoGasolina, String transmision, int nPuertas, String motor, String estado) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/juang/OneDrive/Escritorio/Trabajo_Prog_Final/CopiasSeguridad/copia_seguridad_ChargerDaytona.txt", true));

        writer.write("ID Cliente: " + idCliente);
        writer.newLine();
        writer.write("Marca: " + marca);
        writer.newLine();
        writer.write("Modelo: " + modelo);
        writer.newLine();
        writer.write("Agno: " + agno);
        writer.newLine();
        writer.write("Color: "+color);
        writer.newLine();
        writer.write("Matricula: "+ matricula);
        writer.newLine();
        writer.write("Kilometraje: "+kilometraje);
        writer.newLine();
        writer.write("Precio: "+precio);
        writer.newLine();
        writer.write("Capacidad de Pasajeros: "+capacidadPasajeros);
        writer.newLine();
        writer.write("Tipo de Gasolina: "+tipoGasolina);
        writer.newLine();
        writer.write("Transmision: "+transmision);
        writer.newLine();
        writer.write("Numero de Puertas: "+nPuertas);
        writer.newLine();
        writer.write("Motor: "+motor);
        writer.newLine();
        writer.write("Estado del Vehiculo: "+estado);
        writer.newLine();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
   
}




