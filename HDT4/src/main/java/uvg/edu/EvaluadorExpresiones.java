package uvg.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase que evalúa expresiones matemáticas desde un archivo de texto.
 */
public class EvaluadorExpresiones {
    /**
     * Método principal que solicita el tipo de pila y procesa las expresiones matemáticas desde un archivo.
     * @param args Argumentos de línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de pila (arraylist, vector, lista):");
        String stackType = scanner.nextLine();

        String fileName = "src/main/java/uvg/edu/datos.txt";

        Calculator calculator = Calculator.getInstance();
        StackFactory stackFactory = StackFactory.getInstance();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String infix = fileScanner.nextLine();
                String postfix = calculator.infixToPostfix(infix);
                int resultado = calculator.evaluatePostfix(postfix);
                System.out.println("Expresión Infix: " + infix);
                System.out.println("Expresión Postfix: " + postfix);
                System.out.println("Resultado: " + resultado);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + fileName);
        }
    }
}
