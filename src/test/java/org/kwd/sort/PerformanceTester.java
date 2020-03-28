package org.kwd.sort;

import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.kwd.sort.binaryTree.BinaryTree;
import org.kwd.sort.binaryTree.BinaryTreeImpl;
import org.kwd.sort.sorters.*;
import org.kwd.sort.sorters.Sorter;

import java.text.DecimalFormat;
import java.util.*;

public class PerformanceTester {

    private static int[] unsortedArray;
    private static int[] arrayToSort;
    private static Map<Long, String > results = new HashMap<>();

    @BeforeClass
    public static void classSetup() {
        Random random = new Random();
        int arraySize = 20000;
        arrayToSort = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayToSort[i] = random.nextInt(arraySize)+1;
        }
    }

    @Before
    public void setup() {
        unsortedArray = arrayToSort.clone();
    }

    @AfterClass
    public static void printResults() {
        Map<Long, String> sortedResults = new TreeMap<>(results);
        DecimalFormat df = new DecimalFormat("###,###.####");
        for (Map.Entry result : sortedResults.entrySet()) {
            long time = (long) result.getKey();
            String sorter = (String) result.getValue();

            System.out.println(sorter + ":");
            System.out.println("Time taken: " + (df.format(time)) + " nano seconds");
            System.out.println("___________________________________________________");
            System.out.println("");
        }
    }

    private void sortResults() {

    }

    @Test
    public void testBubbleSorter() {
        runPerformanceTester(new BubbleSorter());
    }

    @Test
    public void testSelectionSorter() {
        runPerformanceTester(new SelectionSorter());
    }

    @Test
    public void testInsertionSorter() {
        runPerformanceTester(new InsertionSorter());
    }

    @Test
    public void testMergeSorter() {
        runPerformanceTester(new MergeSorter());
    }

    @Test
    public void testMergeSorterIter() {
        runPerformanceTester(new MergeSorterIterative());
    }

    @Test
    public void testBinarySorter() {
        runPerformanceTester(new BinarySorter());
    }

    @Test
    public void testQuickSorter() {
        runPerformanceTester(new QuickSorter());
    }

    @Test
    public void testJavaSorter() {
        runPerformanceTester(new JavaSorter());
    }

    private void runPerformanceTester(Sorter selectedSorter ) {
        long start = System.nanoTime();
        selectedSorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        results.put(end-start, selectedSorter.toString());
    }
}
