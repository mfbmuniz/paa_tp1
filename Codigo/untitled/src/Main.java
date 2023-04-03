import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

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


    public static void primeiraParte(int tamArray) throws IOException {

        String path= "c:\\fpaa\\fpaa_questao1.csv";
        try {
            Path filePath = Paths.get(path);
                if(Files.notExists(filePath)) {
                    File arquivo = new File(path);
                    //arquivo.mkdir();
                    arquivo.createNewFile();
                }
            }catch (Exception e){e.printStackTrace();}
        BufferedWriter out = new BufferedWriter(new FileWriter(path));
        out.write("sep=,");
        out.newLine();
        out.write("TROCAS_BUBBLE,ITERACOES_BUBBLE,ATRIBUICOES_BUBBLE,COMPARACOES_BUBBLE, ," +
                "TROCAS_SELECTION,ITERACOES_SELECTION,ATRIBUICOES_SELECTION,COMPARACOES_SELECTION");
        out.newLine();


        for (int i = 0; i < 50; i++) {

            BubbleSort bubbleSort = new BubbleSort();
            SelectionSort selectionSort = new SelectionSort();
            ArrayGenerator arrayA = new ArrayGenerator(tamArray);

            arrayA.randomPopulateArray();

            ArrayGenerator arrayB = arrayA.clone();

            arrayA.setCurrentArray(bubbleSort.sort(arrayA.getCurrentArray()));
            arrayB.setCurrentArray(selectionSort.sort(arrayB.getCurrentArray()));

            String linha = ( ""+
                    bubbleSort.getTrocas()+","+
                    bubbleSort.getIteracoes()+","+
                    bubbleSort.getAtribuicoes()+","+
                    bubbleSort.getComparacoes()+","+
                    " "+","+
                    selectionSort.getTrocas()+","+
                    selectionSort.getIteracoes()+","+
                    selectionSort.getAtribuicoes()+","+
                    selectionSort.getComparacoes()
                );

            System.out.println(linha);
            out.newLine();
            out.write(linha);

        }

        out.close();
    }
    public static void segundoParte(int tamArray, int loopsNumber) throws IOException{
        String path= "c:\\fpaa\\fpaa_questao2.csv";
        String pathRawData= "c:\\fpaa\\fpaa_questao2RAW.csv";
        Random random = new Random();
        ArraySearch search = new ArraySearch();
        ArrayGenerator arrayA = new ArrayGenerator(tamArray+1);

        Integer[] vetorResultadosRAW = new Integer[(tamArray+2)];

        for (int i = 0; i <= tamArray+1; i++) {
            vetorResultadosRAW[i] = 0;
        }
        Integer[] vetorResultados = new Integer[(vetorResultadosRAW.length/500)+2];
        System.out.println("tamanho do vertor results: " + vetorResultados.length);

        for (int i = 0; i <= (vetorResultadosRAW.length/500)+1; i++) {
            vetorResultados[i] = 0;
            System.out.println("pos: "+i+" valor: "+vetorResultados[i]);
        }

        try {
            Path filePath = Paths.get(path);
            Path filePathRaw = Paths.get(pathRawData);
            if(Files.notExists(filePath)) {
                File arquivo = new File(path);
                //arquivo.mkdir();
                arquivo.createNewFile();
            }
            if(Files.notExists(filePathRaw)) {
                File arquivo = new File(pathRawData);
                //arquivo.mkdir();
                arquivo.createNewFile();
            }
        }catch (Exception e){e.printStackTrace();}

        BufferedWriter out = new BufferedWriter(new FileWriter(path));
        BufferedWriter outRaw = new BufferedWriter(new FileWriter(pathRawData));
        outRaw.write("sep=,");
        outRaw.newLine();

        out.write("sep=,");
        out.newLine();


        outRaw.write("POSICAO PROCURADA,CONTADOR DE ESCOLHAS,COMPARACOES,ITERACOES");
        outRaw.newLine();

        out.write("POSICAO PROCURADA /500 ,CONTADOR DE ESCOLHAS,COMPARACOES,ITERACOES");
        out.newLine();


        arrayA.sortPopulateArray();
        arrayA.printArray();
        int searchPos;
        int randomNumber;
        int groupResultIndex;

        for (int i = 0; i < loopsNumber ; i++) {
            randomNumber = random.nextInt((tamArray+1000));
            searchPos = search.sequencialSearch(arrayA.getCurrentArray(),randomNumber);
            int contadorEscolhas;

            if(searchPos<=tamArray){
                vetorResultadosRAW[searchPos]++;
                contadorEscolhas = vetorResultadosRAW[searchPos];
            }else{
                vetorResultadosRAW[tamArray+1] ++;
                contadorEscolhas=vetorResultadosRAW[tamArray+1];
            }
            String rawLine = (""+searchPos+","+contadorEscolhas+","+search.getComparacoes()+","+search.getIteracoes());
            outRaw.newLine();
            outRaw.write(rawLine);


            int resto = searchPos %500;
            int resultDivisao = searchPos/500;
            boolean estouroArray =  !( resultDivisao<=(tamArray/500) );
            int groupPos;
            if (resto == 0 && !estouroArray ){
                groupPos = (searchPos/500);
                vetorResultados[groupPos]++;

            }else if (!estouroArray){
                groupPos =((searchPos/500)+1);
                vetorResultados[groupPos]++;

            }else {
                groupPos = vetorResultados.length;
                vetorResultados[groupPos]++;
            }
            contadorEscolhas=vetorResultados[groupPos];

            String respLine = (""+groupPos+","+contadorEscolhas+","+search.getComparacoes()+","+search.getIteracoes());
            out.newLine();
            out.write(respLine);

            search = new ArraySearch();
            
            
            
        }
        outRaw.close();
        out.close();


    }


    public static void main(String[] args) {
       try {
           //primeiraParte(1050);
           segundoParte(10000,100);
       }catch (Exception e){e.printStackTrace();}
    }
}