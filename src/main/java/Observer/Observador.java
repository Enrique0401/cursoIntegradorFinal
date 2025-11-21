package Observer;

/**
 * Interfaz para los objetos que desean ser notificados cuando ocurre un cambio
 * en el Observable.
 */
public interface Observador {

    /**
     * Método que se ejecuta cuando el observable notifica un cambio.
     */
    void actualizar();
}
