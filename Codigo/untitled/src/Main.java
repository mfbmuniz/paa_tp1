import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main {

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


        outRaw.write("POSICAO PROCURADA,CONTADOR DE ESCOLHAS");
        outRaw.newLine();

        out.write("AGRUPAMENTOS DE POSICAO PROCURADA (/500),CONTADOR DE ESCOLHAS");
        out.newLine();


        arrayA.sortPopulateArray();
        arrayA.printArray();
        int searchPos;
        int randomNumber;
        int groupResultIndex;

        for (int i = 0; i < loopsNumber ; i++) {
            randomNumber = random.nextInt((tamArray+1000));
            searchPos = search.sequencialSearch(arrayA.getCurrentArray(),randomNumber);

            if(searchPos<=tamArray){
                vetorResultadosRAW[searchPos]++;
            }else{
                vetorResultadosRAW[tamArray+1] ++;
            }

            search = new ArraySearch();
        }

        for (int i = 0; i < vetorResultadosRAW.length; i++) {
            int contadorEscolhas = vetorResultadosRAW[i];
            String rawLine = (""+i+","+contadorEscolhas);
            outRaw.newLine();
            outRaw.write(rawLine);

            int resto = i %500;
            int resultDivisao = i/500;

            boolean posicaoValida = ( resultDivisao<=(tamArray/500) );

            if (resto == 0 && posicaoValida && i!=0 && contadorEscolhas>0){

                vetorResultados[resultDivisao]=+contadorEscolhas;

            }else if (resto!=0 && posicaoValida && contadorEscolhas>0){

                vetorResultados[(resultDivisao+1)]+=contadorEscolhas;

            }else if(!posicaoValida && contadorEscolhas>0) {

                vetorResultados[vetorResultados.length-1]+=contadorEscolhas;
            }

        }

        for (int i = 0; i < vetorResultados.length; i++) {

            int contadorEscolhas = vetorResultados[i];


            String respLine = (""+i+","+contadorEscolhas);
            out.newLine();
            out.write(respLine);
        }

        outRaw.close();
        out.close();


    }


    public static void main(String[] args) {
       try {

           //cria a pasta para armazenamento dos dados coletados
           File file = new File("c:\\fpaa");
           if (!file.exists()) {
               file.mkdirs();
           }
           primeiraParte(100000);
           segundoParte(10000,1000000);
           System.out.println("FIM");
       }catch (Exception e){e.printStackTrace();}
    }
}