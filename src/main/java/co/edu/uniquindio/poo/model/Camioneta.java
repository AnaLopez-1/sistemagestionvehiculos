package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {

    private double capacidadCarga; // en toneladas
    private static final double TARIFA_BASE = 70.0; // Tarifa base por día
    private static final double PORCENTAJE_EXTRA_POR_TONELADA = 15.0; // Porcentaje extra por tonelada

    public Camioneta(String numeroMatricula, String marca, String modelo, String añoFabricacion, double capacidadCarga) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        return (TARIFA_BASE * dias) + (capacidadCarga * PORCENTAJE_EXTRA_POR_TONELADA);
    }
}
