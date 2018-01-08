package com.local;

public class HeightOfTreeByArrayOfParentNodes {

    public static void main(String[] args) {
         int parent[] = {1, 5, 5, 2, 2, -1, 3};
        //int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};

        int n = parent.length;
        System.out.println("Height is  " + findHeight(parent, n));
    }

    private static String findHeight(int[] parent, int n) {
        int[] depths = new int[n];
        for (int i = 0; i < depths.length; i++) {
            depths[i] = 0;
        }
        for (int i = 0; i < parent.length; i++) {
            findDepth(parent,i,depths);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < depths.length; i++) {
            if(max<depths[i]){
                max= depths[i];
            }
        }
        return max+"";
    }

    private static void findDepth(int[] parent, int i, int[] depths) {
        if(depths[i]!=0){
            return;
        }
        if(parent[i]==-1){
            depths[i] = 1;
            return;
        }
        if(depths[parent[i]]==0){
            findDepth(parent,parent[i],depths);
        }
        depths[i] = depths[parent[i]] + 1;
    }
}
