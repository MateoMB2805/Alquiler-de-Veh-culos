package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String cedula;
    private Collection<Reserva> listaReservasCliente = new LinkedList<>();

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Collection<Reserva> getListaReservasCliente() {
        return listaReservasCliente;
    }


    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + "]";
    }

    
}
