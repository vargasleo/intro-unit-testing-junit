import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncomendaTest {

    /**
     * Implementei apenas os cenários solicitados.
     * Após análise do primeiro resultado dos testes, foi possível perceber que o índice de quantidade de barras estava invertido.
     * */
    @Test
    public void shouldReturnCorrectQuantity1() {

        final var expected = new int[]{3,4};
        final var result = Encomenda.qtdadeBarras(10, 5, 23);

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnCorrectQuantity2() {

        final var expected = new int[]{8,3};
        final var result = Encomenda.qtdadeBarras(10, 3, 23);

        assertArrayEquals(expected, result);
    }
}
