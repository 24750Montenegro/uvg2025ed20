package uvg.edu;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class EvaluadorExpresiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión infix:");
        String infix = scanner.nextLine();
        Calculator calculator = Calculator.getInstance();
        String postfix = calculator.infixToPostfix(infix);
        int resultado = calculator.evaluatePostfix(postfix);
        System.out.println("Expresión Postfix: " + postfix);
        System.out.println("Resultado: " + resultado);
    }
}