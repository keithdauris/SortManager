package org.kwd.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kwd.sort.exceptions.SorterLoaderException;
import org.kwd.sort.sorters.Sorter;
import org.kwd.sort.start.SorterLoader;

import java.util.Random;

import static org.junit.Assert.*;


public class SortTester {

    private static Sorter sorter;
    private int[] unsortedArray;

    @BeforeClass
    public static void setClass() throws SorterLoaderException {
        SorterLoader loader = new SorterLoader();
        sorter = loader.getSorter("BubbleSorter.java");
        System.out.println("Testing using the " + sorter.toString());
    }

    @Before
    public void setup() {
        Random random = new Random();
        unsortedArray = new int[10];
        for (int i = 0; i < 10; i++) {
            unsortedArray[i] = random.nextInt(100)+1;
        }
    }

    @Test(timeout = 20000)
    public void testIsSorted() {
        int[] sortedArray = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sortedArray.length-1; i++) {
           assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testOddSizedArray() {
        int[] unsortedArray = {7,2,4,6,1,3,8,5,9};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(sortedArray.length, unsortedArray.length);
        assertEquals(1,sortedArray.length%2);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] unsortedArray = {7,2,4,6,1,3,8,5,1,4,8};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testSingleLengthArray() {
        int[] unsortedArray = {7};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testAlreadySortedArray() {
        int[] unsortedArray = {1,2,3,4};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i] == unsortedArray[i]);
        }
    }


    @Test
    public void testLargeArray() {
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }


    @After
    public void teardown() {

    }
}
