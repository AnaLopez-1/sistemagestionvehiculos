package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Consesionario;
import java.util.Collection;
import java.util.Collections;

public class VehiculoController {

    private Consesionario consesionario;

    // Constructor que inicializa el consesionario
    public VehiculoController(Consesionario consesionario) {
        this.consesionario = consesionario;
    }

    // Método para crear un vehículo
    public boolean crearVehiculo(Vehiculo vehiculo) {
        return consesionario.agregarVehiculo(vehiculo);
    }

    // Método para obtener la lista de vehículos
    public Collection<Vehiculo> obtenerListaVehiculos() {
        if (consesionario != null) { // Verifica si consesionario no es nulo
            return consesionario.getVehiculos(); // Llama al método getVehiculos() del consesionario
        } else {
            System.err.println("Error: El objeto consesionario no ha sido inicializado.");
            return Collections.emptyList(); // Devuelve una lista vacía en caso de error
        }
    }
    
    public boolean eliminarVehiculo(String numeroMatricula) {
       return consesionario.eliminarVehiculo(numeroMatricula);
    }

    public boolean actualizarVehiculo(String numeroMatricula, Vehiculo vehiculo) {
       return consesionario.actualizarVehiculo(numeroMatricula, vehiculo);
    }
}
