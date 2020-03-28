/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kwd.sort.binaryTree;

import org.kwd.sort.exceptions.ChildNotFoundException;

/**
 *
 * @author keithdauris
 *
 */

public class BinaryTreeImpl implements BinaryTree {

	private final Node rootNode;
	private int[] sortedTree;
	private int count;
    private int numberOfNodes = 1;

    public BinaryTreeImpl(final int element) {
        rootNode = new Node(element);
    }

	public BinaryTreeImpl(final int[] elements) {
        rootNode = new Node(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    @Override
    public void addElements(final int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);   
    }

    @Override
    public boolean findElement(final int value) {
        Node node = findNode(value);
        if (node != null) {
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node != null) {
            return node.getValue();
        }
        throw new ChildNotFoundException();
    }

    @Override
    public int getRightChild(int element) {
        return findNode(element).getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
    	sortedTree = new int[numberOfNodes];
    	count = 0;
    	sortTreeAsc(rootNode);
    	return sortedTree;
    }
    
    @Override
    public int[] getSortedTreeDesc() {
        sortedTree = new int[numberOfNodes];
        count = 0;
        sortTreeDesc(rootNode);
        return sortedTree;
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null){
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }
    
 	private void
    addNodeToTree(Node node, int element) {
        if (element == node.getValue()) return;

        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberOfNodes++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (node.isRightChildEmpty()) {
            node.setRightChild(new Node(element));
            numberOfNodes++;
        } else {
            addNodeToTree(node.getRightChild(), element);
        }
    }

    private void sortTreeAsc(Node node) {
    	if (!node.isLeftChildEmpty()) {
            sortTreeAsc(node.getLeftChild());
        }
        sortedTree[count] = node.getValue();
    	count++;
        if (!node.isRightChildEmpty()) {
            sortTreeAsc(node.getRightChild());
        }
    }

    private void sortTreeDesc(Node node) {
        if (!node.isRightChildEmpty()) {
            sortTreeDesc(node.getRightChild());
        }
        sortedTree[count] = node.getValue();
        count++;
        if (!node.isLeftChildEmpty()) {
            sortTreeDesc(node.getLeftChild());
        }
    }

    @Override
    public String toString() {
        return "Binary Tree";
    }
}
