
package Codigo;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        
        ArrayList <Vehiculos> mV = new ArrayList <Vehiculos> ();
        
        mV.add(new Coche("Nissan", "Skyline GTR R34", "1999", "Azul", "XYZ789", 5000.0, 50000, 2, "Gasolina", "Manual", 2, "RB26DETT", "Nuevo"));
        mV.add(new Coche("Ford", "Mustang", "2022", "Amarillo", "ABC123", 1000.0, 64500.0, 4, "Gasolina", "Automática", 2, "V8", "Nuevo"));
        mV.add(new Coche("Toyota", "Supra", "2023", "Naranja", "DEF456", 2000.0, 70150.0, 2, "Gasolina", "Automática", 2, "Inline-6", "Nuevo"));
        mV.add(new Coche("Dodge", "Charger R/T", "1970", "Negro", "JKL012", 3000.0, 100000, 5, "Gasolina", "Automática", 4, "V8 HEMI", "Nuevo"));
        mV.add(new Coche("Dodge", "Charger Daytona", "1969", "Azul", "MNO345", 4000.0, 33333, 5, "Gasolina", "Automática", 4, "V8 HEMI", "Nuevo"));
        
        for(Vehiculos e:mV){
            System.out.println(e.toString());
            e.getVelocidadMaxima();
            e.getAceleracion();
            e.getFrenada();
            e.getTraccion();
            System.out.println("\n");
        }




        
    }
}
