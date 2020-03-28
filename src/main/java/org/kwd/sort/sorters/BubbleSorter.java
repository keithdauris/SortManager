package org.kwd.sort.sorters;

public class BubbleSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        return bubbleSort(arrayToSort);
    }

    private int[] bubbleSort(int[] inputArray) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for( int i = 0; i < inputArray.length-1;i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    int swaps = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = swaps;
                    swapped = true;
                }
            }
        }
        return inputArray;
    }

    @Override
    public String toString() {
        return "Bubble Sorter";
    }
}
