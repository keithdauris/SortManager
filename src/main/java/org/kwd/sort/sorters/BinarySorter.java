package org.kwd.sort.sorters;

import org.kwd.sort.binaryTree.BinaryTree;
import org.kwd.sort.binaryTree.BinaryTreeImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySorter implements Sorter {

    Map<String,String> map = new HashMap<>();

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree tree = new BinaryTreeImpl(arrayToSort);
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "Binary Tree";
    }
}
