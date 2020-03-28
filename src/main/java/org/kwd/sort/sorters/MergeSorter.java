package org.kwd.sort.sorters;

public class MergeSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        mergeSort(arrayToSort);
        return arrayToSort;
    }

    private void mergeSort(int[] arrayToSort) {
        //test for base case
        if (arrayToSort.length < 2) return;

        int midPoint = arrayToSort.length/2;
        int[] left = populateSplitArray(midPoint, 0, arrayToSort);
        int[] right = populateSplitArray(arrayToSort.length - midPoint, midPoint, arrayToSort); //takes account of odd length arrays

        mergeSort(left);
        mergeSort(right);

        int[] combinedArray = merge(left, right);
        System.arraycopy(combinedArray, 0, arrayToSort, 0, combinedArray.length);
    }

    private int[] populateSplitArray(int length, int startIndex, int[] inputArray) {
        int[] splitArray = new int[length];
        System.arraycopy(inputArray, startIndex, splitArray, 0, length);
        return splitArray;
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int[] combinedArray = new int[leftLength + rightLength];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < leftLength + rightLength; i++) {
            if (leftIndex == leftLength) {
                combinedArray[i] = rightArray[rightIndex];
                rightIndex++;
            } else if (rightIndex == rightLength) {
                combinedArray[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (leftArray[leftIndex] >= rightArray[rightIndex]) { // greater than or equal - caters for duplicate entries
                combinedArray[i] = rightArray[rightIndex];
                rightIndex++;
            } else if (leftArray[leftIndex] < rightArray[rightIndex]) {
                combinedArray[i] = leftArray[leftIndex];
                leftIndex++;
            }
        }
        return combinedArray;
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }



}
