package org.kwd.sort.display;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {
        private Scanner scanner = new Scanner(System.in);

    public String displayTerminalSortTypeRequest(String path) {
        System.out.println("Enter the number of the sorter you wish to use: ");
        String[] sortNames = getMenuItems(path);
        String sortType = scanner.nextLine();
        return sortNames[Integer.parseInt(sortType)-1];
    }

    public String displayTerminalArraySizeRequest() {
        System.out.println("Please enter the size of array you wish to generate: ");
        return scanner.nextLine();
    }

    public void displayUnsortedArray(String sorterName, int[] unsortedArray) {
        System.out.println("Sorting using the " + sorterName);
        System.out.println("Before sorting:\n" + Arrays.toString(unsortedArray));
    }

    public void displaySortedArray(int[] sortedArray, long timeTaken) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken: " + (df.format(timeTaken)) + " nano seconds");
    }

    public void displayErrorMessage(String message) {
        System.out.println("The following error has occurred:\n" + message);
    }

    private String[] getMenuItems(String path) {
        File sortDirectory = new File(path);
        String[] names = sortDirectory.list();
        Arrays.sort(names != null ? names : new String[0]);
        int index = 1;
        for(String name: names) {
            name = name.substring(0, name.indexOf('.'));
            System.out.println(index + ". " + name);
            index++;
        }
        return names;
    }
}
