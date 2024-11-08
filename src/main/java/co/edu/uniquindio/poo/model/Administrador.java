package co.edu.uniquindio.poo.model;

public class Administrador {

    private String cedula;
    private String password;

    // Constructor
    public Administrador(String cedula, String password) {
        this.cedula = cedula;
        this.password = password;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

