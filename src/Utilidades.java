import java.util.Scanner;

/**
 * Clase Utilidades
 */
public class Utilidades {

    /**
     * Método estático leerCadena para leer una cadena de caracteres por pantalla.
     *
     * @param teclado Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                inserte en la consola.
     * @param s       Cadena de caracteres que se inserta al llamar a la función y se imprime por pantalla antes de
     *                leer el dato que se quiera insertar.
     * @return Este método lee la cadena de caracteres que el usuario inserte en la consola y la devuelve como
     * un String.
     */
    public static String leerCadena(Scanner teclado, String s) {
        System.out.println(s);
        return teclado.next();
    }

    /**
     * Método estático leerNumero para leer un número pasado por pantalla.
     *
     * @param teclado Objeto asociado al Scanner con el que se lee la cadena de caracteres que el usuario
     *                inserte en la consola.
     * @param mensaje Cadena de caracteres que se inserta al llamar a la función y se imprime por pantalla antes de
     *                leer el dato que se quiera insertar. "Mensaje" se imprimirá por pantalla hasta que se inserte un número válido.
     * @param minimo  Número mínimo que se inserta al llamar a la función. Cualquier número menor que "mínimo" no será
     *                reconocido como un número valido.
     * @param maximo  Número máximo que se inserta al llamar a la función. Cualquier número mayor que "máximo" no será
     *                reconocido como un número valido.
     * @return Este método devuelve el número que el usuario inserta en la consola y que está leído con el objeto
     * teclado. Este número deberá de estar entre los límites que forman las variables "mínimo" y "máximo".
     */

    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        int numero;
        do {
            System.out.println(mensaje);
            numero = teclado.nextInt();
            if (numero < minimo || numero > maximo) {
                System.out.println("Numero incorrecto");
            }
        } while (numero < minimo || numero > maximo);

        return numero;
    }
}
