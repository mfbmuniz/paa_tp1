

public class Main {

    //public static boolean writeExcel(){}
/*
    PRIMEIRA PARTE
    a) Crie um método para gerar um vetor contendo 100.000 valores inteiros aleatórios, sem
    repetição.
            b) Crie uma cópia do vetor gerado em (a).
    c) Utilize o método da bolha para ordenar o vetor original, contando quantas operações de
    comparação de troca e quantas operações de comparação foram realizadas.
    d) Utilize o método da seleção para ordenar o a cópia (b) do vetor, contando quantas
    operações de comparação de troca e quantas operações de comparação foram realizadas.
    e) Repita as operações de (a) até (d) 50 vezes e para este conjunto de testes, registre para cada
    um dos dois algoritmos:
            • Maior, menor e média da quantidade de comparações realizadas;
            • Maior, menor e média da quantidade de trocas realizadas

 */


    public static void primeiraParte(int tamArray){

        //for (int i = 0; i < 50; i++) {

            BubbleSort bubbleSort = new BubbleSort();
            SelectionSort selectionSort = new SelectionSort();
            RandomArrayGenerator arrayA = new RandomArrayGenerator(tamArray);

            arrayA.populateArray();

            RandomArrayGenerator arrayB = arrayA.clone();

            arrayA.setRandomArray(bubbleSort.sort(arrayA.getRandomArray()));
            arrayB.setRandomArray(selectionSort.sort(arrayB.getRandomArray()));

            System.out.println("BubbleSort: Trocas : " + bubbleSort.getTrocas() +
                    " Iteraçoes: " + bubbleSort.getIteracoes() +
                    " Atribuiçoes: " + bubbleSort.getAtribuicoes() +
                    " Comparacoes: " + bubbleSort.getComparacoes());

            System.out.println("SelectionSort: Trocas : " + selectionSort.getTrocas() +
                    " Iteraçoes: " + selectionSort.getIteracoes() +
                    " Atribuiçoes: " + selectionSort.getAtribuicoes() +
                    " Comparacoes: " + selectionSort.getComparacoes());


        //}


    }



    public static void main(String[] args) {
        primeiraParte(1001);
    }
}