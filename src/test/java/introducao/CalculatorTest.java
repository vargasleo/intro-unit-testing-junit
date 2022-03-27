package introducao;

import introducao.Calculator;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static final int MAX_SIZE_VALUES = 10;
    private final EasyRandom random = new EasyRandom();

    private Calculator calculator;
    private List<Integer> values;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
        values = randomListOfIntegers();
    }

    @Test
    public void shouldSumCorrectly() {

        final var expression = createSumExpression("+");

        final var expected = values.stream()
                .reduce(Integer::sum)
                .orElse(0);

        final var result = calculator.evaluate(expression);

        assertEquals(expected, result);
    }

    @Test
    public void shouldThrowNumberFormatException() {

        final var expected = createSumExpression("#");

        assertThrows(NumberFormatException.class, () -> calculator.evaluate(expected));
    }

    private String createSumExpression(String separator) {

        final var parcialExpression = values
                .stream()
                .map(String::valueOf)
                .reduce("", (partialString, element) -> partialString + element + separator);

        return parcialExpression.substring(0, parcialExpression.lastIndexOf(separator));
    }

    private List<Integer> randomListOfIntegers() {
        return random.objects(Integer.class, MAX_SIZE_VALUES).collect(Collectors.toList());
    }
}
