package linkedIn.algorithms.sorting;

import java.util.Arrays;

public class Sorting {

    // O(n log n)
    public void mergeSort(Integer[] arrayList) {
        if (arrayList.length > 1) {
            int mid = (arrayList.length / 2);
            Integer[] leftArray = Arrays.copyOfRange(arrayList, 0, mid);
            Integer[] rightArray = Arrays.copyOfRange(arrayList, mid, arrayList.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] < rightArray[j]) {
                    arrayList[k] = leftArray[i];
                    i++;
                } else {
                    arrayList[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < leftArray.length) {
                arrayList[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < rightArray.length) {
                arrayList[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

    //O(n^2)
    //коли є два for то скоріш за все це O(n^2) складність
    public void bubbleSorting(Integer[] arrayList) {
        int arrayLength = arrayList.length - 1;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - i; j++) {
                if (arrayList[j] > arrayList[j + 1]) {
                    int temp = arrayList[j];
                    arrayList[j] = arrayList[j + 1];
                    arrayList[j + 1] = temp;
                }
            }
        }
    }

    //Although the worst case time complexity of QuickSort is O(n2)
    // which is more than many other sorting algorithms like Merge Sort and Heap Sort,
    // QuickSort is faster in practice, because its inner loop can be efficiently
    // implemented on most architectures, and in most real-world data
    public void quickSort(Integer[] arrayList) {
        int first = 0;
        int last = arrayList.length - 1;
        quickSort(arrayList, first, last);
    }

    public void quickSort(Integer[] arrayList, int first, int last) {
        int pivotIndex;
        if (first < last) {
            pivotIndex = partition(arrayList, first, last);

            quickSort(arrayList, first, pivotIndex - 1);
            quickSort(arrayList, pivotIndex + 1, last);
        }
    }

    private int partition(Integer[] arrayList, int first, int last) {
        int pivotValue = arrayList[first];

        int lower = first + 1;
        int upper = last;

        boolean done = false;
        int temp = 0;
        while (!done) {
            while (lower <= upper && arrayList[lower] <= pivotValue) {
                lower++;
            }
            while (upper >= lower && arrayList[upper] >= pivotValue) {
                upper--;
            }
            if (upper < lower) {
                done = true;
            } else {
                temp = arrayList[lower];
                arrayList[lower] = arrayList[upper];
                arrayList[upper] = temp;
            }
        }
        temp = arrayList[first];
        arrayList[first] = arrayList[upper];
        arrayList[upper] = temp;
        return upper;
    }


    public void print(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorting mergeSorting = new Sorting();

        //quickSort
        Integer[] arrayForSorting = {1, 2, 3, -4, 12, 135, 72, -1, 0, 222, 7};
        mergeSorting.quickSort(arrayForSorting);

        mergeSorting.print(arrayForSorting);

        //bubbleSorting
//        Integer[] arrayForSorting = {1, 2, 3, -4, 12, 135, 72, -1, 0, 222, 7};
//        mergeSorting.print(arrayForSorting);
//
//        mergeSorting.bubbleSorting(arrayForSorting);
//        mergeSorting.print(arrayForSorting);

        //mergeSort
//        Integer[] arrayForSorting = {1, 2, 3, -4, 12, 135, 72, -1, 0, 222, 7};
//        mergeSorting.print(arrayForSorting);
//
//        mergeSorting.mergeSort(arrayForSorting);
//        mergeSorting.print(arrayForSorting);
    }

}
