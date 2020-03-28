package org.kwd.sort.sorters;

public class MergeSorterIterative implements Sorter{

    public int[] sortArray(int[] arrayToSort) {
        int[][] combinedArrays = createInitialArrays(arrayToSort);
        while (combinedArrays.length > 1) {
            int[][] tmpArray = new int[getNextArrayLength(combinedArrays.length)][];
            int j = 0;
            for (int i = 0; i < combinedArrays.length; i=i+2 ) {
                if (i == combinedArrays.length -1) {
                    tmpArray[j] = combinedArrays[i];
                } else {
                    int[] newElement = mergeArrays(combinedArrays[i], combinedArrays[i+1]);
                    tmpArray[j] = newElement;
                }
                j++;
            }
            combinedArrays = tmpArray.clone();
        }
        return combinedArrays.length>0?combinedArrays[0]:new int[0];
    }

    private int[][] createInitialArrays(int[] arrayToSort) {
        int[][] elements = new int[arrayToSort.length][];
        int k = 0;
        for (int element:arrayToSort) {
            elements[k] = new int[]{element};
            k++;
        }
        return elements;
    }

    private int getNextArrayLength(int length) {
        return length%2 != 0?length/2 +1:length/2;
    }


    private int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int[] combinedArray = new int[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < combinedArray.length; i++) {
            if (leftIndex == leftArray.length) {
                combinedArray[i] = rightArray[rightIndex];
                rightIndex++;
            } else if (rightIndex == rightArray.length) {
                combinedArray[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (leftArray[leftIndex] >= rightArray[rightIndex]) { // greater than or equal - caters for duplicate entries
                combinedArray[i] = rightArray[rightIndex];
                rightIndex++;
            } else {
                combinedArray[i] = leftArray[leftIndex];
                leftIndex++;
            }
        }
        return combinedArray;
    }

    @Override
    public String toString() {
        return "Merge Sorter - iterative";
    }
}
