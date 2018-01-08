package com.local;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by harsh on 2/9/17.
 */
public class LevelOrderTraversal {
    BinaryTreeNode treeRoot;

    static void printLevelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode binaryTreeNode = queue.remove();
            System.out.print(binaryTreeNode.data + "\t");
            if (binaryTreeNode.left != null)
                queue.add(binaryTreeNode.left);
            if (binaryTreeNode.right != null)
                queue.add(binaryTreeNode.right);
        }

    }

    static void printSpiralTraversal(BinaryTreeNode root){
        LinkedList<BinaryTreeNode> binaryTreeNodes = new LinkedList<>();
        binaryTreeNodes.add(root);
        int size1 = 1;
        int size2 = 0;
        int maxWidth = 1;
        boolean l2r = true;
        while (!binaryTreeNodes.isEmpty()) {
            while (l2r&&size1>0){
                BinaryTreeNode binaryTreeNode = binaryTreeNodes.removeFirst();
                System.out.print(binaryTreeNode.data + "\t");
                if (binaryTreeNode.left != null) {
                    binaryTreeNodes.addLast(binaryTreeNode.left);
                    size2++;
                }
                if (binaryTreeNode.right != null) {
                    binaryTreeNodes.addLast(binaryTreeNode.right);
                    size2++;
                }
                if(maxWidth<size2){
                    maxWidth= size2;
                }
                size1--;
            }
            while (!l2r&&size2>0){
                BinaryTreeNode binaryTreeNode = binaryTreeNodes.removeLast();
                System.out.print(binaryTreeNode.data + "\t");
                if (binaryTreeNode.right != null) {
                    binaryTreeNodes.addFirst(binaryTreeNode.right);
                    size1++;
                }
                if (binaryTreeNode.left != null) {
                    binaryTreeNodes.addFirst(binaryTreeNode.left);
                    size1++;
                }

                if(maxWidth<size1){
                    maxWidth= size1;
                }
                size2--;
            }
            if(l2r)l2r=false;
            else l2r=true;
        }
        System.out.println("Max Width is " + maxWidth);
    }

    static void printLeftView(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size1 = 1;
        int size2 = 0;
        boolean l2r = true;
        boolean print = true;
        while (!queue.isEmpty()) {
            while (l2r&&size1>0){
                BinaryTreeNode binaryTreeNode = queue.remove();
                if(print) {
                    System.out.print(binaryTreeNode.data + "\t");
                    print = false;
                }
                if (binaryTreeNode.left != null) {
                    queue.add(binaryTreeNode.left);
                    size2++;
                }
                if (binaryTreeNode.right != null) {
                    queue.add(binaryTreeNode.right);
                    size2++;
                }
                size1--;
            }
            while (!l2r&&size2>0){
//                BinaryTreeNode binaryTreeNode = binaryTreeNodes.removeLast();
                BinaryTreeNode binaryTreeNode = queue.remove();
                if(print) {
                    System.out.print(binaryTreeNode.data + "\t");
                    print = false;
                }

                if (binaryTreeNode.left != null) {
                    queue.add(binaryTreeNode.left);
                    size1++;
                }
                if (binaryTreeNode.right != null) {
                    queue.add(binaryTreeNode.right);
                    size1++;
                }
                size2--;
            }
            if(l2r)l2r=false;
            else l2r=true;
            print = true;
        }
    }

    static int diameterOfTree(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        int leftD = diameterOfTree(root.left);
        int rightD = diameterOfTree(root.right);
        return Math.max(Math.max(leftD,rightD), heightOfTree(root.left) + heightOfTree(root.right) +1);
    }

    static int heightOfTree(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
    }

    static void printAtKDistanceFromRoot(BinaryTreeNode root,int pH,int dH){
        if(root==null){
            return;
        }
        if(pH==dH){
            System.out.println(" K distance root " + root.data);
            return;
        }
        printAtKDistanceFromRoot(root.left,pH+1,dH);
        printAtKDistanceFromRoot(root.right,pH+1,dH);
    }


    public static void main(String args[]) {
        LevelOrderTraversal tree_level = new LevelOrderTraversal();
       /* tree_level.treeRoot = new BinaryTreeNode(1);
        tree_level.treeRoot.left = new BinaryTreeNode(2);
        tree_level.treeRoot.right = new BinaryTreeNode(3);
        tree_level.treeRoot.left.left = new BinaryTreeNode(4);
        tree_level.treeRoot.right.right = new BinaryTreeNode(6);
        tree_level.treeRoot.right.right.left = new BinaryTreeNode(5);*/
    /*    tree_level.treeRoot = new BinaryTreeNode(1);
        tree_level.treeRoot.left = new BinaryTreeNode(2);
        tree_level.treeRoot.right = new BinaryTreeNode(3);
        tree_level.treeRoot.left.left = new BinaryTreeNode(7);
        tree_level.treeRoot.left.right = new BinaryTreeNode(6);
        tree_level.treeRoot.right.left = new BinaryTreeNode(5);
        tree_level.treeRoot.right.right = new BinaryTreeNode(4);*/


        tree_level.treeRoot = new BinaryTreeNode(1);
        tree_level.treeRoot.left = new BinaryTreeNode(2);
        tree_level.treeRoot.right = new BinaryTreeNode(3);
        tree_level.treeRoot.left.left = new BinaryTreeNode(4);
        tree_level.treeRoot.left.right = new BinaryTreeNode(5);
        tree_level.treeRoot.left.right.left = new BinaryTreeNode(6);
        tree_level.treeRoot.left.right.right = new BinaryTreeNode(7);
        tree_level.treeRoot.left.right.left.right = new BinaryTreeNode(8);
        tree_level.treeRoot.left.right.left.right.left = new BinaryTreeNode(9);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(tree_level.treeRoot);
        System.out.println("Spiral order traversal of binary tree is - ");
        printSpiralTraversal(tree_level.treeRoot);
        System.out.println("Left view of binary tree is - ");
        printLeftView(tree_level.treeRoot);
        System.out.println("height of tree");
        System.out.println(heightOfTree(tree_level.treeRoot));
        System.out.println("Diameter of tree");
        System.out.println(diameterOfTree(tree_level.treeRoot));
        printAtKDistanceFromRoot(tree_level.treeRoot,0,4);
    }
}
