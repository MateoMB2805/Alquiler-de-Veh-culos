package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Empresa {
    private String nombre;
    private Collection<Vehiculo> listaVehiculos = new LinkedList<>();
    private Collection<Cliente> listaClientes = new LinkedList<>();
    private Collection<Reserva> listaReservas = new LinkedList<>();
    private static Empresa instancia;
    private List<Administrador> administradores;

    //═════════════════════════════════ <<< CRUD VEHICULO >>> ═════════════════════════════════

    public String crearVehiculo(Vehiculo NuevoVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(NuevoVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            listaVehiculos.add(NuevoVehiculo);
            mensaje = "El vehículo ha sido añadido exitosamente";
        } else {
            mensaje = "El vehículo ya existe";
        }
        return mensaje;
    }

    private Vehiculo buscarVehiculoPorPlaca(String Placa){
        return listaVehiculos.stream().filter(vehiculo->vehiculo.getPlaca().equals(Placa)).findAny().orElse(null);
    }

    public String eliminarVehiculo(Vehiculo RemoverVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(RemoverVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaVehiculos.remove(vehiculoEncontrado);
            mensaje= "Vehículo eliminado exitosamente";
        }
        return mensaje;
    }

    public String actualizarVehiculo(Vehiculo ActualizarVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(ActualizarVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaVehiculos.remove(vehiculoEncontrado);
            listaVehiculos.add(ActualizarVehiculo);
            mensaje= "Vehículo actualizar exitosamente";
        }
        return mensaje;
    }
    
    //═════════════════════════════════ <<< CRUD CLIENTE >>> ═════════════════════════════════

    public String crearCliente(Cliente NuevoCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorCedula(NuevoCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            listaClientes.add(NuevoCliente);
            mensaje = "El cliente ha sido añadido exitosamente";
        } else {
            mensaje = "El cliente ya existe";
        }
        return mensaje;
    }
    
    public Cliente buscarClientePorCedula(String Cedula){
        return listaClientes.stream().filter(Cliente->Cliente.getCedula().equals(Cedula)).findAny().orElse(null);
    }
    
    public String eliminarCliente(Cliente RemoverCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorCedula(RemoverCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            mensaje="El cliente no existe";
        } else {
            listaClientes.remove(ClienteEncontrado);
            mensaje= "El Cliente ha sido eliminado exitosamente";
        }
        return mensaje;
    }
    
    public String actualizarCliente(Cliente ActualizarCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorCedula(ActualizarCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            mensaje="El cliente no existe";
        } else {
            listaClientes.remove(ClienteEncontrado);
            listaClientes.add(ActualizarCliente);
            mensaje= "Cliente actualizado exitosamente";
        }
        return mensaje;
    }

    //═════════════════════════════════ <<< CRUD RESERVA >>> ═════════════════════════════════

        
    public String crearReserva(Reserva NuevaReserva){
        String mensaje="";
        Reserva ReservaEncontrado = buscarReserva(NuevaReserva);

        if (ReservaEncontrado==null) {
            listaReservas.add(NuevaReserva);
            mensaje = "La reserva ha sido añadida exitosamente";
        } else {
            mensaje = "La reserva ya existe";
        }
        return mensaje;
    }

    public Reserva buscarReserva(Reserva BuscarReserva){
        return listaReservas.stream().filter(Reserva -> Reserva.equals(BuscarReserva)).findAny().orElse(null);
}
    

    public String eliminarReserva(Reserva RemoverReserva){
        String mensaje="";
        Reserva ReservaEncontrado = buscarReserva(RemoverReserva);

        if (ReservaEncontrado==null) {
            mensaje="La reserva no existe";
        } else {
            listaReservas.remove(ReservaEncontrado);
            mensaje= "Reserva eliminada exitosamente";
        }
        return mensaje;
    }

    public String actualizarReserva(Reserva ActualizarReserva){
        String mensaje="";
        Reserva ReservaEncontrado = buscarReserva(ActualizarReserva);

        if (ReservaEncontrado==null) {
            mensaje="La reserva no existe";
        } else {
            listaReservas.remove(ReservaEncontrado);
            listaReservas.add(ActualizarReserva);
            mensaje= "Reserva actualizada exitosamente";
        }
        return mensaje;
    }

    //═════════════════════════════════ <<< Getters and Setters >>> ═════════════════════════════════

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }

    public Collection<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

//═════════════════════════════════ <<< Método para el manejo de los administradores de la empresa >>> ═════════════════════════════════
    // Constructor privado para implementar Singleton
    private Empresa() {
        administradores = new ArrayList<>();
        cargarAdministradoresPredeterminados();
    }

    // Método para obtener la única instancia de Empresa
    public static Empresa getInstance() {
        if (instancia == null) {
            instancia = new Empresa();
        }
        return instancia;
    }

    // Método para cargar administradores predeterminados
    private void cargarAdministradoresPredeterminados() {
        administradores.add(new Administrador("1094905509", "password123"));  // Administrador Mateo
        administradores.add(new Administrador("987654321", "admin2024"));    // Otro administrador
    }

    // Método para validar un administrador por cédula y contraseña
    public boolean validarAdministrador(String cedula, String password) {
        for (Administrador admin : administradores) {
            if (admin.getCedula().equals(cedula) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Método para agregar un nuevo administrador (opcional)
    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

}
