package tecnicas;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    private static final int MAX_INT_STREAM_SIZE = 1000;

    private final EasyRandom random = new EasyRandom();

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    /**
     * <table>
     *   <tr>
     *     <th>Caso</th>
     *     <th>Valor</th>
     * </tr>
     * <tr>
     *     <td>T1</td>
     *     <td>15</td>
     * </tr>
     * <tr>
     *     <td>T2</td>
     *     <td>30</td>
     * </tr>
     * <tr>
     *     <td>T3</td>
     *     <td>8</td>
     * </tr>
     * <tr>
     *     <td>T4</td>
     *     <td>6</td>
     * </tr>
     * <tr>
     *     <td>T5</td>
     *     <td>25</td>
     * </tr>
     * </table>
     * <p>
     *     Qual destes valores pode ser removido sem que o conjunto deixe de ser um bom conjunto de teste?
     *     Que conceito podemos usar para determinar que valores podem ser removidos?
     * </p>
     *
     * <p>Existem 4 pontos de retorno no método, então precisamos de 4 casos (ou tipos de casos).</p>
     * Pode-se remover T1 ou T2.
     */
    @Test
    public void shouldReturnFizz() {

        random.ints(MAX_INT_STREAM_SIZE)
                .filter(v -> v % 3 == 0 && v % 5 != 0)
                .forEach(v -> assertEquals("fizz!", fizzBuzz.fizzBuzz(v)));
    }

    @Test
    public void shouldReturnBuzz() {

        random.ints(MAX_INT_STREAM_SIZE)
                .filter(v -> v % 5 == 0 && v % 3 != 0)
                .forEach(v -> assertEquals("buzz!", fizzBuzz.fizzBuzz(v)));
    }

    @Test
    public void shouldReturnFizzBuzz() {

        random.ints(MAX_INT_STREAM_SIZE)
                .filter(v -> v % 5 == 0 && v % 3 == 0)
                .forEach(v -> assertEquals("fizzbuzz!", fizzBuzz.fizzBuzz(v)));
    }

    @Test
    public void shouldReturnValue() {

        random.ints(MAX_INT_STREAM_SIZE)
                .filter(v -> v % 5 != 0 && v % 3 != 0)
                .forEach(v -> assertEquals(v + "!", fizzBuzz.fizzBuzz(v)));
    }
}