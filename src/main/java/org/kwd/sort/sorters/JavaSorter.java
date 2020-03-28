package org.kwd.sort.sorters;

import java.util.Arrays;

public class JavaSorter implements Sorter {


    @Override
    public int[] sortArray(int[] arrayToSort) {
        Arrays.sort(arrayToSort);
        return arrayToSort;
    }

    @Override
    public String toString() {
        return "Java in-built sorter";
    }
}
