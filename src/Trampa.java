/**
 * Clase Trampa
 */
public class Trampa {
    private final String descripcion;
    private final int danyo;

    /**
     * Constructor de la clase Trampa.
     *
     * @param descripcion Cadena de caracteres que tiene asignada cada objeto trampa que se crea y describe brevemente
     *                    nuestro objeto trampa.
     * @param danyo       Valor numérico correspondiente al valor, asignado a cada trampa, que resta a la vida del personaje
     *                    si caen en nuestro objeto trampa.
     */
    public Trampa(String descripcion, int danyo) {
        this.descripcion = descripcion;
        this.danyo = danyo;
    }

    /**
     * Método "getDescripcion".
     *
     * @return Este método nos devuelve la cadena de caracteres asignada a cada objeto y que describe la trampa.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método "getDanyo".
     *
     * @return Este método nos devuelve el valor numérico asignado a cada objeto correspondiente al valor
     * que resta a la vida del personaje si caen en nuestro objeto trampa.
     */
    public int getDanyo() {
        return danyo;
    }
}
