
package InterfazDeConcesionario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import Conexion.DatosClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import ConexionCoche.CochesDisponibles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class VentanaWeb extends JFrame {
    JPanel panelWeb;
    JLabel portadaWeb;
    JButton botonCoche;
    private Integer codigoCliente = null;
    private boolean idClienteObtenido = false;
    private int idClienteIngresado = -1; // Valor inicial que indica que no se ha ingresado ningún ID
    private boolean registrado = false; // Valor inicial que indica que el usuario no está registrado
    private int idCliente = -1; // Valor inicial que indica que no hay ningún cliente registrado



    public VentanaWeb() {
    this.setBounds(150, 100, 1100, 600);
    this.setTitle("Página web");
    Toolkit miToolkitWeb = Toolkit.getDefaultToolkit();
    Image image = miToolkitWeb.getImage("src/Portada/logo.jpeg");
    ImageIcon miIcono = new ImageIcon(image);
    this.setIconImage(miIcono.getImage());
    iniciarComponentes();
}
    
public void iniciarComponentes(){
    cPaneles();
    cPortadaWeb();
    cBotonDatosPersonales();
    cBotonCoches();
    
}


private boolean verificarClienteRegistrado(int idCliente) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Concesionario", "root", "link");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM clientes WHERE id = ?");
        statement.setInt(1, idCliente);
        ResultSet resultSet = statement.executeQuery();
        boolean clienteRegistrado = resultSet.next();
        resultSet.close();
        statement.close();
        connection.close();
        return clienteRegistrado;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


private void guardarClienteEnBaseDeDatos(int idCliente) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Concesionario", "root", "link");
        PreparedStatement statement = connection.prepareStatement("INSERT INTO clientes (id) VALUES (?)");
        statement.setInt(1, idCliente);
        statement.executeUpdate();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
public void cPaneles(){
     panelWeb=new JPanel();
     panelWeb.setLayout(null);
     this.add(panelWeb);
    
}

 public void cPortadaWeb() {
        ImageIcon imagenPortada = new ImageIcon("src/InterfazDeConcesionario/garaje.jpg");
        Image image = imagenPortada.getImage().getScaledInstance(1280, 853, Image.SCALE_DEFAULT);
        ImageIcon imagenEscalada = new ImageIcon(image);
        portadaWeb = new JLabel(imagenEscalada);
        portadaWeb.setBounds(0, 0, 1280, 853);
        panelWeb.add(portadaWeb);
    }
 
 public void cBotonDatosPersonales(){
     ImageIcon imagenCliente = new ImageIcon("src/InterfazDeConcesionario/usuario.jpg");
     Image image = imagenCliente.getImage().getScaledInstance(180, 80, Image.SCALE_DEFAULT);
     ImageIcon imagenX = new ImageIcon(image);
     JButton botonDatos = new JButton (imagenX);
     botonDatos.setBounds(200,95,180,80);
     botonDatos.setBackground(Color.white);
     Border bordebotonDatos= BorderFactory.createLineBorder(Color.black, 4);
     botonDatos.setBorder(bordebotonDatos);
     botonDatos.setMnemonic('x');
     botonDatos.setToolTipText("Acceder a Datos Personales");
     panelWeb.add(botonDatos);
     panelWeb.setComponentZOrder(botonDatos, 0);
     
     botonDatos.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DatosClientes datosClientes = new DatosClientes();
        datosClientes.setVisible(true);
    }
});
/*   
botonDatos.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(null, "Ingresa tu ID de cliente:");
        try {
            int idClienteIngresado = Integer.parseInt(input);
            if (verificarClienteRegistrado(idClienteIngresado)) {
                guardarClienteEnBaseDeDatos(idClienteIngresado);
                JOptionPane.showMessageDialog(null, "Te has registrado exitosamente como cliente");
            } else {
                JOptionPane.showMessageDialog(null, "El ID de cliente ingresado no es válido");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un número válido como ID de cliente");
        }
    }
});

*/



     
 }
 
public void cBotonCoches() {
    ImageIcon imagenCoche = new ImageIcon("src/InterfazDeConcesionario/coche.jpeg");
    Image image = imagenCoche.getImage().getScaledInstance(130, 60, Image.SCALE_SMOOTH);
    ImageIcon imagenY = new ImageIcon(image);
    botonCoche = new JButton(imagenY);
    botonCoche.setBounds(650, 95, 180, 80);
    Border bordebotonCoches = BorderFactory.createLineBorder(Color.black, 4);
    botonCoche.setBorder(bordebotonCoches);
    botonCoche.setBackground(Color.white);
    botonCoche.setMnemonic('y');
    botonCoche.setToolTipText("Ver Coches Disponibles");
    panelWeb.add(botonCoche);
    panelWeb.setComponentZOrder(botonCoche, 0);
    
  botonCoche.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(null, "Ingresa tu ID de cliente:");
        try {
            int idClienteIngresado = Integer.parseInt(input);
            if (verificarClienteRegistrado(idClienteIngresado)) {
                CochesDisponibles cochesDisponibles = new CochesDisponibles();
                cochesDisponibles.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Debes registrarte como cliente primero");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un número válido como ID de cliente");
        }
    }
});


    
    
    
}

 
}







//ESTO LUEGO LO BORRARE
class Main{
    public static void main(String[] args) {
        VentanaWeb aa=new VentanaWeb();
        aa.setVisible(true);
        aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
