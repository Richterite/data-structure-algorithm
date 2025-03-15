package algorithms.sortings.insertsort;

public class InsertSort {
    public static void insertionSort(int[] array){
        int temp = array[i];
        int j = i - 1;
        while (j > -1 && temp < array[j]){
            array[j+1] = array[j];
            array[j] = temp;
            j--;
        }
    }
}
