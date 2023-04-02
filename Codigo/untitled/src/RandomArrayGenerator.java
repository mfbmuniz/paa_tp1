import com.sun.nio.sctp.SctpSocketOption;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator {

    private Integer[] randomArray;
    private int actualSize;

    public RandomArrayGenerator() {
        randomArray = new Integer[100000];
        actualSize = 100000;
    }

    public RandomArrayGenerator(int size) {
        this.randomArray = new Integer[size];
        actualSize = size;
    }

    public RandomArrayGenerator clone(){
        RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator(this.actualSize);
        randomArrayGenerator.randomArray = this.randomArray.clone();
        randomArrayGenerator.actualSize = this.actualSize;
        return  randomArrayGenerator;

    }

    public void populateArray (){

        Random random = new Random();
        for (int i = 0; i<actualSize; i++){

            int randomNumber = (i+1)*random.nextInt(this.actualSize);
            boolean contains;
            do {
                contains = (Arrays.asList(this.randomArray)).contains(randomNumber);

                if (!contains) {
                    this.randomArray[i] = randomNumber;

                }else{
                    randomNumber = i*random.nextInt(this.actualSize);

                }
            }while (contains);
        }
    }
    public boolean contentEquals(int[] arrayToCompare){

        if(this.actualSize != arrayToCompare.length){
            return false;
        }else{
            for(int i = 0; i<actualSize; i++){
                if(randomArray[i]!= arrayToCompare[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public void printArray(){
        for (int i = 0; i < this.randomArray.length; i++) {

            System.out.println("Posiçao: "+i+" Valor: "+randomArray[i]+"; ");

        }

        System.out.println("-----------------------------------------------------------");
    }

    public Integer[] getRandomArray() {
        return randomArray;
    }

    public void setRandomArray(Integer[] randomArray) {
        this.randomArray = randomArray;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(Integer actualSize) {
        this.actualSize = actualSize;
    }
}
