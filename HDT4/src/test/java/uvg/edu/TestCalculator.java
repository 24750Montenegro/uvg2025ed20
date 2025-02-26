/**
 * HDT4 Factory y Singleton
 * Javier Alvarado - 24546
 * Jonathan Tubac - 24484
 * Juan Montenegro - 24750
 */
package uvg.edu;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para las clases Calculator, EvaluadorExpresiones y StackFactory.
 * Se utiliza JUnit 5 para probar las funcionalidades de conversión, evaluación y manejo de pilas.
 */
public class TestCalculator {

    private final Calculator calculator = Calculator.getInstance();
    private final String testFilePath = "src/main/java/uvg/edu/datos.txt";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    /**
     * Prueba la conversión de expresiones infijas a postfijas.
     */
    @Test
    void testInfixToPostfix() {
        assertEquals("3 4 + ", calculator.infixToPostfix("3+4"), "Error en la conversión de infijo a postfijo");
        assertEquals("5 1 2 + 4 * + 3 - ", calculator.infixToPostfix("5+(1+2)*4-3"), "Error en la conversión de infijo a postfijo");
        assertEquals("2 3 * 5 + ", calculator.infixToPostfix("2*3+5"), "Error en la conversión de infijo a postfijo");
    }

    /**
     * Prueba la evaluación de expresiones postfijas.
     */
    @Test
    void testEvaluatePostfix() {
        assertEquals(7, calculator.evaluatePostfix("3 4 + "), "Error en la evaluación postfija");
        assertEquals(14, calculator.evaluatePostfix("5 1 2 + 4 * + 3 - "), "Error en la evaluación postfija");
        assertEquals(11, calculator.evaluatePostfix("2 3 * 5 + "), "Error en la evaluación postfija");
        assertEquals(27, calculator.evaluatePostfix("2 1 + 9 *"), "Error en la evaluación postfija");
    }

    /**
     * Prueba la división entre cero en la evaluación postfija.
     * Se espera que lance una excepción ArithmeticException.
     */
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.evaluatePostfix("4 0 / "));
        assertEquals("/ by zero", exception.getMessage(), "Error en el manejo de división entre cero");
    }

    /**
     * Configuración previa a las pruebas: escribe expresiones en un archivo
     * y redirige la salida estándar para capturar los resultados.
     *
     * @throws Exception si hay un error al escribir el archivo de prueba.
     */
    @BeforeEach
    void setUp() throws Exception {
        Files.writeString(Path.of(testFilePath), "3+4\n5+(1+2)*4-3\n2*3+5\n");

        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Prueba la evaluación de expresiones desde un archivo de entrada.
     * Verifica que el programa convierta correctamente de infijo a postfijo y calcule el resultado.
     *
     * @throws Exception si ocurre un error durante la prueba.
     */
    @Test
    void testEvaluacionExpresiones() throws Exception {
        String simulatedInput = "arraylist\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EvaluadorExpresiones.main(new String[]{});

        String salida = outputStream.toString();

        assertTrue(salida.contains("Expresión Infix: 3+4"));
        assertTrue(salida.contains("Expresión Postfix: 3 4 +"));
        assertTrue(salida.contains("Resultado: 7"));

        assertTrue(salida.contains("Expresión Infix: 5+(1+2)*4-3"));
        assertTrue(salida.contains("Expresión Postfix: 5 1 2 + 4 * + 3 -"));
        assertTrue(salida.contains("Resultado: 14"));

        assertTrue(salida.contains("Expresión Infix: 2*3+5"));
        assertTrue(salida.contains("Expresión Postfix: 2 3 * 5 +"));
        assertTrue(salida.contains("Resultado: 11"));
    }

    /**
     * Prueba el patrón Singleton en la clase StackFactory.
     * Verifica que siempre se retorne la misma instancia.
     */
    @Test
    void testSingletonInstance() {
        StackFactory instance1 = StackFactory.getInstance();
        StackFactory instance2 = StackFactory.getInstance();
        assertSame(instance1, instance2, "StackFactory debe ser un Singleton");
    }

    /**
     * Prueba que StackFactory devuelva una pila basada en ArrayList.
     */
    @Test
    void testGetStackArrayList() {
        StackFactory factory = StackFactory.getInstance();
        Ipila<Integer> stack = factory.getStack("arraylist");
        assertNotNull(stack, "La pila no debería ser null");
        assertTrue(stack instanceof ArrayListStack, "Debe ser una instancia de ArrayListStack");
    }

    /**
     * Prueba que StackFactory devuelva una pila basada en Vector.
     */
    @Test
    void testGetStackVector() {
        StackFactory factory = StackFactory.getInstance();
        Ipila<Integer> stack = factory.getStack("vector");
        assertNotNull(stack, "La pila no debería ser null");
        assertTrue(stack instanceof VectorStack, "Debe ser una instancia de VectorStack");
    }

    /**
     * Prueba que StackFactory devuelva una pila basada en Lista.
     */
    @Test
    void testGetStackLista() {
        StackFactory factory = StackFactory.getInstance();
        Ipila<Integer> stack = factory.getStack("lista");
        assertNotNull(stack, "La pila no debería ser null");
        assertTrue(stack instanceof Lista, "Debe ser una instancia de Lista");
    }

    /**
     * Prueba que StackFactory lance una excepción cuando se solicita un tipo de pila inválido.
     */
    @Test
    void testGetStackInvalidType() {
        StackFactory factory = StackFactory.getInstance();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factory.getStack("desconocido"));
        assertEquals("Tipo de pila no válido", exception.getMessage(), "Debe lanzar una excepción con mensaje adecuado");
    }
}
