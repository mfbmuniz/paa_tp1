public class ArraySearch {

    int comparacoes;

    public ArraySearch() {
        this.comparacoes = 0;
    }

    public int sequencialSearch(int[] requestedArray, int keysearch) {
        for (int i = 0; i < requestedArray.length; i++) {
            if(requestedArray[i] == keysearch){
                return i;
            }
            comparacoes++;
        }
        return requestedArray.length+1;
    }

    public int binarySearch(int[] requestedArray, int keysearch) {
        int tamArray = requestedArray.length /2;
        SelectionSort selection = new SelectionSort();
        int[] array = selection.sort(requestedArray.clone());
        return search(array, keysearch, array.length, 0);
    }
    private int search(int[] array, int keysearch, int max, int min) {

        int mid = (min + max) / 2;

        if (array[mid] == keysearch) {
            comparacoes++;
            return mid;
        }
        comparacoes++;
        if (min >= max){
            comparacoes++;
            return array.length + 1; // não encontrado


        }else if (array[mid] < keysearch) {
            comparacoes+=2;
            return search(array,keysearch,max,mid+1);

        } else {
            comparacoes+=2;
            return search(array,keysearch,mid-1,min);

        }

    }
}
