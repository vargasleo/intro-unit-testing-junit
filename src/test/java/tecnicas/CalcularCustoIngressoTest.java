package tecnicas;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
import static tecnicas.CalcularCustoIngresso.PRECO_BASE;
import static tecnicas.FaixaDesconto.FAIXA_1;
import static tecnicas.FaixaDesconto.FAIXA_2;
import static tecnicas.PerfilComprador.*;

class CalcularCustoIngressoTest {

    private static final Integer MAX_QUANTITY = 1000;
    private final EasyRandom random = new EasyRandom();

    private final BiFunction<Double, Double, Double> aplicaDesconto = (preco, desconto) -> preco * (1 - desconto);

    private final CalcularCustoIngresso precoIngresso = new CalcularCustoIngresso();
    private PerfilComprador perfilComprador;
    private Integer quantidade;

    /**
     * <p>A estratégia para escolher os casos de teste consiste em cobrir todos os possíveis casos:</p>
     * <i>3 possibilidades de descontos por tipo:</i>
     * <ul>
     *   <li>Compras com menos de 10 ingressos</li>
     *   <li>Compras com mais de 10 e menos de 50 ingressos</li>
     *   <li>Compras com mais de 50 ingressos</li>
     * </ul>
     * <i>3 possibilidades de descontos por pessoa:</i>
     * <ul>
     *   <li>Geral</li>
     *   <li>Estudante</li>
     *   <li>Funcionário</li>
     * </ul>
     * <p>Aplicando um teste para cada cenário possível: 3 * 3 = 9 casos de teste</p>
     */

    @Test
    public void shouldReturnWhenQtMenorFaixaUmAndPerfilGeral() {

        perfilComprador = GERAL;
        quantidade = random.nextInt(FAIXA_1.getQuantidadeMinima());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * PRECO_BASE, resultado);
    }

    @Test
    public void shouldReturnWhenQtMenorFaixaDoisAndPerfilGeral() {

        perfilComprador = GERAL;
        quantidade = FAIXA_1.getQuantidadeMinima() + random.nextInt(FAIXA_2.getQuantidadeMinima() - FAIXA_1.getQuantidadeMinima() - 1);
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto()), resultado);
    }

    @Test
    public void shouldReturnWhenQtMaiorFaixaDoisAndPerfilGeral() {

        perfilComprador = GERAL;
        quantidade = FAIXA_2.getQuantidadeMinima() + random.nextInt(MAX_QUANTITY);
        final var totalAbaixoFaixa2 = FAIXA_2.getQuantidadeMinima() * aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto());
        final var totalAcimaFaixa2 = (quantidade - FAIXA_2.getQuantidadeMinima()) * aplicaDesconto.apply(PRECO_BASE, FAIXA_2.getDesconto());
        final var expected = totalAbaixoFaixa2 + totalAcimaFaixa2;
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(expected, resultado);
    }

    @Test
    public void shouldReturnWhenQtMenorFaixaUmAndPerfilEstudante() {

        perfilComprador = ESTUDANTE;
        final var quantidade = random.nextInt(FAIXA_1.getQuantidadeMinima());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * aplicaDesconto.apply(PRECO_BASE, perfilComprador.getDesconto()), resultado);
    }

    @Test
    public void shouldReturnWhenQtMenorFaixaDoisAndPerfilEstudante() {

        perfilComprador = ESTUDANTE;
        final var quantidade = FAIXA_1.getQuantidadeMinima() + random.nextInt(FAIXA_2.getQuantidadeMinima() - FAIXA_1.getQuantidadeMinima());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * aplicaDesconto.apply(aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto()), perfilComprador.getDesconto()), resultado);
    }

    @Test
    public void shouldReturnWhenQtMaiorFaixaDoisAndPerfilEstudante() {

        perfilComprador = ESTUDANTE;
        final var quantidade = FAIXA_2.getQuantidadeMinima() + random.nextInt(MAX_QUANTITY);
        final var totalAbaixoFaixa2 = FAIXA_2.getQuantidadeMinima() * aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto());
        final var totalAcimaFaixa2 = (quantidade - FAIXA_2.getQuantidadeMinima()) * aplicaDesconto.apply(PRECO_BASE, FAIXA_2.getDesconto());
        final var expected = aplicaDesconto.apply(totalAbaixoFaixa2 + totalAcimaFaixa2, perfilComprador.getDesconto());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(expected, resultado);
    }

    @Test
    public void shouldReturnWhenQtMenorFaixaUmAndPerfilFuncionario() {

        perfilComprador = FUNCIONARIO;
        final var quantidade = random.nextInt(FAIXA_1.getQuantidadeMinima());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * aplicaDesconto.apply(PRECO_BASE, perfilComprador.getDesconto()), resultado);
    }

    @Test
    public void shouldReturnWhenQtMenorFaixaDoisAndPerfilFuncionario() {

        perfilComprador = FUNCIONARIO;
        final var quantidade = FAIXA_1.getQuantidadeMinima() + random.nextInt(FAIXA_2.getQuantidadeMinima() - FAIXA_1.getQuantidadeMinima());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(quantidade * aplicaDesconto.apply(aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto()), perfilComprador.getDesconto()), resultado);
    }

    @Test
    public void shouldReturnWhenQtMaiorFaixaDoisAndPerfilFuncionario() {

        perfilComprador = FUNCIONARIO;
        final var quantidade = FAIXA_2.getQuantidadeMinima() + random.nextInt(MAX_QUANTITY);
        final var totalAbaixoFaixa2 = FAIXA_2.getQuantidadeMinima() * aplicaDesconto.apply(PRECO_BASE, FAIXA_1.getDesconto());
        final var totalAcimaFaixa2 = (quantidade - FAIXA_2.getQuantidadeMinima()) * aplicaDesconto.apply(PRECO_BASE, FAIXA_2.getDesconto());
        final var expected = aplicaDesconto.apply(totalAbaixoFaixa2 + totalAcimaFaixa2, perfilComprador.getDesconto());
        final var resultado = precoIngresso.calcular(perfilComprador, quantidade);

        assertEquals(expected, resultado);
    }
}