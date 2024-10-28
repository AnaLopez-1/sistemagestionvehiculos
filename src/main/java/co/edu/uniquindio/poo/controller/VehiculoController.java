package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Consesionario;
import java.util.Collection;

public class VehiculoController {

    private Consesionario consesionario;



    public VehiculoController(Consesionario consesionario) {
        this.consesionario = consesionario;
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        return consesionario.agregarVehiculo(vehiculo);
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return consesionario.getVehiculos();
    }

    public boolean eliminarVehiculo(String numeroMatricula) {
       return consesionario.eliminarVehiculo(numeroMatricula);
    }

    public boolean actualizarVehiculo(String numeroMatricula, Vehiculo vehiculo) {
       return consesionario.actualizarVehiculo(numeroMatricula, vehiculo);
    }
}
