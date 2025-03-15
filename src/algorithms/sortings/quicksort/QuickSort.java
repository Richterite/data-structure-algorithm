package algorithms.sortings.quicksort;

public class QuickSort {

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++){
            if(array[i] < array[pivotIndex]){
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSortHelper(int[] array, int leftIndex, int rightIndex){
        if (leftIndex < rightIndex){
            int pivotIndex = pivot(array, leftIndex, rightIndex);
            quickSortHelper(array, leftIndex, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1 , rightIndex);

        }
    }

    public static void quicSort(int[] array){
        quickSortHelper(array,0, array.length - 1);
    }
}
