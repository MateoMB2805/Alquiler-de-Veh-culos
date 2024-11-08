package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{
    private double kilosCapacidad;

    public Camioneta(String placa, String marca, String modelo, double kilosCapacidad) {
        super(placa, marca, modelo);
        this.kilosCapacidad = kilosCapacidad;
    }

    public double getCapacidad() {
        return kilosCapacidad;
    }

    public void setCapacidad(double kilosCapacidad) {
        this.kilosCapacidad = kilosCapacidad;
    }

    @Override
    public double calcularReserva(Reserva reserva) {
        double tarifaBase = reserva.getTarifaBasePorDia() * reserva.getDias();
        double extraPorTonelada = (kilosCapacidad / 1000) * 0.10;
        return tarifaBase * (1 + extraPorTonelada);
    }
    
    

}
