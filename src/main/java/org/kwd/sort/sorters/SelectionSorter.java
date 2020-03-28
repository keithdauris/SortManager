package org.kwd.sort.sorters;

public class SelectionSorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        selectionSort(arrayToSort);
        return arrayToSort;
    }

    private void selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Selection Sorter";
    }
}
