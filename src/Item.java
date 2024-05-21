/**
 * Clase Item
 */
public class Item {
    private final double peso;
    private final double valor;
    private final String descripcion;

    /**
     * Constructor de la clase item
     *
     * @param descripcion Cadena de caracteres que tiene asignada cada objeto item que se crea y describe brevemente
     *                    nuestro objeto item.
     * @param peso        Valor numérico asignado a cada objeto item y que representa el peso de cada objeto item.
     * @param valor       Valor numérico asignado a cada objeto item y que representa el valor de cada objeto item, es decir,
     *                    la cantidad que obtendrá al vender dicho objeto cuando se de por finalizado el juego.
     */
    public Item(String descripcion, double peso, double valor) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.valor = valor;
    }

    /**
     * Método "getPeso"
     *
     * @return Este método nos devuelve el valor numérico asignado a cada objeto correspondiente al peso de cada
     * objeto item.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Método "getValor"
     *
     * @return Este método nos devuelve el valor numérico asignado a cada objeto correspondiente al valor de cada objeto item, es decir,
     * la cantidad que obtendrá al vender dicho objeto cuando se de por finalizado el juego.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método "getDescripcion"
     *
     * @return Este método nos devuelve la cadena de caracteres asignada a cada objeto y que describe el item.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método sobreescrito para devolver la información de un item.
     *
     * @return Este método devuelve una cadena de caracteres que devuelve la información del objeto item
     * Descripción (Peso, Valor) - Espada Mágica (Peso: 1,5, Valor: 100,0).
     */
    @Override
    public String toString() {
        return getDescripcion() + " (Peso: " + getPeso() + ", Valor: " + getValor() + ")";
    }

    /**
     * Método que sobreescribe el comportamiento de equals.
     *
     * @param obj Objeto introducido al llamar a la función para compararlo con otro objeto.
     * @return Este método devuelve un valor booleano. True en caso de ser igual, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        Item item = (Item)obj;
        return item.getDescripcion().equals(getDescripcion()) && item.getPeso() == getPeso() && item.getValor() == getValor();
    }
}
