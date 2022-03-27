package introducao;

import introducao.RomanNumeral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    private RomanNumeral converter;

    @BeforeEach
    public void setup() {
        converter = new RomanNumeral();
    }

    @Test
    public void shouldConvertIto1() {
        assertEquals(1, converter.convert("I"));
    }
    @Test
    public void shouldConvertVto5() {
        assertEquals(5, converter.convert("V"));
    }
    @Test
    public void shouldConvertXto10() {
        assertEquals(10, converter.convert("X"));
    }
    @Test
    public void shouldConvertLto50() {
        assertEquals(50, converter.convert("L"));
    }
    @Test
    public void shouldConvertCto100() {
        assertEquals(100, converter.convert("C"));
    }
    @Test
    public void shouldConvertDto500() {
        assertEquals(500, converter.convert("D"));
    }
    @Test
    public void shouldConvertMto1000() {
        assertEquals(1000, converter.convert("M"));
    }
}