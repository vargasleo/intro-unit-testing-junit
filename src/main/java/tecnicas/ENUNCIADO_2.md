
# Exercícios de técnicas de geração de casos de teste

## Parte 1: particionamento

1. Refazer o exercício das “barras de chocolate” e verificar se consegue detectar todos os 3 bugs.


2. A associação cultural da Universidade vende pacotes de ingressos válidos em todos os cinemas da cidade. O custo unitário dos ingressos é de R$ 25,00. Os ingressos podem ser adquiridos por qualquer pessoa, mas estudantes da própria Universidade tem desconto de 25% e funcionários da Universidade (professores, técnicos etc.) tem desconto de 10%. Compras com mais de 10 ingressos tem 5% de desconto e compras com mais de 50 ingressos tem 5% nos primeiros 50 e 10% nos demais. Calcula-se primeiro o desconto relativos à quantidade. O desconto referente ao tipo de adquirente é aplicado sobre o valor resultante. O método “double calculaCusto(TipoCliente tipo,int quantidade)” (enum TipoCliente { PUBLICOEMGERAL,ESTUDANTE,FUNCIONARIO }) está sendo implementado para dar conta do cálculo do custo dos ingressos. Usando a técnica de particionamento, elabore um conjunto de casos de teste para este problema.


3. Existe um programa chamado FizzBuzz. Ele faz o seguinte: dado um inteiro n, retorna a string formada pelo número seguido de uma “!”. Então o inteiro 6 é convertido em “6!”. Entretanto se o número é divisível por 3 use “FIzz” no lugar do número, se o número for divisível por 5 use “Buzz” e se for divisível tanto por 3 como por 5, use “FIZZBUZZ”. Uma testadora novata está tentando desesperadamente encontrar tantos casos de teste quanto puder para o método FizzBuzz. Ela apresentou os seguintes valores de entrada para compor os casos de teste:

· T1 = 15

· T2 = 30

· T3 = 8

· T4 = 6

· T5 = 25

Qual destes valores pode ser removido sem que o conjunto deixe de ser um bom conjunto de teste? Que conceito podemos usar para determinar que valores podem ser removidos?

4. Especificação do problema: Um determinado site web deve armazenar o ranking dos 10 melhores jogadores de um determinado game (ordenados por ordem decrescente de pontuação). Cada vez que uma partida oficial ocorre, o administrador do site entra com o nome do jogador e sua pontuação. Se houverem menos de 10 jogadores cadastrados o jogador será inserido no ranking independente de seu score. Na medida

em que já houver 10 jogadores cadastrados, novos jogadores só entram se tiverem score maior que o último colocado e sempre que um novo jogador entrar no ranking, o jogador com pontuação mais baixa é eliminado. Os registros devem ser mantidos ordenados em ordem decrescente de pontuação

Esqueleto das classes: para atender a especificação, um desenvolvedor criou as classes “Record” e “Ranking” cujo esqueleto pode ser visto na sequência.

public class Record { public Record(String name, int score) {} public String getName() {} public int getScore() {} public String toString() {} }

public class Ranking {

public Ranking() {}

// Insere novo registro na lista mantendo a ordenação

// Retorna true se a inserção foi possível

public boolean add(Record record) {}

// Retorna à quantidade de registros armazenados

public int numRecords() {}

// Retorna o i-ésimo registro armazenado ou

// null se o valor de i for inválido

public Record getScore(int i) {}

// Retorna o pior score armazenado

// Retorna null se a lista estiver vazia

public Record worstScore() {}

// Retorna o melhor score armazenado

// Retorna null se a lista estiver vazia

public Record bestScore() {}

}

Tarefas:

1. Gerar um conjunto de casos de teste para a classe “Ranking” utilizando a técnica de particionamento (gere um conjunto para cada método)

2. Usando o JUnit, implementar um driver de teste que exercite a classe “Ranking” com os casos de teste definidos na letra “a”.

3. Solicitar para o professor a implementação da classe “Ranking”, aplicar o driver de teste sobre a mesma e relatar os defeitos encontrados (se houverem).