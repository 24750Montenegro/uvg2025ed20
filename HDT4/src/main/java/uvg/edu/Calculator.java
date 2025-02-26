package uvg.edu;

import java.util.Map;

/**
 * Clase Calculator para manejar la conversión y evaluación de expresiones matemáticas.
 * Implementa un patrón Singleton para asegurar una única instancia.
 */
class Calculator {
    private static Calculator instance;
    private StackFactory stackFactory;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private Calculator() {
        stackFactory = StackFactory.getInstance();
    }

    /**
     * Obtiene la única instancia de Calculator (patrón Singleton).
     * @return instancia única de Calculator
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Convierte una expresión infija a notación postfija.
     * @param infix Expresión en notación infija
     * @return Expresión convertida a notación postfija
     */
    public String infixToPostfix(String infix) {
        Ipila<Character> stack = stackFactory.getStack("arraylist");
        StringBuilder postfix = new StringBuilder();
        Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2);

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) postfix.append(ch).append(' ');
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') postfix.append(stack.pop()).append(' ');
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.getOrDefault(ch, 0))
                    postfix.append(stack.pop()).append(' ');
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) postfix.append(stack.pop()).append(' ');
        return postfix.toString();
    }

    /**
     * Evalúa una expresión en notación postfija y devuelve su resultado.
     * @param postfix Expresión en notación postfija
     * @return Resultado de la evaluación
     */
    public int evaluatePostfix(String postfix) {
        Ipila<Integer> stack = stackFactory.getStack("arraylist");
        for (String token : postfix.split(" ")) {
            if (token.matches("\\d+")) stack.push(Integer.parseInt(token));
            else {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}
