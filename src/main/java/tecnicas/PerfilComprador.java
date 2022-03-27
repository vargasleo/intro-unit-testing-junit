package tecnicas;

import lombok.*;

@Getter
public enum PerfilComprador {

    /**
     * Os ingressos podem ser adquiridos por qualquer pessoa
     * Estudantes da própria Universidade tem desconto de 25%
     * Funcionários da Universidade (professores, técnicos etc.) tem desconto de 10%.
     */
    GERAL(0),
    ESTUDANTE(0.25),
    FUNCIONARIO(0.10);

    private final double desconto;

    PerfilComprador(double desconto) {
        this.desconto = desconto;
    }

}
