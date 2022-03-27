package tecnicas;

import lombok.Getter;

@Getter
public enum FaixaDesconto {

    FAIXA_1(10, 0.05),
    FAIXA_2(50, 0.10);

    private final int quantidadeMinima;
    private final Double desconto;

    FaixaDesconto(int quantidadeMinima, Double desconto) {
        this.quantidadeMinima = quantidadeMinima;
        this.desconto = desconto;
    }
}
