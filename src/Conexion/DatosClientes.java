package Conexion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;

public class DatosClientes extends JFrame {

    JPanel miPanel;
    JTextField areaTexto1,areaTexto2,areaTexto3,areaTexto4,areaTexto5,areaTexto6;
    JLabel Resultado;
    JButton Consulta,Admin;
    JLabel codc; 
    JButton Borrar;
    JLabel codBorrar;
    JTextField areaTextoBorrar;
    JButton Modificar;
  
    
          

    private Connection conn = null;
    private String bd = "Concesionario";
    private String user = "root";
    private String pass = "link";
    private String ip = "localhost";
    private String puerto = "3306";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private ResultSet rs = null;
    private Statement st = null;

    private String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public DatosClientes() {
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        
        //CaAMBIO LA IMAGEN DE PORTADA
        Toolkit miobjeto=Toolkit.getDefaultToolkit();
        Image image=miobjeto.getImage("src/Portada/miPortada.png");
        ImageIcon icon=new ImageIcon(image);
        this.setIconImage(icon.getImage());
        /////////////////////////////////////////////////////////////////////7
       
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 600, 460);
        this.setTitle("CLIENTES");
        miPanel = new JPanel();
        this.setContentPane(miPanel);
        miPanel.setBackground(new Color(204, 204, 204));
        miPanel.setLayout(null);

        JLabel Ciclo = new JLabel();
        Ciclo.setText("DNI: ");
        Ciclo.setBounds(25, 38, 195, 15);
        Ciclo.setFont(new Font("arial",Font.BOLD,13));
        Ciclo.setForeground(Color.red);
        miPanel.add(Ciclo);

        areaTexto2 = new JTextField();
        areaTexto2.setBounds(200, 35, 150, 20);
        miPanel.add(areaTexto2);
        areaTexto2.setFont(new Font("arial",Font.BOLD,12));
        Border bordeTextoCiclo= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto2.setBorder(bordeTextoCiclo);
        areaTexto2.setColumns(10);
        
        //ID
        
        JLabel ID= new JLabel("ID: ");
        ID.setBounds(25, 75, 170, 15);
        ID.setFont(new Font("arial",Font.BOLD,13));
        ID.setForeground(Color.red);
        miPanel.add(ID);
        
        areaTexto1 = new JTextField();
        areaTexto1.setBounds(200, 70, 150, 23);
        areaTexto1.setFont(new Font("arial",Font.BOLD,12));
        Border bordeTextoID= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto1.setBorder(bordeTextoID);
        miPanel.add(areaTexto1);
        areaTexto1.setColumns(10);
        
        //NOMBRE
        
        JLabel nombre = new JLabel();
        nombre.setText("NOMBRE:");
        nombre.setBounds(25, 110, 195, 15);
        nombre.setFont(new Font("arial",Font.BOLD,13));
        nombre.setForeground(Color.red);
        miPanel.add(nombre);
        
       
      
        areaTexto4 = new JTextField();
        areaTexto4.setBounds(200, 106, 150, 23);
        areaTexto4.setFont(new Font("arial",Font.BOLD,12));
        Border bordeTextoNombre= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto4.setBorder(bordeTextoNombre);
        miPanel.add(areaTexto4);
        areaTexto4.setColumns(10);
        
        //APELLIDO PATERNO
        JLabel apellidoPaterno = new JLabel();
        apellidoPaterno.setText("APELLIDOPATERNO: ");
        apellidoPaterno.setBounds(25, 145, 195, 15);
        apellidoPaterno.setFont(new Font("arial",Font.BOLD,13));
        apellidoPaterno.setForeground(Color.red);
        miPanel.add(apellidoPaterno);
        
       
      
        areaTexto5 = new JTextField();
        areaTexto5.setBounds(200, 142, 150, 23);
        areaTexto5.setFont(new Font("arial",Font.BOLD,12));
        Border bordeTextoApellidoPaterno= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto5.setBorder(bordeTextoApellidoPaterno);
        miPanel.add(areaTexto5);
        areaTexto4.setColumns(10);
        
        //APELLIDO MATERNO
        
        JLabel apellidoMaterno= new JLabel();
        apellidoMaterno.setText("APELLIDOMATERNO: ");
        apellidoMaterno.setBounds(25, 182, 195, 15);
        apellidoMaterno.setFont(new Font("arial",Font.BOLD,13));
        apellidoMaterno.setForeground(Color.red);
        miPanel.add(apellidoMaterno);
        
       
      
        areaTexto6 = new JTextField();
        areaTexto6.setBounds(200, 178, 150, 23);
        areaTexto6.setFont(new Font("arial",Font.BOLD,12));
        Border bordeTextoApellidoMaterno= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto6.setBorder(bordeTextoApellidoMaterno);
        miPanel.add(areaTexto6);
        areaTexto4.setColumns(10);

    
     // ADMINISTRACION ALUMNOS
      
        JLabel Alta= new JLabel("Administracion de clientes: ");
        Alta.setBounds(25, 218, 200, 15);
        Alta.setFont(new Font("arial",Font.BOLD,13));
        Alta.setForeground(Color.red);
        miPanel.add(Alta);

        Admin = new JButton("AÑADIR CLIENTES");
        Admin.setBackground(new Color(0, 0, 0));
        Admin.setBounds(200, 215, 200, 25);
        Border bordeBoton= BorderFactory.createLineBorder(Color.white, 2);
        Admin.setBorder(bordeBoton);
        Admin.setMnemonic('1');
        Admin.setForeground(Color.white);
        miPanel.add(Admin);

        Resultado = new JLabel();
        Resultado.setBounds(415, 218, 230, 25);
        Resultado.setForeground(Color.white);
        miPanel.add(Resultado);

        codc = new JLabel("Digite el codigo de cliente a consultar: ");
        codc.setBounds(25, 260, 300, 14);
        codc.setFont(new Font("arial",Font.BOLD,13));
        codc.setForeground(Color.red);
        miPanel.add(codc);

        
        areaTexto3 = new JTextField();
        areaTexto3.setBounds(280, 254, 86, 20);
        Border bordeCodigo= BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTexto3.setBorder(bordeCodigo);
        areaTexto3.setFont(new Font("arial",Font.BOLD,12));
        miPanel.add(areaTexto3);
        areaTexto3.setColumns(10);
        
        JLabel ConsultaX= new JLabel("Nuestra Consulta: ");
        ConsultaX.setBounds(25, 300, 170, 15);
        ConsultaX.setFont(new Font("arial",Font.BOLD,13));
        ConsultaX.setForeground(Color.red);
        miPanel.add(ConsultaX);
      
        Consulta = new JButton("Consulta por id");
        Consulta.setBackground(new Color(0, 0, 0));
        Consulta.setBounds(200, 300, 177, 23);
        Consulta.setForeground(Color.WHITE);
        Border bordeConsulta= BorderFactory.createLineBorder(Color.WHITE, 2);
        Consulta.setBorder(bordeConsulta);
        Consulta.setMnemonic('2');
        miPanel.add(Consulta);
        
        // Etiqueta y campo de texto para el código a borrar
        codBorrar = new JLabel("Borrar Cliente: ");
        codBorrar.setBounds(25, 340, 300, 14);
        codBorrar.setFont(new Font("arial", Font.BOLD, 13));
        codBorrar.setForeground(Color.red);
        miPanel.add(codBorrar);

        areaTextoBorrar = new JTextField();
        areaTextoBorrar.setBounds(200, 334, 86, 20);
        Border bordeCodigoBorrar = BorderFactory.createLineBorder(Color.BLACK, 2);
        areaTextoBorrar.setBorder(bordeCodigoBorrar);
        areaTextoBorrar.setFont(new Font("arial", Font.BOLD, 12));
        miPanel.add(areaTextoBorrar);

        // Botón para borrar el campo
        Borrar = new JButton("Borrar campo");
        Borrar.setBackground(new Color(0, 0, 0));
        Borrar.setBounds(330, 334, 177, 23);
        Borrar.setForeground(Color.WHITE);
        Border bordeBorrar = BorderFactory.createLineBorder(Color.WHITE, 2);
        Borrar.setBorder(bordeBorrar);
        Borrar.setMnemonic('3');
        miPanel.add(Borrar);
        
        
        // Botón para modificar el campo
        Modificar = new JButton("Modificar campo");
        Modificar.setBackground(new Color(0, 0, 0));
        Modificar.setBounds(200, 390, 177, 23);
        Modificar.setForeground(Color.WHITE);
        Border bordeModificar = BorderFactory.createLineBorder(Color.WHITE, 2);
        Modificar.setBorder(bordeModificar);
        Modificar.setMnemonic('4');
        miPanel.add(Modificar);


    }

    private void iniciarEventos() {
        //EVENTOS CON EL BOTON "Admin"
            Admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Resultado.setText("");
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(cadena, user, pass);
                    Statement st = conn.createStatement();
                    //st.executeUpdate("ALTER TABLE ciclos ADD nombreCompleto VARCHAR(45)");
                    st.executeUpdate("INSERT INTO clientes(ID,DNI,NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO) VALUES ('" + areaTexto1.getText() + "', '"
                            + areaTexto2.getText() +"', '" + areaTexto4.getText() +  "', '" + areaTexto5.getText() +  "', '" + areaTexto6.getText()+ "')");
                    conn.close();
                    Resultado.setText("Datos registrados");
                    areaTexto1.setText("");
                    areaTexto2.setText("");
                    areaTexto4.setText("");
                    areaTexto5.setText("");
                    areaTexto6.setText("");
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Resultado.setText("Error al registrar los datos");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    Resultado.setText("No se encontró la clase");
                }
            }
        });
     // EVENTO CON EL BOTON "Borrar campo"
     Borrar.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent arg0) {
        Resultado.setText("");
        try {
            conn = DriverManager.getConnection(cadena, user, pass);
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate("DELETE FROM clientes WHERE ID = " + areaTextoBorrar.getText());

            if (rowsAffected > 0) {
                Resultado.setText("Campo borrado exitosamente");
                areaTextoBorrar.setText("");
                areaTexto1.setText("");
                areaTexto2.setText("");
                areaTexto4.setText("");
                areaTexto5.setText("");
                areaTexto6.setText("");
            } else {
                Resultado.setText("No se encontró ningún campo con ese código");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Resultado.setText("Error al borrar el campo");
        }
    }
});

            
         //EVENTOS CON EL BOTON "Consulta"

        Consulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Resultado.setText("");
                areaTexto1.setText("");
                areaTexto2.setText("");
                areaTexto4.setText("");
                areaTexto5.setText("");
                areaTexto6.setText("");
                try {
                    conn = DriverManager.getConnection(cadena, user, pass);
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT ID, NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO, DNI FROM clientes WHERE ID= "
                            + areaTexto3.getText());

                    if (rs.next()) {
                        areaTexto1.setText(rs.getString("ID"));
                        areaTexto2.setText(rs.getString("DNI"));
                        areaTexto4.setText(rs.getString("NOMBRE"));
                        areaTexto5.setText(rs.getString("APELLIDOPATERNO"));
                        areaTexto6.setText(rs.getString("APELLIDOMATERNO"));
                    } else {
                        Resultado.setText("Cliente Inexistente");
                    }
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Resultado.setText("Error en la consulta");
                }
            }
        });
        
        Modificar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Resultado.setText("");
        try {
            conn = DriverManager.getConnection(cadena, user, pass);
            Statement st = conn.createStatement();
            
            String idCliente = areaTexto1.getText();
            String nuevoDni = areaTexto2.getText();
            String nuevoNombre = areaTexto4.getText();
            String nuevoApellidoPaterno = areaTexto5.getText();
            String nuevoApellidoMaterno = areaTexto6.getText();

            // Construye la consulta SQL para actualizar los datos del cliente
            String consulta = "UPDATE clientes SET DNI = '" + nuevoDni + "', NOMBRE = '" + nuevoNombre
                    + "', APELLIDOPATERNO = '" + nuevoApellidoPaterno + "', APELLIDOMATERNO = '" + nuevoApellidoMaterno
                    + "' WHERE ID = " + idCliente;

            int rowsAffected = st.executeUpdate(consulta);

            if (rowsAffected > 0) {
                Resultado.setText("Datos modificados exitosamente");
            } else {
                Resultado.setText("No se encontró ningún cliente con ese ID");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Resultado.setText("Error al modificar los datos");
        }
    }
});

        
    }


}

