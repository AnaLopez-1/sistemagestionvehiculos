package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo{

    private boolean cajaAutomatica;
    private static final double TARIFA_BASE = 30.0; // Tarifa base por día
    private static final double TARIFA_ADICIONAL_AUTOMATICA = 10.0; // Tarifa adicional por caja automática

    public Moto(String numeroMatricula, String marca, String modelo, String añoFabricacion, boolean cajaAutomatica) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.cajaAutomatica = cajaAutomatica;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        double costo = TARIFA_BASE * dias;
        if (cajaAutomatica) {
            costo += TARIFA_ADICIONAL_AUTOMATICA;
        }
        return costo;
    }
}
