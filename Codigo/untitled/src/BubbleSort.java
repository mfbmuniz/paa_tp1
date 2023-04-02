public class BubbleSort {

    int iteracoes;
    int atribuicoes;
    int comparacoes;
    //entende-se trocas, trocar um valor de uma posiçao x com uma posiçao y, ignorando
    //o numero de atribuiçoes necessrias para fazer esta troca
    int trocas;

    public BubbleSort() {
        this.iteracoes =0;
        this.atribuicoes=0;
        this.comparacoes=0;
        this.trocas =0;
    }

    public int[] sort(int[] requestedArray) {
        int[] array = requestedArray.clone();
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
}
