package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        int [] arrayNumeros;
        arrayNumeros = cargarNumero();
        arrayNumeros = ordenarArreglo(arrayNumeros);
        out.println("Salida:");
        printArray(arrayNumeros);
    }

    /**
     * Método:      printArray
     * Descripción  Método que recibe un arreglo de números y los imprime
     * @param array Arreglo de números
     */
    private static void printArray(int [] array) {
        String txt = "| ";
        for (int j : array) {
            txt = txt + j + " | ";
        }
        out.println(txt);
    }

    /**
     * Método:      cargarNumero
     * Descripción  Método que se encarga de solicitar la lista de números que va a ser contenido en el arreglo
     * @return      Arreglo de variables de tipo int
     * @throws IOException  Exceción
     */
    private static int[] cargarNumero() throws IOException {
        int [] numeros = new int [5];
        String msg;
        int count = 0;
        do {
            msg = "Entrada " + (count + 1) + ":";
            numeros[count] = ingresar_int(msg);
            count = count + 1;
        } while (count < 5);
        return numeros;
    }

    /**
     * Método:      ordenarArreglo
     * Descripción  Método que ordena el arreglo que recibe como parámetro
     * @param lista Arreglo de variables de tipo int
     * @return      Arreglo de variables de tipo int ordenada de forma ascendente
     */
    private static int [] ordenarArreglo(int [] lista) {
        Arrays.sort(lista);
        return lista;
    }

    /**
     * Método:      ingresar_int
     * Descripción  Método que permite el ingreso de valores de tipo int
     * @param msg   Variable de tipo String que contiene el mensaje enviado al usuario
     * @return      Variable de tipo int que representa el número que se ingresó por teclado
     * @throws IOException  Excepción
     */
    private static int ingresar_int(String msg) throws IOException {
        String respuesta = "La número ingresado no es válida, debe intentarlo nuevamente.\n";
        String valor;
        int num = 0;
        boolean salir = false, validacion;
        do {
            out.println(msg);
            valor = in.readLine();
            validacion = esIntValido(valor);
            if (validacion) {
                num = Integer.parseInt(valor);
                salir = true;
            } else {
                out.print(respuesta);
            }
        } while (!salir);
        return num;
    }

    /**
     * Método:      esIntValido
     * Descripción  Método que permite validar si el valor ingresado en un número
     * @param valor Variable de tipo boolean que representa si el valor es un int (true) o no (false)
     * @return      Variable de tipo boolean que representa si es válida (true) o no (false)
     */
    private static boolean esIntValido(String valor) {
        boolean respuesta;
        try {
            Integer.parseInt(valor);
            respuesta = true;
        } catch (NumberFormatException e) {
            respuesta = false;
        }
        return respuesta;
    }
}
