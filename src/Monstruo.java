/**
 * Clase Monstruo
 */
public class Monstruo {
    private int vida;
    private final int ataque;
    private final int defensa;
    private final String nombre;

    /**
     * Constructor clase Monstruo
     *
     * @param nombre  Cadena de caracteres asignada a cada objeto "monstruo" que representa el nombre del monstruo.
     * @param vida    Valor numérico asignado a cada "monstruo" que indica sus puntos de vida.
     * @param ataque  Valor numérico asignado a cada "monstruo" que indica sus puntos de ataque.
     * @param defensa Valor numérico asignado a cada "monstruo" que indica sus puntos de defensa.
     */
    public Monstruo(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    /**
     * Método "getVida"
     *
     * @return Este método devuelve el valor numérico correspondiente a cada objeto "monstruo" que indica
     * los puntos de vida del monstruo.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Método "getAtaque"
     *
     * @return Este método devuelve el valor numérico correspondiente a cada objeto "monstruo" que indica
     * los puntos de ataque del monstruo.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método "getDefensa"
     *
     * @return Este método devuelve el valor numérico correspondiente a cada objeto "monstruo" que indica
     * los puntos de defensa del monstruo.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Método "getNombre"
     *
     * @return Este método devuelve una cadena de caracteres correspondiente a cada objeto "monstruo" que representa
     * el nombre de cada monstruo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método recibirDanyo para calcular la vida restante
     * TODO actualizar la vida restante del monstruo despues de un ataque, siempre que el
     * valor de ataque sea positivo
     *
     * @param ataque
     */
    public void recibirDanyo(int ataque) {

    }

    /**
     * Método sobreescrito para devolver la información de un monstruo
     *
     * @return Este método devuelve una cadena de caracteres que describe la información del monstruo
     * [Nombre del monstruo (Vida, Ataque, Destreza)]
     */
    @Override
    public String toString() {
        return "[ " + getNombre() + " (V: " + getVida() + ", A: " + getAtaque() + ", D: " + getDefensa() + ") ]";
    }

    /**
     * Método que sobreescribe el comportamiento de equals
     *  TODO Método para comparar si el objeto pasado como parámetro es igual a este,
     *      hay que comparar los parámetros internos del objeto (nombre, vida, ataque, defensa)
     *
     * @param obj
     * @return True en caso de ser igual, false en otro caso
     */
    @Override
    public boolean equals(Object obj) {

        return
    }
}
