package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo{

    private int numeroPuertas;
    private static final double TARIFA_BASE = 50.0; // Tarifa base por día

    public Auto(String numeroMatricula, String marca, String modelo, String añoFabricacion, int numeroPuertas) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.numeroPuertas = numeroPuertas;
    }
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public static double getTarifaBase() {
        return TARIFA_BASE;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        return TARIFA_BASE * dias;
    }
}
