package com.local;

public class NodesAtKDistance {
    public static void main(String[] args) {
   /*     BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);*/

        BinaryTreeNode root=new BinaryTreeNode(5);
        root.left=new BinaryTreeNode(4);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(2);
        root.right.right=new BinaryTreeNode(6);
        root.left.right=new BinaryTreeNode(1);
        root.left.left.left=new BinaryTreeNode(14);
        root.left.left.right=new BinaryTreeNode(15);
        //printAtKDistanceRoot(root,2);
        printAtKDistanceLeaf(root,1);
        printAtKDistanceGivenNode(root,2);
    }

    private static void printAtKDistanceGivenNode(BinaryTreeNode root, int k) {

    }

    private static void printAtKDistanceLeaf(BinaryTreeNode root, int k) {
        printAtKDistance(root,k);
    }
    private static int printAtKDistance(BinaryTreeNode root,int k){
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            return k-1;
        }
        int minDistance = Integer.MAX_VALUE;
        if(root.left!=null){
            int lDistance = printAtKDistance(root.left, k);
            if(lDistance==0){
                System.out.println(root.data);
            }else{
                if(lDistance<minDistance){
                    minDistance = lDistance;
                }
            }
        }
        if(root.right!=null){
            int rDistance = printAtKDistance(root.right, k);
            if(rDistance==0){
                System.out.println(root.data);
            }else{
                if(rDistance<minDistance){
                    minDistance = rDistance;
                }
            }
        }
        return minDistance-1;
    }

    private static void printAtKDistanceRoot(BinaryTreeNode root, int k){
        if(root == null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
        }else{
            printAtKDistanceRoot(root.left,k-1);
            printAtKDistanceRoot(root.right,k-1);
        }
    }
}
