package org.kwd.sort.sorters;

public class QuickSorter implements Sorter {

    private int[] array;

    @Override
    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            return new int[0];
        }
        this.array = arrayToSort;
        quickSort(0 ,arrayToSort.length-1);
        return array;
    }

    private void quickSort(int left, int right) {
        int leftIndex = left, rightIndex = right;
        int pivot = array[(left+right)/2];
        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < pivot)
                leftIndex++;
            while (array[rightIndex] > pivot)
                rightIndex--;
            if (leftIndex <= rightIndex) {
                swap(leftIndex, rightIndex);
                leftIndex++;

                rightIndex--;
            }
        }
        if (left < rightIndex)
            quickSort(left, rightIndex);
        if (leftIndex < right)
            quickSort(leftIndex, right);
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Override
    public String toString() {
        return "Quick Sort";
    }
}
