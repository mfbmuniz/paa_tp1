import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    private Integer[] currentArray;
    private int actualSize;

    public ArrayGenerator() {
        currentArray = new Integer[100000];
        actualSize = 100000;
    }

    public ArrayGenerator(int size) {
        this.currentArray = new Integer[size];
        actualSize = size;
    }

    public ArrayGenerator clone(){
        ArrayGenerator arrayGenerator = new ArrayGenerator(this.actualSize);
        arrayGenerator.currentArray = this.currentArray.clone();
        arrayGenerator.actualSize = this.actualSize;
        return arrayGenerator;

    }

    public void randomPopulateArray(){

        Random random = new Random();
        for (int i = 0; i<actualSize; i++){

            int randomNumber = (i+1)*random.nextInt(this.actualSize);
            boolean contains;
            do {
                contains = (Arrays.asList(this.currentArray)).contains(randomNumber);

                if (!contains) {
                    this.currentArray[i] = randomNumber;

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
                if(currentArray[i]!= arrayToCompare[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public void sortPopulateArray(){

        for (int i = 0; i < actualSize ; i++) {
            currentArray[i] = i;
        }

    }

    public void printArray(){
        for (int i = 0; i < this.currentArray.length; i++) {

            System.out.println("Posiçao: "+i+" Valor: "+ currentArray[i]+"; ");

        }

        System.out.println("-----------------------------------------------------------");
    }

    public Integer[] getCurrentArray() {
        return currentArray;
    }

    public void setCurrentArray(Integer[] currentArray) {
        this.currentArray = currentArray;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(Integer actualSize) {
        this.actualSize = actualSize;
    }
}
