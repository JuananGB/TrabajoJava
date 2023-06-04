
package Codigo;


public abstract class Vehiculos implements ICaracteristicas{
    
    //ATRIBUTOS PRINCIPALES
    protected String marca;
    protected String modelo;
    protected String agno;
    protected String color;
    protected String matricula;
    protected double kilometraje;
    protected double precio;
    protected int capacidadPasajeros;
    protected String tipoGasolina;
    protected String transmision;
    protected int nPuertas;
    protected String motor;
    protected String estado;
    
    //CONSTRUCTOR

    public Vehiculos(String marca, String modelo, String año, String color, String matricula, double kilometraje, double precio, int capacidadPasajeros, String tipoGasolina, String transmision, int nPuertas, String motor, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.agno = año;
        this.color = color;
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipoGasolina = tipoGasolina;
        this.transmision = transmision;
        this.nPuertas = nPuertas;
        this.motor = motor;
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAgno() {
        return agno;
    }

    public void setAgno(String agno) {
        this.agno = agno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getnPuertas() {
        return nPuertas;
    }

    public void setnPuertas(int nPuertas) {
        this.nPuertas = nPuertas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    //TOSTRING
   

    @Override
    public String toString() {
        return "Vehiculos{" + "marca=" + marca + ", modelo=" + modelo + ", agno=" + agno + ", color=" + color + ", matricula=" + matricula + ", kilometraje=" + kilometraje + ", precio=" + precio + ", capacidadPasajeros=" + capacidadPasajeros + ", tipoGasolina=" + tipoGasolina + ", transmision=" + transmision + ", nPuertas=" + nPuertas + ", motor=" + motor + ", estado=" + estado + '}';
    }

    
    @Override
    public String getVelocidadMaxima() {
        if (modelo.equals("Skyline GTR R34")) {
            return "250 km/h";
        } else if (modelo.equals("Mustang")) {
            return "250 km/h";
        } else if (modelo.equals("Supra")) {
            return "250 km/h";
        } else if (modelo.equals("Charger R/T")) {
            return "250 km/h";
        } else if (modelo.equals("Charger Daytona")) {
            return "250 km/h";
        } else {
            return "Velocidad máxima no disponible";
        }
    }

    @Override
    public String getAceleracion() {
        if (modelo.equals("Skyline GTR R34")) {
            return "0-100 km/h en aproximadamente 5 segundos";
        } else if (modelo.equals("Mustang")) {
            return "0-100 km/h en aproximadamente 4 segundos";
        } else if (modelo.equals("Supra")) {
            return "0-100 km/h en aproximadamente 4 segundos";
        } else if (modelo.equals("Charger R/T")) {
            return "0-100 km/h en aproximadamente 5 segundos";
        } else if (modelo.equals("Charger Daytona")) {
            return "0-100 km/h en aproximadamente 4.5 segundos";
        } else {
            return "Aceleración no disponible";
        }
    }

    @Override
    public String getFrenada() {
        if (modelo.equals("Skyline GTR R34")) {
            return "Sistema de frenos Brembo con discos ventilados";
        } else if (modelo.equals("Mustang")) {
            return "Sistema de frenos de alto rendimiento";
        } else if (modelo.equals("Supra")) {
            return "Sistema de frenos de alto rendimiento";
        } else if (modelo.equals("Charger R/T")) {
            return "Sistema de frenos de alto rendimiento";
        } else if (modelo.equals("Charger Daytona")) {
            return "Sistema de frenos de alto rendimiento";
        } else {
            return "Frenada no disponible";
        }
    }

    @Override
    public String getTraccion() {
        if (modelo.equals("Skyline GTR R34")) {
            return "Tracción integral en las cuatro ruedas (AWD)";
        } else if (modelo.equals("Mustang")) {
            return "Tracción trasera (RWD)";
        } else if (modelo.equals("Supra")) {
            return "Tracción trasera (RWD)";
        } else if (modelo.equals("Charger R/T")) {
            return "Tracción trasera (RWD)";
        } else if (modelo.equals("Charger Daytona")) {
            return "Tracción trasera (RWD)";
        } else {
            return "Tracción no disponible";
        }
    }
    
        
}
