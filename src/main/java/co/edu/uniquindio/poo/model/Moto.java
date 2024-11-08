package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo{

    private TipoCaja transmision;

    public Moto(String placa, String marca, String modelo, TipoCaja transmision){
        super(placa, marca, modelo);
        this.transmision = transmision;
    }

    public TipoCaja getTransmision() {
        return transmision;
    }

    public void setTransmision(TipoCaja transmision) {
        this.transmision = transmision;
    }

    @Override
    public double calcularReserva(Reserva reserva) {
        double tarifaAdicional = 0;

        switch (transmision) {
            case AUTOMATICA:
                tarifaAdicional = 2000;
                break;
            case MANUAL:
                tarifaAdicional = 0;
                break;
        }

        double total = (reserva.getTarifaBasePorDia()+tarifaAdicional)*reserva.getDias();
        return total;
    }
    

    
}
