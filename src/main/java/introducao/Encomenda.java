package introducao;

public class Encomenda {

    public static int[] qtdadeBarras(int dispB1, int dispB5, int peso) {

        int[] resp = {-1, -1};

        int maxB5 = peso / 5;
        int qtdadeB5 = Math.min(maxB5, dispB5);
        int qtdadeB1 = peso - (qtdadeB5 * 5);

        if (dispB1 <= qtdadeB1) {
            return resp;
        } else {
            resp[1] = qtdadeB5;
            resp[0] = qtdadeB1;
        }

        return resp;
    }
}
