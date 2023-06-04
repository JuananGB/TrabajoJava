
package ConexionCoche.Caracteristicas;

import Codigo.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import ConexionCoche.CopiaSeguridad.CopiaSeguridadChargerRT;

public class VentanaChargerRT extends JFrame {

    JPanel panel;
    JLabel portadaDodgeRT;
    JLabel velocidadLabel;
    JLabel aceleracionLabel;
    JLabel frenadaLabel;
    JLabel traccionLabel;
    JButton btnComprar;
    private Coche coche;
    private int idCliente;


    private static final String URL = "jdbc:mysql://localhost:3306/Concesionario";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "link";

    
    public VentanaChargerRT(Coche coche) {
    this.setBounds(180, 50, 1000, 800);
    this.setTitle("Dodge Charger RT");
    Toolkit miToolkitDodgeRT = Toolkit.getDefaultToolkit();
    Image image = miToolkitDodgeRT.getImage("src/Portada/logo.jpeg");
    ImageIcon miIcono = new ImageIcon(image);
    this.setIconImage(miIcono.getImage());
    this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // Oculta la ventana en lugar de cerrarla
            setVisible(false);
        }
    });
    this.coche = coche; // Asignar el objeto coche recibido al atributo de la clase
    iniciarComponentes();
}

    public void iniciarComponentes() {
    // Diálogo de entrada para obtener el ID del cliente
    String idInput = JOptionPane.showInputDialog(null, "Ingrese tu ID:");
    idCliente = Integer.parseInt(idInput);

    // Verificar si el ID del cliente está registrado en la tabla clientes
    boolean clienteRegistrado = verificarClienteRegistrado(idCliente);

    if (clienteRegistrado) {
        cPaneles();
        cPortadaDodgeRT();
        cCaracteristicas(coche);
        cEtiquetaCaracteristicas();
        cBotonComprar();
        cEtiquetaPrecio();
        JOptionPane.showMessageDialog(null, "Bienvenido, gracias por ver nuestro catálogo de coches");

    } else {
        JOptionPane.showMessageDialog(null, "ID de cliente no registrado en la base de datos");
        // Cerrar la ventana o realizar alguna acción adicional si el cliente no está registrado
        this.dispose(); // Cierra la ventana actual
    }
}

    
    
    private boolean verificarClienteRegistrado(int idCliente) {
    boolean clienteRegistrado = false;

    try {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String query = "SELECT COUNT(*) FROM clientes WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idCliente);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            clienteRegistrado = count > 0;
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return clienteRegistrado;
}

    

    public void cPaneles() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        this.add(panel);
    }

    public void cPortadaDodgeRT() {
        ImageIcon imagenPortada = new ImageIcon("src/ConexionCoche/Caracteristicas/dodgeRT.jpg");
        Image image = imagenPortada.getImage().getScaledInstance(800, 531, Image.SCALE_SMOOTH);
        ImageIcon imagenEscalada = new ImageIcon(image);
        portadaDodgeRT = new JLabel(imagenEscalada);
        portadaDodgeRT.setBounds(-30, 0, 900, 410);
        panel.add(portadaDodgeRT);
    }

    public void cCaracteristicas(Coche coche) {
        velocidadLabel = new JLabel("Velocidad máxima: " + coche.getVelocidadMaxima());
        velocidadLabel.setBounds(10, 430, 500, 50);
        velocidadLabel.setForeground(Color.WHITE);
        panel.add(velocidadLabel);

        aceleracionLabel = new JLabel("Aceleración: " + coche.getAceleracion());
        aceleracionLabel.setBounds(10, 460, 500, 50);
        aceleracionLabel.setForeground(Color.WHITE);
        panel.add(aceleracionLabel);

        frenadaLabel = new JLabel("Frenada: " + coche.getFrenada());
        frenadaLabel.setBounds(10, 490, 500, 50);
        frenadaLabel.setForeground(Color.WHITE);
        panel.add(frenadaLabel);

        traccionLabel = new JLabel("Tracción: " + coche.getTraccion());
        traccionLabel.setBounds(10, 520, 500, 50);
        traccionLabel.setForeground(Color.WHITE);
        panel.add(traccionLabel);
    }
    
   public void cEtiquetaPrecio() {
    JLabel precioLabel = new JLabel("Precio: " + coche.getPrecio()+"$");
    precioLabel.setBounds(600, 530, 500, 50);
    precioLabel.setForeground(Color.YELLOW);
    precioLabel.setFont(new Font("Showcard Gothic",4,22));
    panel.add(precioLabel);
}

    public void cEtiquetaCaracteristicas() {
        JLabel etiquetaC = new JLabel();
        etiquetaC.setBounds(10, 410, 200, 50);
        etiquetaC.setText("CARACTERISTICAS");
        etiquetaC.setForeground(Color.RED);
        etiquetaC.setFont(new Font("Showcard Gothic", 4, 14));
        panel.add(etiquetaC);
    }

    public void cBotonComprar() {
        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(600, 450, 180, 50);
        btnComprar.setForeground(Color.BLACK);
        btnComprar.setFont(new Font("Showcard Gothic", 4, 24));
        btnComprar.setBackground(new Color(255, 0, 0));
        panel.add(btnComprar);

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realizar la inserción en la base de datos
                insertarCocheEnBD(idCliente, coche);
            }
        });
    }

    private void insertarCocheEnBD(int idCliente, Coche coche) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "INSERT INTO coches (id, marca, modelo, agno, color, matricula, kilometraje, precio, capacidadPasajeros, tipoGasolina, transmision, nPuertas, motor, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idCliente);
            statement.setString(2, coche.getMarca());
            statement.setString(3, coche.getModelo());
            statement.setString(4, coche.getAgno());
            statement.setString(5, coche.getColor());
            statement.setString(6, coche.getMatricula());
            statement.setDouble(7, coche.getKilometraje());
            statement.setDouble(8, coche.getPrecio());
            statement.setInt(9, coche.getCapacidadPasajeros());
            statement.setString(10, coche.getTipoGasolina());
            statement.setString(11, coche.getTransmision());
            statement.setInt(12, coche.getnPuertas());
            statement.setString(13, coche.getMotor());
            statement.setString(14, coche.getEstado());

            int rowsAffected = statement.executeUpdate();


            if (rowsAffected > 0) {
                CopiaSeguridadChargerRT.guardarDatosEnArchivo(idCliente, coche.getMarca(), coche.getModelo(), coche.getAgno(), coche.getColor(), coche.getMatricula(), coche.getKilometraje(), coche.getPrecio(), coche.getCapacidadPasajeros(), coche.getTipoGasolina(), coche.getTransmision(), coche.getnPuertas(), coche.getMotor(), coche.getEstado());

                JOptionPane.showMessageDialog(null, "¡Vehículo comprado y registrado en la base de datos!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al realizar la inserción en la base de datos");
            }

            // Cerrar la conexión y el statement
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


