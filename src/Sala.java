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

    /**
     * Constructor de clase para inicializar los atributos de clase
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
     * Método agregarItem para incluir items en la sala
     *
     * @param item Objeto "Item" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *             no se repita y no exceda la capacidad máxima del vector "items".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * item insertado cuando se llama a esta función.
     */
    public boolean agregarItem(Item item) {
        boolean resultado = true;
        if (hayItems()) {
            int j = 0;
            boolean primero = true;
            for (int i = 0; i < items.length; i++) {
                if (items[i] == item) {
                    resultado = false;
                } else if (items[i] == null && primero) {
                    primero = false;
                    j = i;
                }
            }
            if (resultado) {
                items[j] = item;
            }
        } else {
            items[0] = item;
        }
        return resultado;
    }

    /**
     * Método agregarMonstruo para incluir un monstruo en la sala
     * TODO comprobar si existe el monstruo en la sala o si la lista de monstruos no está ya llena en caso afirmativo
     *  devolver false. En caso de no existir incluirlo en la lista y devolver true
     *
     * @param monstruo Objeto "Monstruo" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *                 no se repita y no exceda la capacidad máxima del vector "monstruos".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * monstruo insertado cuando se llama a esta función.
     */
    public boolean agregarMonstruo(Monstruo monstruo) {
        boolean resultado = true;
        if (hayMonstruos()) {
            int j = 0;
            boolean primero = true;
            for (int i = 0; i < monstruos.length; i++) {
                if (monstruos[i] == monstruo) {
                    resultado = false;
                } else if (monstruos[i] == null && primero) {
                    primero = false;
                    j = i;
                }
            }
            if (resultado) {
                monstruos[j] = monstruo;
            }
        } else {
            monstruos[0] = monstruo;
        }
        return resultado;
    }

    /**
     * Método agregarTrampa para incluir una trampa en la sala
     * TODO comprobar si existe la trampa en la sala o si la lista de trampas no está ya llena en caso afirmativo
     *  devolver false. En caso de no existir incluirlo en la lista y devolver true
     *
     * @param trampa Objeto "Trampa" que se especifica al llamar a la función y que se intentara insertar en caso de que
     *               no se repita y no exceda la capacidad máxima del vector "trampas".
     * @return Este método nos devuelve un valor booleano que depende si ha podido (true) o no (false) insertar el
     * trampa insertado cuando se llama a esta función.
     */
    public boolean agregarTrampa(Trampa trampa) {
        boolean resultado = true;
        if (hayTrampas()) {
            int j = 0;
            boolean primero = true;
            for (int i = 0; i < trampas.length; i++) {
                if (trampas[i] == trampa) {
                    resultado = false;
                } else if (trampas[i] == null && primero) {
                    primero = false;
                    j = i;
                }
            }
            if (resultado) {
                trampas[j] = trampa;
            }
        } else {
            trampas[0] = trampa;
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
     * Método hayMonstruos para comprobar si hay algún monstruo en la sala
     * TODO comprobar si hay algún monstruo en la lista
     *
     * @return
     */
    public boolean hayMonstruos() {
        return
    }

    /**
     * Método seleccionarMonstruo para introducir desde pantalla el nombre de un monstruo
     * TODO Mostrar por pantalla todos los monstruos y luego solicitar que se introduzca el nombre del monstruo que se
     *  quiere seleccionar.
     *
     * @param teclado Objeto de tipo "Scanner" que lee lo que el usuario escriba en la consola en este caso el
     *                monstruo seleccionado
     * @return Este método devuelve el monstruo que ha sido seleccionado por el usuario tras imprimir todos por pantalla.
     */
    public Monstruo seleccionarMonstruo(Scanner teclado) {
        Monstruo resultado = null;
        for (){

        }
        return resultado;
    }

    /**
     * Método buscarMonstruo para buscar un monstruo dado el nombre del mismo
     * TODO devolver el monstruo según el nombre pasado como parámetro o devolver null si no se encuentra
     *
     * @param nombreMonstruo
     * @return
     */
    public Monstruo buscarMonstruo(String nombreMonstruo) {

        return
    }

    /**
     * Método listarMonstruos para mostrar por pantalla la información de los monstruos
     * TODO mostrar por pantalla la info de los monstruos utilizando los métodos implementados en la clase "monstruo"
     */
    private void listarMonstruos() {

    }

    /**
     * Método eliminarMonstruo para eliminar un monstruo de la lista segun un nombre dado
     * TODO buscar en la lista el monstruo segun el nombre pasado como parámetro y eliminarlo.
     *
     * @param nombreMonstruo
     */
    public void eliminarMonstruo(String nombreMonstruo) {

    }

    /**
     * Método hayTrampas para saber si la sala dispone de alguna trampa
     * TODO mostrar si existe alguna trampa en la sala, false en caso contrario
     *
     * @return
     */
    public boolean hayTrampas() {

        return
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
     * <p>
     * TODO buscar en la lista de items un item con la descripción pasada como parámetro, devolver null si no lo
     *  encuentra
     *
     * @param descripcion
     * @return
     */
    public Item buscarItem(String descripcion) {

        return
    }

    /**
     * Método buscarTrampa para obtener una trampa según una descripcion dada
     * TODO buscar en la lista de trampas una trampa con la descripción pasada como parámetro, devolver null si no lo
     *  encuentra
     *
     * @param descripcion
     * @return
     */
    public Trampa buscarTrampa(String descripcion) {

        return
    }

    /**
     * Método getTrampas
     *
     * @return Trampa[] trampas
     */
    public Trampa[] getTrampas() {
        return trampas;
    }

    /**
     * Método seleccionarItem para obtener un item concreto con parámetro pasados por pantalla
     * TODO Mostrar por pantalla todos los items de la sala para despues pedir que se introduzca una descripcion del
     *  item que se quiere seleccionar
     *
     * @param teclado
     * @return
     */
    public Item seleccionarItem(Scanner teclado) {

        return
    }

    /**
     * Método listarItems para mostrar por pantalla todos los items
     * TODO utilizar las funciones de la clase Item para poder mostrar por pantalla toda la información de todos los
     *  items que hay en la sala
     */
    private void listarItems() {

    }

    /**
     * Método eliminarItem para eliminar un item con la descripcion pasada como parámetro
     * TODO buscar el item que coincida con la descripción pasada por parámetro y eliminarlo de la lista de items
     *
     * @param descripcion
     */
    public void eliminarItem(String descripcion) {

    }
}
