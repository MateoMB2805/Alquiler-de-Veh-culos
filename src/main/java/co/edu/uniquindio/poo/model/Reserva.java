package co.edu.uniquindio.poo.model;

public class Reserva {
    private int dias;
    private double tarifaBasePorDia;
    private Cliente clienteReserva;
    private Vehiculo vehiculoReserva;

    public Reserva(int dias, double tarifaBasePorDia, Cliente clienteReserva, Vehiculo vehiculoReserva) {
        this.dias = dias;
        this.tarifaBasePorDia = tarifaBasePorDia;
        this.clienteReserva = clienteReserva;
        this.vehiculoReserva = vehiculoReserva;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Cliente getClienteReserva() {
        return clienteReserva;
    }

    public void setClienteReserva(Cliente clienteReserva) {
        this.clienteReserva = clienteReserva;
    }

    public Vehiculo getVehiculoReserva() {
        return vehiculoReserva;
    }

    public void setVehiculoReserva(Vehiculo vehiculoReserva) {
        this.vehiculoReserva = vehiculoReserva;
    }

    public double getTarifaBasePorDia() {
        return tarifaBasePorDia;
    }

    public void setTarifaBasePorDia(double tarifaBasePorDia) {
        this.tarifaBasePorDia = tarifaBasePorDia;
    }

    @Override
    public String toString() {
        return "Reserva [dias=" + dias + ", tarifaBasePorDia=" + tarifaBasePorDia + ", clienteReserva=" + clienteReserva
                + ", vehiculoReserva=" + vehiculoReserva + "]";
    }

    
    
    

}
