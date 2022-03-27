package tecnicas;

import java.util.function.BiFunction;

import static tecnicas.FaixaDesconto.FAIXA_1;
import static tecnicas.FaixaDesconto.FAIXA_2;

public class CalcularCustoIngresso {

    /**
     * O custo unitário dos ingressos é de R$ 25,00
     * Calcula-se primeiro o desconto relativos à quantidade.
     * <p>
     * Compras com mais de 10 ingressos tem 5% de desconto
     * Compras com mais de 50 ingressos tem 5% nos primeiros 50 e 10% nos demais
     * O desconto referente ao tipo de adquirente é aplicado sobre o valor resultante
     */
    public static final double PRECO_BASE = 25;


    //Função auxiliar para calcular o preço final a partir do preço base, dada a quantidade e percentual de desconto.
    private final BiFunction<Integer, Double, Double> precoTotalDescontado = (qt, desconto) -> PRECO_BASE * (1 - desconto) * qt;

    public Double calcular(PerfilComprador tipo, Integer quantidade) {

        // O desconto referente ao tipo de adquirente é aplicado sobre o valor resultante
        return precoComDescontoPorQuantidade(quantidade) * (1 - tipo.getDesconto());
    }

    private double precoComDescontoPorQuantidade(final Integer quantidade) {

        if (quantidade >= FAIXA_1.getQuantidadeMinima()) {
            if (quantidade >= FAIXA_2.getQuantidadeMinima()) {

                // Compras com mais de 50 ingressos tem o desconto de 5% (FAIXA_1#getDesconto) nos primeiros 50
                var descontadoQtMinima =  precoTotalDescontado.apply(FAIXA_2.getQuantidadeMinima(), FAIXA_1.getDesconto());
                // O restante tem desconto de 10% (FAIXA_2#getDesconto)
                var descontadoRestante =  precoTotalDescontado.apply(quantidade - FAIXA_2.getQuantidadeMinima(), FAIXA_2.getDesconto());

                return descontadoQtMinima + descontadoRestante;
            }
            return precoTotalDescontado.apply(quantidade, FAIXA_1.getDesconto());
        }
        return PRECO_BASE * quantidade;
    }
}
