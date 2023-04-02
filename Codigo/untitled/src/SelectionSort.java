public class SelectionSort {

    int iteracoes;
    int atribuicoes;
    int comparacoes;
    //entende-se trocas, trocar um valor de uma posiçao x com uma posiçao y, ignorando
    //o numero de atribuiçoes necessrias para fazer esta troca
    int trocas;

    public SelectionSort() {
        this.iteracoes =0;
        this.atribuicoes=0;
        this.comparacoes=0;
        this.trocas =0;
    }



    public int[] sort(int[] requestedArray) {
        int[] array = requestedArray.clone();
        this.atribuicoes++;
        int minimum;

        for(int i = 0; i < array.length-1 ; i++)  {
            this.comparacoes++;
            this.atribuicoes+=2;
            this.iteracoes++;

            minimum = i ;
            atribuicoes++;


            for(int j = (i+1); j < array.length ; j++ ) {
                this.comparacoes++;
                this.atribuicoes+=2;
                this.iteracoes++;
                if( array[ j ] <  array[ minimum ])  {//finds the minimum element
                    minimum = j ;
                    atribuicoes++;
                }
                comparacoes++;
            }
            //swap
            int aux = array[i];
            array[i] = array[minimum];
            array[minimum] = aux;
            atribuicoes+=3;
            trocas++;
        }
        return array.clone();
    }

}
