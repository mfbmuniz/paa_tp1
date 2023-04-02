import com.sun.nio.sctp.SctpSocketOption;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator {

    private int[] randomArray;
    private int actualSize;

    public RandomArrayGenerator() {
        randomArray = new int[100000];
        actualSize = 100000;
    }

    public RandomArrayGenerator(int size) {
        this.randomArray = new int[size];
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
        for (int i = 0; i<actualSize-1; i++){

            int randomNumber = i*random.nextInt(this.actualSize);
            boolean contains = Arrays.asList(this.randomArray).contains(randomNumber);
            if (!contains) {
                this.randomArray[i] = randomNumber;
            }
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

}
