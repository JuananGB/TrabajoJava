

package ConexionCoche;

import javax.swing.JFrame;
import Codigo.*;
import ConexionCoche.Caracteristicas.VentanaChargerDay;
import ConexionCoche.Caracteristicas.VentanaChargerRT;
import ConexionCoche.Caracteristicas.VentanaMustang;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import ConexionCoche.Caracteristicas.VentanaNissan;
import ConexionCoche.Caracteristicas.VentanaSupra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CochesDisponibles extends JFrame {
    
    JPanel panel;
    private ArrayList<Vehiculos> miArrayList;


    public CochesDisponibles(){
        this.setBounds(300, 0, 716, 900);
        this.setTitle("Página web");
        Toolkit miToolkitWeb = Toolkit.getDefaultToolkit();
        Image image = miToolkitWeb.getImage("src/Portada/logo.jpeg");
        ImageIcon miIcono = new ImageIcon(image);
        this.setIconImage(miIcono.getImage());
        this.setTitle("Galeria de coches");
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        cPaneles();
        cEtiqueta();
        cNissan();
        cMustang();
        cSupra();
        cChargerRT();
        cChargerDay();
        miArrayList = new ArrayList<Vehiculos>();
        miArrayList.add(new Coche("Nissan", "Skyline GTR R34", "1999", "Azul", "XYZ789", 5000.0, 50000.0, 2, "Gasolina", "Manual", 2, "RB26DETT", "Nuevo"));
        miArrayList.add(new Coche("Ford", "Mustang", "2022", "Rojo", "ABC123", 1000.0, 64500.0, 4, "Gasolina", "Automática", 2, "V8", "Nuevo"));
        miArrayList.add(new Coche("Toyota", "Supra", "2023", "Naranja", "DEF456", 2000.0, 70150.0, 2, "Gasolina", "Automática", 2, "Inline-6", "Nuevo"));
        miArrayList.add(new Coche("Dodge", "Charger R/T", "1970", "Negro", "JKL012", 3000.0, 100000.0, 5, "Gasolina", "Automática", 4, "V8 HEMI", "Nuevo"));
        miArrayList.add(new Coche("Dodge", "Charger Daytona", "1969", "Azul", "MNO345", 4000.0, 33333, 5, "Gasolina", "Automática", 4, "V8 HEMI", "Nuevo"));


    }
    
    public void cPaneles(){
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(153, 0, 0));
        this.add(panel);
    }
    
    public void cEtiqueta(){
        JLabel etiqueta=new JLabel();
        etiqueta.setText("COCHES");
       // etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(250, 40, 200, 70);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Showcard Gothic",2,50));
        panel.add(etiqueta);
        
    }
    
    public void cNissan(){
        
        JButton botonNissan=new JButton();
        botonNissan.setText("Nissan Skyline GTR R34");
        botonNissan.setBounds(0, 115, 700, 70);
        botonNissan.setForeground(Color.BLACK);
        botonNissan.setBackground(Color.white);
        botonNissan.setFont(new Font("Showcard Gothic",2,40));
        Border bordeBotonNissan= BorderFactory.createLineBorder(Color.BLACK, 5);
        botonNissan.setBorder(bordeBotonNissan);
        panel.add(botonNissan);
        
        botonNissan.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Abre la ventana "VentanaDatos" y pasa el objeto Coche del modelo Nissan
            for (Vehiculos vehiculo : miArrayList) {
                if (vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getMarca().equals("Nissan")) {
                        VentanaNissan ventanaDatos = new VentanaNissan(coche);
                        ventanaDatos.setVisible(true);
                        break;  // Si solo hay un coche Nissan en la lista, puedes salir del bucle
                    }
                }
            }
        }
    });
           
    }
    
     public void cMustang() {
    JButton botonMustang = new JButton();
    botonMustang.setText("Ford Mustang");
    botonMustang.setBounds(0, 200, 700, 70);
    botonMustang.setForeground(Color.BLACK);
    botonMustang.setBackground(Color.WHITE);
    botonMustang.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
    Border bordeBotonMustang = BorderFactory.createLineBorder(Color.BLACK, 5);
    botonMustang.setBorder(bordeBotonMustang);
    panel.add(botonMustang);

    botonMustang.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Abre la ventana "VentanaMustang" y pasa el objeto Coche del modelo Mustang
            for (Vehiculos vehiculo : miArrayList) {
                if (vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getMarca().equals("Ford") && coche.getModelo().equals("Mustang")) {
                        VentanaMustang ventanaDatosM = new VentanaMustang(coche);
                        ventanaDatosM.setVisible(true);
                        break;
                    }
                }
            }
        }
    }); 
}
 public void cSupra(){
    JButton botonSupra = new JButton();
    botonSupra.setText("Toyota Supra");
    botonSupra.setBounds(0, 285, 700, 70);
    botonSupra.setForeground(Color.BLACK);
    botonSupra.setBackground(Color.WHITE);
    botonSupra.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
    Border bordeBotonSupra = BorderFactory.createLineBorder(Color.BLACK, 5);
    botonSupra.setBorder(bordeBotonSupra);
    panel.add(botonSupra);

    botonSupra.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Vehiculos vehiculo : miArrayList) {
                if (vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getMarca().equals("Toyota") && coche.getModelo().equals("Supra")) {
                        VentanaSupra ventanaDatosM = new VentanaSupra(coche);
                        ventanaDatosM.setVisible(true);
                        break;
                    }
                }
            }
        }
    }); 
        
    }
 
 public void cChargerRT(){
    JButton botonChargerRT = new JButton();
    botonChargerRT.setText("Dodge Charger r/t");
    botonChargerRT.setBounds(0, 370, 700, 70);
    botonChargerRT.setForeground(Color.BLACK);
    botonChargerRT.setBackground(Color.WHITE);
    botonChargerRT.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
    Border bordeBotonSupra = BorderFactory.createLineBorder(Color.BLACK, 5);
    botonChargerRT.setBorder(bordeBotonSupra);
    panel.add(botonChargerRT);

    botonChargerRT.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Vehiculos vehiculo : miArrayList) {
                if (vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getMarca().equals("Dodge") && coche.getModelo().equals("Charger R/T")) {
                        VentanaChargerRT ventanaDatosM = new VentanaChargerRT(coche);
                        ventanaDatosM.setVisible(true);
                        break;
                    }
                }
            }
        }
    }); 
    
    
    
 }
 
 public void cChargerDay(){
    JButton botonChargerDay = new JButton();
    botonChargerDay.setText("Dodge Charger Daytona");
    botonChargerDay.setBounds(0, 460, 700, 70);
    botonChargerDay.setForeground(Color.BLACK);
    botonChargerDay.setBackground(Color.WHITE);
    botonChargerDay.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
    Border bordeBotonChargerDay = BorderFactory.createLineBorder(Color.BLACK, 5);
    botonChargerDay.setBorder(bordeBotonChargerDay);
    panel.add(botonChargerDay);

    botonChargerDay.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Vehiculos vehiculo : miArrayList) {
                if (vehiculo instanceof Coche) {
                    Coche coche = (Coche) vehiculo;
                    if (coche.getMarca().equals("Dodge") && coche.getModelo().equals("Charger Daytona")) {
                        VentanaChargerDay ventanaDatosM = new VentanaChargerDay(coche);
                        ventanaDatosM.setVisible(true);
                        break;
                    }
                }
            }
        }
    });
    }
     
}











