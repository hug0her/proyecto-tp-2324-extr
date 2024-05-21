import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal de Aventuras desde donde lanzar la ejecución de la práctica
 */
public class Aventuras {

    /**
     * Main desde donde ejecutar el programa
     * TODO instanciación e inicialización de objetos para la ejecución,
     *  ejecución del motor, muestra de puntuaciones y lectura de instrucciones
     *  por teclado para jugar. Finalmente guardar la puntuación
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        if (args.length != 10) {
            System.out.println("Número de argumentos incorrecto");
            return;
        }

        Motor motor = new Motor(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        motor.iniciar(args[5], args[6], args[7], args[8]);

        Personaje jugador = Personaje.crearPersonaje(teclado);
        motor.jugar(teclado, jugador, new Random());
        guardarPuntuacion(args[9], jugador);
    }

    /**
     * Método guardarPuntuación en fichero
     * TODO abrir y guardar en el fichero pasado como parametro el personaje
     *  siguiendo el formato descrito en la memoria de la práctica
     *
     * @param ficheroPuntuaciones Cadena de caracteres que se inserta al llamar a la función y que se corresponde con
     *                            el nombre del archivo que contiene la información del histórico de puntuaciones de
     *                            todas las partidas jugadas.
     * @param jugador             Objeto personaje insertado al llamar a la función y que se trata del personaje que se quiere guardar
     *                            en el fichero de puntuaciones.
     */
    private static void guardarPuntuacion(String ficheroPuntuaciones, Personaje jugador) {
        try {
            File fichero = new File(ficheroPuntuaciones);


        } catch (IOException ex) {
            System.out.println("IOException al escribir:" + ex.getMessage());
        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }

    /**
     * Método mostrarPuntuaciones del fichero puntuaciones.
     *
     * @param ficheroPuntuaciones Cadena de caracteres que se inserta al llamar a la función y que se corresponde con
     *                            el nombre del archivo que contiene la información del histórico de puntuaciones de
     *                            todas las partidas jugadas.
     */
    private static void mostrarPuntuaciones(String ficheroPuntuaciones) {
        Scanner in = null;
        System.out.println("Puntuaciones: ");
        try {
            in = new Scanner(new File(ficheroPuntuaciones));
            while (in.hasNext()) {
                System.out.println(in);
            }
        } catch (IOException ex) {
            System.out.println("IOException al leer: " + ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
