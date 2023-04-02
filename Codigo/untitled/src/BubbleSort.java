import java.math.BigInteger;

public class BubbleSort {

    int iteracoes;
    int atribuicoes;
    Long comparacoes;
    //entende-se trocas, trocar um valor de uma posiçao x com uma posiçao y, ignorando
    //o numero de atribuiçoes necessrias para fazer esta troca
    Long trocas;

    public BubbleSort() {
        this.iteracoes =0;
        this.atribuicoes=0;
        this.comparacoes=0L;
        this.trocas =0L;
    }

    public Integer[] sort(Integer[] requestedArray) {
        Integer[] array = requestedArray.clone();
        atribuicoes++;
        for(int i = 0; i < array.length - 1; i++) {
            this.comparacoes++;
            this.atribuicoes+=2;
            this.iteracoes++;
            for(int j = 0; j < array.length - 1 - i; j++) {
                this.comparacoes++;
                this.atribuicoes+=2;
                this.iteracoes++;
                if(array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    atribuicoes+=3;
                    trocas++;
                }
                comparacoes++;
            }
        }

        return array.clone();
    }


    public int getIteracoes() {
        return iteracoes;
    }

    public void setIteracoes(int iteracoes) {
        this.iteracoes = iteracoes;
    }

    public int getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(int atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    public Long getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(Long comparacoes) {
        this.comparacoes = comparacoes;
    }

    public Long getTrocas() {
        return trocas;
    }

    public void setTrocas(Long trocas) {
        this.trocas = trocas;
    }
}
