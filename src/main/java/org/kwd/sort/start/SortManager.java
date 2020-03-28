package org.kwd.sort.start;

import org.kwd.sort.display.DisplayManager;
import org.kwd.sort.exceptions.SorterLoaderException;
import org.kwd.sort.sorters.Sorter;
import java.util.Random;

public class SortManager {

    private DisplayManager displayManager = new DisplayManager();
    private SorterLoader loader = new SorterLoader();

    public void sortArray() {
        try {
            String sortType = displayManager.displayTerminalSortTypeRequest(loader.getSortersLocation());
            String sizeOfArray = displayManager.displayTerminalArraySizeRequest();

            int[] arrayToSort = createArray(Integer.parseInt(sizeOfArray));
            Sorter sorter = selectSorter(sortType);

            runSort(sorter, arrayToSort);
        } catch (SorterLoaderException e) {
            printExceptionMessage(e.getMessage());
        }
    }

    private void runSort(Sorter sorter, int[] arrayToSort) {
        printBeforeSort(sorter.toString(), arrayToSort);
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        long end = System.nanoTime();
        printAfterSort(sortedArray, end-start);
    }


    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10)+1;
        }
        return unsortedArray;
    }

    private Sorter selectSorter(String type) throws SorterLoaderException {
        return loader.getSorter(type);
    }

    private void printBeforeSort(String sortType, int[] sortedArray) {
        displayManager.displayUnsortedArray(sortType, sortedArray);
    }

    private void printAfterSort(int[] sortedArray, long time) {
        displayManager.displaySortedArray(sortedArray, time);
    }

    private void printExceptionMessage(String message) {
        displayManager.displayErrorMessage(message);
    }
}