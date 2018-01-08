package com.local;

/**
 * Created by harsh on 2/9/17.
 */
public class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

        public BinaryTreeNode(int item) {
            data = item;
            left = null;
            right = null;
        }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
