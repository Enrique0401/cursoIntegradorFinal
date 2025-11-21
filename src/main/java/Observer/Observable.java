package Observer;

import java.util.List;

/**
 * Interfaz que define el comportamiento de un objeto observable. Permite
 * agregar, eliminar y notificar observadores.
 */
public interface Observable {

    /**
     * Agrega un observador a la lista.
     */
    void agregarObservador(Observador o);

    /**
     * Elimina un observador de la lista.
     */
    void eliminarObservador(Observador o);

    /**
     * Notifica a todos los observadores registrados.
     */
    void notificarObservadores();
}
