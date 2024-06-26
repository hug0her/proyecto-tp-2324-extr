import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Motor
 */
public class Motor {
    Sala[][] mapa;
    private final int maxItemsPorSala, maxMonstruosPorSala, maxTrampasPorSala, numFilas, numColumnas;

    /**
     * Constructor Clase Motor
     *
     * @param filas               Número de filas de la matriz de objetos "sala" que contiene todas las salas.
     * @param columnas            Número de columnas de la matriz de objetos "sala" que contiene todas las salas.
     * @param maxItemsPorSala     Valor numérico que corresponde con el número máximo de objetos "item" que pueden
     *                            existir por cada sala.
     * @param maxMonstruosPorSala Valor numérico que corresponde con el número máximo de objetos "monstruos"
     *                            que pueden existir por cada sala.
     * @param maxTrampasPorSalas  Valor numérico que corresponde con el número máximo de objetos "trampas" que pueden
     *                            existir por cada sala.
     */
    public Motor(int filas, int columnas, int maxItemsPorSala, int maxMonstruosPorSala, int maxTrampasPorSalas) {
        mapa = new Sala[filas][columnas];
        numColumnas = columnas;
        numFilas = filas;
        this.maxItemsPorSala = maxItemsPorSala;
        this.maxMonstruosPorSala = maxMonstruosPorSala;
        this.maxTrampasPorSala = maxTrampasPorSalas;
    }

    /**
     * Clase cargarMapa para construir la matriz de mapa a traves del fichero.
     *
     * @param ficheroMapa Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                    del archivo que contiene la información de las salas.
     * @return Matriz de las salas que se ha generado tras leer el fichero que se ha insertado al llamar a la función.
     */
    Sala[][] cargarMapa(String ficheroMapa) {
        BufferedReader entrada = null;
        String cadena;
        try {
            entrada = new BufferedReader(new FileReader(ficheroMapa));
            while ((cadena = entrada.readLine()) != null) {
                String[] partes = cadena.split(";");
                Sala sala = new Sala(partes[2], maxItemsPorSala, maxMonstruosPorSala, maxTrampasPorSala, Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
                mapa[sala.getFila()][sala.getColumna()] = sala;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de fichero " + ficheroMapa);
            return null;
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error de cierre de fichero " + ficheroMapa);
            }
        }
        return mapa;
    }

    /**
     * Método cargarItems para agregar los items del fichero en el mapa.
     *
     * @param ficheroItems Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                     del archivo que contiene la información de los items.
     */
    private void cargarItems(String ficheroItems) {
        BufferedReader entrada = null;
        String cadena;
        try {
            entrada = new BufferedReader(new FileReader(ficheroItems));
            while ((cadena = entrada.readLine()) != null) {
                String[] partes = cadena.split(";");
                Item item = new Item(partes[2], Double.parseDouble(partes[3]), Double.parseDouble(partes[4]));
                mapa[Integer.parseInt(partes[0])][Integer.parseInt(partes[1])].agregarItem(item);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de fichero " + ficheroItems);
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error de cierre de fichero " + ficheroItems);
            }
        }
    }

    /**
     * Método cargarMonstruos para agregar los monstruos del fichero en el mapa.
     *
     * @param ficheroMonstruos Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                         del archivo que contiene la información de los monstruos.
     */
    private void cargarMonstruos(String ficheroMonstruos) {
        BufferedReader entrada = null;
        String cadena;
        try {
            entrada = new BufferedReader(new FileReader(ficheroMonstruos));
            while ((cadena = entrada.readLine()) != null) {
                String[] partes = cadena.split(";");
                Monstruo monstruo = new Monstruo(partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), Integer.parseInt(partes[5]));
                mapa[Integer.parseInt(partes[0])][Integer.parseInt(partes[1])].agregarMonstruo(monstruo);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de fichero " + ficheroMonstruos);
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error de cierre de fichero " + ficheroMonstruos);
            }
        }
    }

    /**
     * Método cargarTrampas para agregar las trampas del fichero en el mapa.
     *
     * @param ficheroTrampas Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                       del archivo que contiene la información de las trampas.
     */
    private void cargarTrampas(String ficheroTrampas) {
        BufferedReader entrada = null;
        String cadena;
        try {
            entrada = new BufferedReader(new FileReader(ficheroTrampas));
            while ((cadena = entrada.readLine()) != null) {
                String[] partes = cadena.split(";");
                Trampa trampa = new Trampa(partes[2], Integer.parseInt(partes[3]));
                mapa[Integer.parseInt(partes[0])][Integer.parseInt(partes[1])].agregarTrampa(trampa);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de fichero " + ficheroTrampas);
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error de cierre de fichero " + ficheroTrampas);
            }
        }
    }

    /**
     * Metodo iniciar, para preparar el mapa.
     *
     * @param ficheroMapa      Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                         del archivo que contiene la información de las salas.
     * @param ficheroItems     Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                         del archivo que contiene la información de los items.
     * @param ficheroMonstruos Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                         del archivo que contiene la información de los monstruos.
     * @param ficheroTrampas   Cadena de caracteres que se inserta al llamar a la función y que se corresponde con el nombre
     *                         del archivo que contiene la información de las trampas.
     */
    public void iniciar(String ficheroMapa, String ficheroItems, String ficheroMonstruos, String ficheroTrampas) {
        mapa = cargarMapa(ficheroMapa);
        cargarItems(ficheroItems);
        cargarMonstruos(ficheroMonstruos);
        cargarTrampas(ficheroTrampas);
    }

    /**
     * Método getSala para obtener una sala concreta del mapa.
     *
     * @param fila    Valor numérico que se corresponde con la fila en la que está la sala que queremos obtener.
     * @param columna Valor numérico que se corresponde con la columna en la que está la sala que queremos obtener.
     * @return Este método devuelve una sala que haya sido seleccionada mediante la final y columna.
     */
    public Sala getSala(int fila, int columna) {
        return mapa[fila][columna];
    }

    /**
     * Método mostrarMapa para transformar el mapa en String
     * TODO construir un String con la información contenida en el mapa
     *  respetando el formato que aparece en la memoria de la práctica
     *
     * @param fila    Valor numérico que se corresponde con la fila en la que está la sala que queremos obtener.
     * @param columna Valor numérico que se corresponde con la columna en la que está la sala que queremos obtener.
     * @return Cadena de caracteres que corresponde con la descripción de la sala que se ha seleccionado con la fila y la
     * columna.
     */
    public String mostrarMapa(int fila, int columna) {
        Sala sala;
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                sala = mapa[i][j];
                if (sala != null) {
                    if (sala.getColumna() == columna && sala.getFila() == fila) {
                        resultado.append(" @ ");
                    } else {
                        resultado.append(" # ");
                    }
                }else resultado.append(" - ");
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    /**
     * Método jugar para empezar a jugar con el personaje.
     *
     * @param teclado   Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                  inserte en la consola.
     * @param personaje Objeto personaje que se inserta al llamar a la función y que
     * @param random    Objeto Random creado al llamar a la función y que nos permite obtener un número aleatorio para la
     *                  posibilidad de caer en la trampa.
     */
    public void jugar(Scanner teclado, Personaje personaje, Random random) {
        Sala salaActual = mapa[0][0];
        Sala ultima = mapa[numFilas-1][numColumnas-1];
        do {
            System.out.println(salaActual.getDescripcion());
            if (salaActual.hayMonstruos() && personaje.getVida() > 0) {
                Monstruo monstruo;
                do {
                    monstruo = salaActual.seleccionarMonstruo(teclado);
                    if (monstruo != null) {
                        do {
                            System.out.println(personaje + " ataca a " + monstruo + " con " + personaje.getAtaque() + " puntos de daño.");
                            monstruo.recibirDanyo(personaje.getAtaque());
                            if (monstruo.getVida() > 0) {
                                personaje.recibirDanyo(monstruo.getAtaque());
                            }
                        } while (monstruo.getVida() > 0 && personaje.getVida() > 0);
                        if (monstruo.getVida() <= 0) {
                            System.out.println("¡El " + monstruo.getNombre() + " ha sido derrotado!");
                            salaActual.eliminarMonstruo(monstruo.getNombre());
                        }
                    }
                } while (salaActual.hayMonstruos() && personaje.getVida() > 0);
                if (personaje.getVida() > 0) System.out.println("No quedan monstruos en esta sala");
            }
            if (salaActual.hayTrampas() && personaje.getVida() > 0) {
                Trampa trampa;
                for (int i = 0; i < salaActual.getTrampas().length; i++) {
                    if (salaActual.getTrampas()[i] != null) {
                        trampa = salaActual.getTrampas()[i];
                        if (random.nextInt(0, 50) >= personaje.getDestreza()) {
                            System.out.println("¡Has caído en una trampa! " + trampa.getDescripcion());
                            System.out.println("Te ha hecho " + trampa.getDanyo() + " puntos de daño");
                            personaje.recibirDanyo(trampa.getDanyo());
                        } else {
                            System.out.println("¡Has esquivado la trampa! " + trampa.getDescripcion());
                        }
                    }
                }
            }
            if (salaActual.hayItems() && personaje.getVida() > 0) {
                Item item = salaActual.seleccionarItem(teclado);
                if (item != null) {
                    personaje.anyadirItem(item);
                    salaActual.eliminarItem(item.getDescripcion());
                }
                System.out.println(personaje.infoMochila());
            }
            if (personaje.getVida() > 0 && ultima.hayMonstruos()) {
                salaActual = seleccionarMovimiento(teclado, salaActual);
            }
        } while (personaje.getVida() > 0 && ultima.hayMonstruos());
        if (personaje.getVida() <= 0) System.out.println("---HAS MUERTO---");
        if (salaActual == ultima) System.out.println("---HAS GANADO---");
    }

    /**
     * Método seleccionarMovimiento para establecer las acciones que tome el jugador con su personaje.
     *
     * @param teclado    Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                   inserte en la consola.
     * @param salaActual Objeto de tipo sala que se introduce al llamar a la función y que sw trata de la sala en la
     *                   que se encuentra el personaje actualmente.
     * @return Este método nos devuelve una sala correspondiente con a la que se quiere mover el jugador siempre que
     * esta sala exista.
     */
    public Sala seleccionarMovimiento(Scanner teclado, Sala salaActual) {
        String cadena;
        Sala resultado = null;
        do {
            System.out.print(mostrarMapa(salaActual.getFila(), salaActual.getColumna()));
            System.out.println("Introduce el movimiento (N, E, S, O): ");
            cadena = teclado.nextLine();
            if (cadena.equals("N") && mapa[salaActual.getFila() - 1][salaActual.getColumna()] != null) {
                resultado = mapa[salaActual.getFila() - 1][salaActual.getColumna()];
            }
            if (cadena.equals("E") && mapa[salaActual.getFila()][salaActual.getColumna() + 1] != null) {
                resultado = mapa[salaActual.getFila()][salaActual.getColumna() + 1];
            }
            if (cadena.equals("S") && mapa[salaActual.getFila() + 1][salaActual.getColumna()] != null) {
                resultado = mapa[salaActual.getFila() + 1][salaActual.getColumna()];
            }
            if (cadena.equals("O") && mapa[salaActual.getFila()][salaActual.getColumna() - 1] != null) {
                resultado = mapa[salaActual.getFila()][salaActual.getColumna() - 1];
            }
            if (resultado == null) {
                if (cadena.equals("N")) {
                    System.out.println("No puedes moverte al norte");
                }
                if (cadena.equals("E")) {
                    System.out.println("No puedes moverte al este");
                }
                if (cadena.equals("S")) {
                    System.out.println("No puedes moverte al sur");
                }
                if (cadena.equals("O")) {
                    System.out.println("No puedes moverte al oeste");
                }
            }
        } while (resultado == null);
        return resultado;
    }
}
