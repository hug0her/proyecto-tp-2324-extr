import java.util.Scanner;

/**
 * Clase Personaje
 */
public class Personaje {
    private final String nombre;
    private int vida, numItems;
    private final int ataque, defensa, destreza;
    private final Item[] items;

    private final double maxPesoPorPersonaje;

    /**
     * Constructor de la clase para inicializar todos los atributos
     *
     * @param nombre               Cadena de caracteres asignada a cada objeto "personaje" que representa el nombre del personaje.
     * @param vida                 Valor numérico asignado a cada "personaje" que indica sus puntos de vida.
     * @param ataque               Valor numérico asignado a cada "personaje" que indica sus puntos de ataque.
     * @param defensa              Valor numérico asignado a cada "personaje" que indica sus puntos de defensa.
     * @param destreza             Valor numérico asignado a cada "personaje" que indica sus puntos de destreza.
     * @param maxItemsPorPersonaje Valor numérico que representa el número máximo de items que puede llevar un objeto
     *                             "personaje" en su mochila.
     * @param maxPesoPorPersonaje  Valor numérico que representa el número máximo de items que puede llevar un objeto
     *                             "personaje" en su mochila.
     */
    public Personaje(String nombre, int vida, int ataque, int defensa, int destreza, int maxItemsPorPersonaje, double maxPesoPorPersonaje) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.destreza = destreza;
        items = new Item[maxItemsPorPersonaje];
        this.maxPesoPorPersonaje = maxPesoPorPersonaje;
    }

    /**
     * Metodo crearPersonaje que administra toda la generación de personajes
     *
     * @param teclado Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                inserte en la consola.
     * @return Este método devuelve el objeto personaje creado tras responder a las preguntas.
     */
    public static Personaje crearPersonaje(Scanner teclado) {
        String nombre;
        int vida, ataque, defensa, destreza;
        do {
            nombre = Utilidades.leerCadena(teclado, "¿Cómo te llamas?");
            System.out.println("¡Hola, " + nombre + "! Tienes 250 puntos para repartir entre vida, ataque, defensa y destreza.");
            vida = Utilidades.leerNumero(teclado, "¿Cuánta vida quieres tener? (50-247):", 50, 247);
            ataque = Utilidades.leerNumero(teclado, "¿Cuánto ataque quieres tener? (1-148):", 1, 148);
            defensa = Utilidades.leerNumero(teclado, "¿Cuánta defensa quieres tener? (1-49):", 1, 49);
            destreza = Utilidades.leerNumero(teclado, "¿Cuánta destreza quieres tener? (1-25):", 1, 25);
        }while (vida + destreza+ defensa + ataque > 250);
        int numItems = Math.max(destreza / 4, 1);
        double pesoMaximo = Math.max((double) ataque / 2, 1.0);
        return new Personaje(nombre, vida, ataque, defensa, destreza, numItems, pesoMaximo);
    }

    /**
     * Método "getNombre"
     *
     * @return Método que devuelve una cadena de caracteres que corresponde con el nombre asignado a cada objeto
     * "personaje".
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método "getVida"
     *
     * @return Método que devuelve un valor numérico que corresponde con la vida del objeto "personaje".
     */
    public int getVida() {
        return vida;
    }

    /**
     * Método "getAtaque"
     *
     * @return Método que devuelve un valor numérico que corresponde con el ataque del objeto "personaje".
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método "getDefensa"
     *
     * @return Método que devuelve un valor numérico que corresponde con la defensa del objeto "personaje".
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Método "getDestreza"
     *
     * @return Método que devuelve un valor numérico que corresponde con la destreza del objeto "personaje".
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Método "getItems"
     *
     * @return Este método devuelve la matriz de items que tiene almacenados, el personaje, en su mochila.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Método getItem para devolver un Item según un índice dado.
     *
     * @param indice Valor numérico insertado al llamar a la función y que indica la posición del objeto que se quiere
     *               obtener
     * @return Este método devuelve el objeto que se encuentra en el índice obtenido o null en caso de que el índice
     * no sea válido.
     */
    public Item getItem(int indice) {
        return items[indice];
    }

    /**
     * Método recibirDanyo para actualizar la vida de un personaje
     *
     * @param danyo Valor numérico insertado al llamar a la función que se corresponde con el ataque del monstruo para
     *              asi restarle la defensa del jugador y obtener el daño real realizado al jugador.
     */
    public void recibirDanyo(int danyo) {
        danyo = danyo - defensa;
        if (danyo > 0) {
            vida = vida - danyo;
        }
    }

    /**
     * Método anyadirItem para incluir un item en la mochila del personaje.
     *
     * @param item Objeto "item" que se inserta al llamar a la función y que se intenta recoger en caso de que no
     *             exceda el peso máximo o que no existan más huecos libres.
     * @return Este método devuelve un valor booleano siendo este true en caso de que se pueda insertar el item que se
     * intenta recoger y false en caso de que pese demasiado o no existan huecos libres.
     */
    public boolean anyadirItem(Item item) {
        boolean resultado = false;
        if (getPesoMochila() + item.getPeso() <= maxPesoPorPersonaje && numItems < items.length) {
            items[numItems] = item;
            numItems++;
            resultado = true;
            System.out.println("¡Te guardas el objeto! | " + item + " |");
        }else {
            System.out.println("No has podido recoger el item seleccionado");
        }
        return resultado;
    }

    /**
     * Método sobreescrito para devolver la información de un personaje
     *
     * @return Este método devuelve una cadena de caracteres que describe las características del personaje
     * [Nombre del personaje (Vida, Ataque, Defensa, Destreza)]
     */
    @Override
    public String toString() {
        return "[ " + getNombre() + " (V: " + getVida() + ", A: " + getAtaque() + ", D: " + getDefensa() + ", X: " + getDestreza() + ") ]";
    }

    /**
     * Método getPesoMochila para obtener el peso total que carga en la mochila el personaje
     *
     * @return Este método devuelve un valor numérico(double) que corresponde con el total de peso de todos los items
     * de la mochila.
     */
    public double getPesoMochila() {
        double resultado = 0.0;
        for (int i = 0; i < numItems; i++) {
            resultado += items[i].getPeso();
        }
        return resultado;
    }

    /**
     * Método getValorMochila para obtener el valor total que lleva entre todos los items el personaje.
     *
     * @return Este método devuelve un valor numérico(double) que corresponde con el total del valor de todos los items
     * de la mochila.
     */
    public double getValorMochila() {
        double resultado = 0.0;
        for (int i = 0; i < numItems; i++) {
            resultado += items[i].getValor();
        }
        return resultado;
    }

    /**
     * Método infoMochila para obtener en formato String la información de la mochila
     *
     * @return Este método devuelve una cadena de caracteres con toda la información de la mochila con el formato:
     * "Mochila de Edgar:
     * Espada Mágica Peso: 1.5, Valor: 100
     * Armadura de Gromril Peso: 4, Valor: 300
     * Peso total: 5.5 Kg
     * Tu mochila vale 400 monedas"
     */
    public String infoMochila() {
        return "Mochila de " + getNombre() + ": \n" + items + "\nPeso total: " + getPesoMochila() + " Kg" + "\nTu mochila vale " + getValorMochila() + " monedas";
    }
}
