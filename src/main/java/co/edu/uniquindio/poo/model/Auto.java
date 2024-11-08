package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo{
    private byte puertas;

    public Auto(String placa, String marca, String modelo, byte puertas) {
        super(placa, marca, modelo);
        this.puertas = puertas;
    }

    public byte getPuertas() {
        return puertas;
    }

    public void setPuertas(byte puertas) {
        this.puertas = puertas;
    }
    
    @Override
    public double calcularReserva(Reserva reserva) {
        double total = reserva.getTarifaBasePorDia()*reserva.getDias();
        return total;
    }

    

}
