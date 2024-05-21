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
     *
     * @param ataque Valor numérico insertado al llamar a la función que se corresponde con el ataque del jugador para
     *               asi restarle la defensa del monstruo y obtener el daño real realizado al monstruo.
     */
    public void recibirDanyo(int ataque) {
        ataque = ataque - defensa;
        if (ataque > 0){
            vida = vida - ataque;
        }
    }

    /**
     * Método sobreescrito para devolver la información de un monstruo
     *
     * @return Este método devuelve una cadena de caracteres que describe las características del monstruo
     * [Nombre del monstruo (Vida, Ataque, Defensa)]
     */
    @Override
    public String toString() {
        return "[ " + getNombre() + " (V: " + getVida() + ", A: " + getAtaque() + ", D: " + getDefensa() + ") ]";
    }

    /**
     * Método que sobreescribe el comportamiento de equals.
     *
     * @param obj Objeto introducido al llamar a la función para compararlo con otro objeto.
     * @return Este método devuelve un valor booleano. True en caso de ser igual, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        Monstruo monstruo = (Monstruo)obj;
        return monstruo.getAtaque() == getAtaque() && monstruo.getVida() == getVida() && monstruo.getDefensa() == getDefensa() && monstruo.getNombre().equals(getNombre());
    }
}
