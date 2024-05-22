import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal de Aventuras desde donde lanzar la ejecución de la práctica
 */
public class Aventuras {

    /**
     * Main desde donde ejecutar el programa.
     *
     * @param args Argumentos que se insertan y definen los parámetros del juego son en este orden:
     *             1. filas: Número de filas del mapa.
     *             2. columnas: Número de columnas del mapa.
     *             3. max_items: Número máximo de ítems que puede haber en cada sala.
     *             4. max_monstruos: Número máximo de monstruos que puede haber en cada sala.
     *             5. max_trampas: Número máximo de trampas que puede haber en cada sala.
     *             6. fichero_salas: Fichero de texto con la información de las salas.
     *             7. fichero_items: Fichero de texto con la información de los ítems.
     *             8. fichero_monstruos: Fichero de texto con la información de los monstruos.
     *             9. fichero_trampas: Fichero de texto con la información de las trampas.
     *             10. fichero_puntuaciones: Fichero de texto con las puntuaciones de otras partidas.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        if (args.length != 10) {
            System.out.println("Número de argumentos incorrecto");
            return;
        }
        mostrarPuntuaciones(args[9]);
        Motor motor = new Motor(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        motor.iniciar(args[5], args[6], args[7], args[8]);

        Personaje jugador = Personaje.crearPersonaje(teclado);
        motor.jugar(teclado, jugador, new Random());
        guardarPuntuacion(args[9], jugador);
    }

    /**
     * Método guardarPuntuación en fichero.
     *
     * @param ficheroPuntuaciones Cadena de caracteres que se inserta al llamar a la función y que se corresponde con
     *                            el nombre del archivo que contiene la información del histórico de puntuaciones de
     *                            todas las partidas jugadas.
     * @param jugador             Objeto personaje insertado al llamar a la función y que se trata del personaje que se quiere guardar
     *                            en el fichero de puntuaciones.
     */
    private static void guardarPuntuacion(String ficheroPuntuaciones, Personaje jugador) {
        FileWriter writer = null;
        try {
            LocalDate ahora = LocalDate.now();
            writer = new FileWriter(ficheroPuntuaciones, true);
            writer.write(ahora + "\t");
            writer.write("{ " + jugador.getNombre());
            writer.write(" (V: " + jugador.getVida() + ",");
            writer.write(" A: " + jugador.getAtaque() + ",");
            writer.write(" D: " + jugador.getDefensa() + ",");
            writer.write(" X: " + jugador.getDestreza() + ") }, ");
            writer.write(jugador.getValorMochila() + " monedas.");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException al escribir:" + ex.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error en el cierre del fichero");
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
        try {
            in = new Scanner(new File(ficheroPuntuaciones));
            if (in.hasNext()){
            System.out.println("Puntuaciones: ");}
            while (in.hasNext()) {
                System.out.println(in);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
