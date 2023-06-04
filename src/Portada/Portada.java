package Portada;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import InterfazDeConcesionario.VentanaWeb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Portada {
    public static void main(String[] args) {
        Ventana miVentana = new Ventana();
        miVentana.setVisible(true);
    }
}

class Ventana extends JFrame {
    JPanel miPanel;
    JLabel miLabelPortada;
    JFrame ventanaRegistro;
    JPanel panelRegistro;
    JLabel etiquetaCodigoUsuario;
    JTextField campoCodigoUsuario;
    private String codigoUsuario;
    private String correo;
    private JTextField textoCorreo;
    JPasswordField contraseña;
    JFrame ventanaInicio;
    JPanel panelInicio;
    JLabel miLabelPortadaInicio;

    String url = "jdbc:mysql://localhost:3306/Concesionario";
    String usuario = "root";
    String contrasena = "link";

    public Ventana() {
        this.setBounds(200, 100, 500, 500);
        this.setTitle("LegendaryMotorSport");
        Toolkit miToolkit = Toolkit.getDefaultToolkit();
        Image image = miToolkit.getImage("src/Portada/logo.jpeg");
        ImageIcon miIcono = new ImageIcon(image);
        this.setIconImage(miIcono.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    // PANEL GENERAL

    public void iniciarComponentes() {
        cPaneles();
        cPortada();
        cBotonRegis();
        cBotonInis();
    }

    public void cPaneles() {
        miPanel = new JPanel();
        miPanel.setBackground(new Color(153, 153, 153));
        miPanel.setLayout(null);
        this.add(miPanel);
    }

    public void cPortada() {
        ImageIcon imagenPortada = new ImageIcon("src/Portada/miPortada.png");
        Image image = imagenPortada.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon imagenEscalada = new ImageIcon(image);
        miLabelPortada = new JLabel(imagenEscalada);
        miLabelPortada.setBounds(0, 0, 500, 300);
        miPanel.add(miLabelPortada);
    }

    public String generarCodigoUsuario() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int longitudCodigo = 6; // longitud deseada del código de usuario
        StringBuilder codigoUsuario = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < longitudCodigo; i++) {
            int indice = random.nextInt(caracteres.length());
            codigoUsuario.append(caracteres.charAt(indice));
        }

        return codigoUsuario.toString();
    }

    public void cBotonRegis() {
        JButton miBotonRegis = new JButton();
        miBotonRegis.setBounds(60, 350, 150, 40);
        miBotonRegis.setText("Registrarse");
        miBotonRegis.setMnemonic('a');
        miBotonRegis.setBackground(new Color(51, 51, 51));
        miBotonRegis.setForeground(Color.WHITE);
        miBotonRegis.setFont(new Font("Arial", Font.BOLD, 15));
        miPanel.add(miBotonRegis);

        miBotonRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro = new JFrame();
                ventanaRegistro.setBounds(300, 150, 300, 400);
                ventanaRegistro.setTitle("Registro");
                ventanaRegistro.setVisible(true);

                panelRegistro = new JPanel();
                panelRegistro.setBackground(new Color(153, 153, 153));
                panelRegistro.setLayout(null);
                ventanaRegistro.add(panelRegistro);

                etiquetaCodigoUsuario = new JLabel();
                etiquetaCodigoUsuario.setBounds(30, 30, 200, 30);
                etiquetaCodigoUsuario.setText("Código de Usuario:");
                etiquetaCodigoUsuario.setForeground(Color.WHITE);
                etiquetaCodigoUsuario.setFont(new Font("Arial", Font.BOLD, 12));
                panelRegistro.add(etiquetaCodigoUsuario);

                campoCodigoUsuario = new JTextField();
                campoCodigoUsuario.setBounds(30, 60, 200, 30);
                campoCodigoUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
                panelRegistro.add(campoCodigoUsuario);

                JLabel etiquetaCorreo = new JLabel();
                etiquetaCorreo.setBounds(30, 100, 200, 30);
                etiquetaCorreo.setText("Correo Electrónico:");
                etiquetaCorreo.setForeground(Color.WHITE);
                etiquetaCorreo.setFont(new Font("Arial", Font.BOLD, 12));
                panelRegistro.add(etiquetaCorreo);

                textoCorreo = new JTextField();
                textoCorreo.setBounds(30, 130, 200, 30);
                textoCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
                panelRegistro.add(textoCorreo);

                JLabel etiquetaContrasena = new JLabel();
                etiquetaContrasena.setBounds(30, 170, 200, 30);
                etiquetaContrasena.setText("Contraseña:");
                etiquetaContrasena.setForeground(Color.WHITE);
                etiquetaContrasena.setFont(new Font("Arial", Font.BOLD, 12));
                panelRegistro.add(etiquetaContrasena);

                contraseña = new JPasswordField();
                contraseña.setBounds(30, 200, 200, 30);
                contraseña.setFont(new Font("Arial", Font.PLAIN, 12));
                panelRegistro.add(contraseña);

                JButton botonRegistrar = new JButton();
                botonRegistrar.setBounds(60, 250, 150, 40);
                botonRegistrar.setText("Registrar");
                botonRegistrar.setMnemonic('a');
                botonRegistrar.setBackground(new Color(51, 51, 51));
                botonRegistrar.setForeground(Color.WHITE);
                botonRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
                panelRegistro.add(botonRegistrar);

                botonRegistrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         codigoUsuario = generarCodigoUsuario(); // Generar el código de usuario
                         correo = textoCorreo.getText();
                         String password = new String(contraseña.getPassword());

                        // Validar correo electrónico
                        if (!validarCorreo(correo)) {
                            JOptionPane.showMessageDialog(panelRegistro, "Correo electrónico no válido",
                                    "Error de Registro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Insertar los datos en la base de datos
                        Connection connection = null;
                        PreparedStatement statement = null;
                        try {
                            connection = DriverManager.getConnection(url, usuario, contrasena);
                            String query = "INSERT INTO usuarios (codigo_usuario, correo, password) VALUES (?, ?, ?)";
                            statement = connection.prepareStatement(query);
                            statement.setString(1, codigoUsuario);
                            statement.setString(2, correo);
                            statement.setString(3, password);
                            int filasInsertadas = statement.executeUpdate();
                            if (filasInsertadas > 0) {
                                JOptionPane.showMessageDialog(panelRegistro, "Registro exitoso",
                                        "Confirmación de Registro", JOptionPane.INFORMATION_MESSAGE);
                                ventanaRegistro.dispose();
                            } else {
                                JOptionPane.showMessageDialog(panelRegistro, "Error al registrar",
                                        "Error de Registro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                if (statement != null) {
                                    statement.close();
                                }
                                if (connection != null) {
                                    connection.close();
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    public void cBotonInis() {
        JButton miBotonInis = new JButton();
        miBotonInis.setBounds(300, 350, 150, 40);
        miBotonInis.setText("Iniciar sesión");
        miBotonInis.setMnemonic('a');
        miBotonInis.setBackground(new Color(51, 51, 51));
        miBotonInis.setForeground(Color.WHITE);
        miBotonInis.setFont(new Font("Arial", Font.BOLD, 15));
        miPanel.add(miBotonInis);

        miBotonInis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInicio = new JFrame();
                ventanaInicio.setBounds(300, 150, 300, 500);
                ventanaInicio.setTitle("Inicio de Sesión");
                ventanaInicio.setVisible(true);

                panelInicio = new JPanel();
                panelInicio.setBackground(new Color(153, 153, 153));
                panelInicio.setLayout(null);
                ventanaInicio.add(panelInicio);

                ImageIcon imagenPortadaInicio = new ImageIcon("src/Portada/logo.jpeg");
                Image image = imagenPortadaInicio.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
                ImageIcon imagenEscaladaInicio = new ImageIcon(image);
                miLabelPortadaInicio = new JLabel(imagenEscaladaInicio);
                miLabelPortadaInicio.setBounds(25, 30, 250, 200);
                panelInicio.add(miLabelPortadaInicio);

                JLabel etiquetaCodigoUsuarioInicio = new JLabel();
                etiquetaCodigoUsuarioInicio.setBounds(30, 250, 200, 30);
                etiquetaCodigoUsuarioInicio.setText("Código de Usuario:");
                etiquetaCodigoUsuarioInicio.setForeground(Color.WHITE);
                etiquetaCodigoUsuarioInicio.setFont(new Font("Arial", Font.BOLD, 12));
                panelInicio.add(etiquetaCodigoUsuarioInicio);

                JTextField campoCodigoUsuarioInicio = new JTextField();
                campoCodigoUsuarioInicio.setBounds(30, 280, 200, 30);
                campoCodigoUsuarioInicio.setFont(new Font("Arial", Font.PLAIN, 12));
                panelInicio.add(campoCodigoUsuarioInicio);

                JLabel etiquetaContrasenaInicio = new JLabel();
                etiquetaContrasenaInicio.setBounds(30, 320, 200, 30);
                etiquetaContrasenaInicio.setText("Contraseña:");
                etiquetaContrasenaInicio.setForeground(Color.WHITE);
                etiquetaContrasenaInicio.setFont(new Font("Arial", Font.BOLD, 12));
                panelInicio.add(etiquetaContrasenaInicio);

                JPasswordField contraseñaInicio = new JPasswordField();
                contraseñaInicio.setBounds(30, 350, 200, 30);
                contraseñaInicio.setFont(new Font("Arial", Font.PLAIN, 12));
                panelInicio.add(contraseñaInicio);

                JButton botonIniciar = new JButton();
                botonIniciar.setBounds(60, 400, 150, 40);
                botonIniciar.setText("Iniciar Sesión");
                botonIniciar.setMnemonic('a');
                botonIniciar.setBackground(new Color(51, 51, 51));
                botonIniciar.setForeground(Color.WHITE);
                botonIniciar.setFont(new Font("Arial", Font.BOLD, 15));
                panelInicio.add(botonIniciar);

                botonIniciar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigoUsuarioInicio = campoCodigoUsuarioInicio.getText();
                        String passwordInicio = new String(contraseñaInicio.getPassword());
                        System.out.println("Código de usuario generado: " + codigoUsuario);


                        // Verificar si el usuario existe en la base de datos
                        Connection connection = null;
                        PreparedStatement statement = null;
                        ResultSet resultSet = null;
                        try {
                            connection = DriverManager.getConnection(url, usuario, contrasena);
                            String query = "SELECT * FROM usuarios WHERE codigo_usuario = ? AND password = ?";
                            statement = connection.prepareStatement(query);
                            statement.setString(1, codigoUsuarioInicio);
                            statement.setString(2, passwordInicio);
                            resultSet = statement.executeQuery();

                            if (resultSet.next()) {
                                JOptionPane.showMessageDialog(panelInicio, "Inicio de sesión exitoso",
                                        "Confirmación de Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
                                ventanaInicio.dispose();
                                VentanaWeb miVentanaWeb = new VentanaWeb();
                                miVentanaWeb.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(panelInicio, "Código de usuario o contraseña incorrectos",
                                        "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                if (resultSet != null) {
                                    resultSet.close();
                                }
                                if (statement != null) {
                                    statement.close();
                                }
                                if (connection != null) {
                                    connection.close();
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    public boolean validarCorreo(String correo) {
        String expresionRegular = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
