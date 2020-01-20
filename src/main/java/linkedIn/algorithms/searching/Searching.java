package linkedIn.algorithms.searching;

public class Searching {

    public Integer findItem(int item, Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (item == array[i]) {
                return i;
            }
        }
        throw new ArrayStoreException("Item is not in array");
    }

    public Integer binarySearch(int item, Integer[] array) {
        int lowerIndex = 0;
        int upperIndex = array.length;

        while (lowerIndex <= upperIndex) {
            int meddlePoint = (lowerIndex + upperIndex) / 2;

            if (array[meddlePoint] == item) {
                return meddlePoint;
            }

            if (item > array[meddlePoint]) {
                lowerIndex = meddlePoint + 1;
            } else {
                upperIndex = meddlePoint - 1;
            }
        }
        throw new ArrayStoreException("Item is not in array");
    }

    public static void main(String[] args) {

        Searching searching = new Searching();
        Integer[] arrayForSearching = {1, 2, 3, -4, 12, 135, 72, -1, 0, 222, 7};
        Integer[] sortedArrayForSorting = {1, 2, 3, 4, 12, 13, 72, 100, 222, 777, 1000};

//        System.out.println(searching.findItem(133, arrayForSearching));
        System.out.println(searching.binarySearch(13, sortedArrayForSorting));

    }

}
