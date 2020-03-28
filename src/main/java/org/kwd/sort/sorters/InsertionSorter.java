package org.kwd.sort.sorters;

public class InsertionSorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        insertionSort(arrayToSort);
        return arrayToSort;
    }

    private void insertionSort(int[] array) {
        for (int i=1; i<array.length; ++i) {
            int key = array[i];
            int j = i-1;

            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    }

    @Override
    public String toString() {
        return "Insertion Sorter";
    }

}
