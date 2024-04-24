import java.util.Scanner;

/**
 * Clase Sala
 */
public class Sala {
    private final String descripcion;
    private final Item[] items;
    private final Monstruo[] monstruos;
    private final Trampa[] trampas;
    private final int fila;
    private final int columna;
    private int numItems, numMonstruos, numTrampas;

    /**
     * Constructor de clase para inicializar los atributos de clase.
     *
     * @param descripcion       Cadena de caracteres que tiene asignada cada objeto sala que se crea y describe brevemente
     *                          nuestro objeto.
     * @param max_items         Valor numérico que indica el número máximo de items que pueden existir por sala y condiciona
     *                          la capacidad del vector que contiene todos los items en cada sala.
     * @param max_monstruos     Valor numérico que indica el número máximo de monstruos que pueden existir por sala y
     *                          condiciona la capacidad del vector que contiene todos los monstruos en cada sala.
     * @param maxTrampasPorSala Valor numérico que indica el número máximo de trampas que pueden existir por sala
     *                          y condiciona la capacidad del vector que contiene todas las trampas en cada sala.
     * @param fila              Valor numérico que indica la fila de la matriz en la que se encuentra con respecto a la matriz
     *                          que recoge todos los objetos "sala" creados anteriormente.
     * @param columna           Valor numérico que indica la columna de la matriz en la que se encuentra con respecto a la
     *                          matriz que recoge todos los objetos "sala" creados anteriormente.
     */
    public Sala(String descripcion, int max_items, int max_monstruos, int maxTrampasPorSala, int fila, int columna) {
        this.descripcion = descripcion;
        items = new Item[max_items];
        monstruos = new Monstruo[max_monstruos];
        trampas = new Trampa[maxTrampasPorSala];
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Método agregarItem para incluir items en la sala.
     *
     * @param item Objeto "Item" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *             no se repita y no exceda la capacidad máxima del vector "items".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * item insertado cuando se llama a esta función.
     */
    public boolean agregarItem(Item item) {
        boolean resultado = true;
        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                resultado = false;
            }
        }
        if (resultado) {
            items[numItems] = item;
            numItems++;
        }
        return resultado;
    }

    /**
     * Método agregarMonstruo para incluir un monstruo en la sala.
     *
     * @param monstruo Objeto "Monstruo" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *                 no se repita y no exceda la capacidad máxima del vector "monstruos".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * monstruo insertado cuando se llama a esta función.
     */
    public boolean agregarMonstruo(Monstruo monstruo) {
        boolean resultado = true;
        for (int i = 0; i < numMonstruos; i++) {
            if (monstruos[i] == monstruo) {
                resultado = false;
            }
        }
        if (resultado) {
            monstruos[numMonstruos] = monstruo;
            numMonstruos++;
        }
        return resultado;
    }

    /**
     * Método agregarTrampa para incluir una trampa en la sala.
     *
     * @param trampa Objeto "Trampa" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *               no se repita y no exceda la capacidad máxima del vector "trampas".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * trampa insertado cuando se llama a esta función.
     */
    public boolean agregarTrampa(Trampa trampa) {
        boolean resultado = true;
        for (int i = 0; i < numTrampas; i++) {
            if (trampas[i] == trampa) {
                resultado = false;
            }
        }
        if (resultado) {
            trampas[numTrampas] = trampa;
            numTrampas++;
        }
        return resultado;
    }

    /**
     * Método "getDescripcion".
     *
     * @return Este método devuelve una cadena de caracteres que corresponde al que tiene asignada cada objeto sala que se crea y describe brevemente
     * nuestro objeto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método hayMonstruos para comprobar si hay algún monstruo en la sala.
     *
     * @return Este método devuelve un valor booleano que corresponde con un valor true en caso de que haya monstruos
     * y false en caso de que no los haya.
     */
    public boolean hayMonstruos() {
        return numMonstruos > 0;
    }

    /**
     * Método seleccionarMonstruo para introducir desde pantalla el nombre de un monstruo.
     *
     * @param teclado Objeto de tipo "Scanner" que lee lo que el usuario escriba en la consola en este caso el
     *                monstruo seleccionado
     * @return Este método devuelve el monstruo que ha sido seleccionado por el usuario tras imprimir todos por pantalla.
     */
    public Monstruo seleccionarMonstruo(Scanner teclado) {
        listarMonstruos();
        return buscarMonstruo(Utilidades.leerCadena(teclado, "Escribe el nombre del monstruo que quieres atacar: "));
    }

    /**
     * Método buscarMonstruo para buscar un monstruo dado el nombre del mismo.
     *
     * @param nombreMonstruo Cadena de caracteres introducida al llamar a la función y que tiene que corresponder con
     *                       el nombre del monstruo que va a devolver el método.
     * @return Este método devuelve el objeto "monstruo" que coincida con la cadena de caracteres introducida
     * al llamar a la función. En caso de que no se encuentre ningún objeto "monstruo" que cumpla la característica
     * el método devolverá "null".
     */
    public Monstruo buscarMonstruo(String nombreMonstruo) {
        Monstruo resultado = null;
        for (int i = 0; i < numMonstruos; i++) {
            if (monstruos[i].getNombre().equals(nombreMonstruo)) {
                resultado = monstruos[i];
            }
        }
        return resultado;
    }

    /**
     * Método "listarMonstruos" para mostrar por pantalla la información de los monstruos.
     */
    private void listarMonstruos() {
        for (int i = 0; i < numMonstruos; i++) {
            monstruos[i].toString();
        }
    }

    /**
     * Método "eliminarMonstruo" para eliminar un monstruo de la lista segun un nombre dado
     * TODO buscar en la lista el monstruo según el nombre pasado como parámetro y eliminarlo.
     *
     * @param nombreMonstruo Cadena de caracteres insertada al llamar a la función y que tiene que coincidir con la
     *                       descripción del objeto que le va a eliminar.
     */
    public void eliminarMonstruo(String nombreMonstruo) {
        if (buscarMonstruo(nombreMonstruo) != null){
            for (int i = 0; ; i++)
        }
    }

    /**
     * Método "hayTrampas" para saber si la sala dispone de alguna trampa.
     *
     * @return Este método devuelve un valor booleano que corresponde con un valor true en caso de que haya trampas
     * y false en caso de que no las haya.
     */
    public boolean hayTrampas() {
        return numTrampas > 0;
    }

    /**
     * Método getFila
     *
     * @return Este método devuelve un valor numérico que corresponde con la fila de la matriz en la que se encuentra
     * con respecto a la matriz que recoge todos los objetos "sala" creados anteriormente.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Método getColumna
     *
     * @return Este método devuelve un valor numérico que corresponde con la columna de la matriz en la que se
     * encuentra con respecto a la matriz que recoge todos los objetos "sala" creados anteriormente.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Método hayItems para mostrar si existe algún item en la sala.
     *
     * @return Este método nos devuelve un valor booleano dependiendo de si hay ("true") o no ("false") valores
     * en la matriz que guarda los objetos "item" de cada sala.
     */
    public boolean hayItems() {
        return items.length > 0;
    }

    /**
     * Método buscarItem para obtener un item según una descripción dada.
     *
     * @param descripcion Cadena de caracteres introducida al llamar a la función y que tiene que corresponder con
     *                    la descripción del item que va a devolver el método.
     * @return Este método devuelve el objeto "item" que coincida con la cadena de caracteres introducida
     * al llamar a la función. En caso de que no se encuentre ningún objeto "item" que cumpla la característica
     * el método devolverá "null".
     */
    public Item buscarItem(String descripcion) {
        Item resultado = null;
        for (int i = 0; i < numItems; i++) {
            if (items[i].getDescripcion().equals(descripcion)) {
                resultado = items[i];
            }
        }
        return resultado;
    }

    /**
     * Método buscarTrampa para obtener una trampa según una descripción dada.
     *
     * @param descripcion Cadena de caracteres introducida al llamar a la función y que tiene que corresponder con
     *                    la descripción de la trampa que va a devolver el método.
     * @return Este método devuelve el objeto "trampa" que coincida con la cadena de caracteres introducida
     * al llamar a la función. En caso de que no se encuentre ningún objeto "trampa" que cumpla la característica
     * el método devolverá "null".
     */
    public Trampa buscarTrampa(String descripcion) {
        Trampa resultado = null;
        for (int i = 0; i < numTrampas; i++) {
            if (trampas[i].getDescripcion().equals(descripcion)) {
                resultado = trampas[i];
            }
        }
        return resultado;
    }

    /**
     * Método getTrampas
     *
     * @return Este método devuelve un array de objetos "trampas" en el que se encuentran todas las trampas de la sala.
     */
    public Trampa[] getTrampas() {
        return trampas;
    }

    /**
     * Método seleccionarItem para obtener un item concreto con parámetro pasados por pantalla.
     *
     * @param teclado Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                inserte en la consola.
     * @return Este método imprime por pantalla todos los items que pertenecen al array que los contiene y después
     * devuelve el item que coincida con el nombre que el usuario escriba en la consola.
     */
    public Item seleccionarItem(Scanner teclado) { //REVISAR
        Item resultado = null;
        listarItems();
        do {
            resultado = buscarItem(Utilidades.leerCadena(teclado, "Escribe la descripción del item que quieres coger (NINGUNO  para cancelar):"));
        } while(resultado == null);
        return resultado;
    }

    /**
     * Método listarItems para mostrar por pantalla todos los items.
     */
    private void listarItems() {
        for (int i = 0; i < numItems; i++) {
            items[i].toString();
        }
    }

    /**
     * Método eliminarItem para eliminar un item con la descripcion pasada como parámetro
     * TODO buscar el item que coincida con la descripción pasada por parámetro y eliminarlo de la lista de items
     *
     * @param descripcion Cadena de caracteres que se inserta al llamar a la función y que sirve para saber que "item"
     *                    eliminar.
     */
    public void eliminarItem(String descripcion) {

    }
}
