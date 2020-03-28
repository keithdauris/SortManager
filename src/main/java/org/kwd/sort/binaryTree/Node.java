/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kwd.sort.binaryTree;

/**
 *
 * @author keithdauris
 */
public class Node {
    
    private final int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightNode) {
        this.rightChild = rightNode;
    }
    
    
    public boolean isLeftChildEmpty() {
        if (leftChild == null) {
            return true;
        }
        return false;
    }
    
    public boolean isRightChildEmpty() {
        if (rightChild == null) {
            return true;
        }
        return false;
    }
}
