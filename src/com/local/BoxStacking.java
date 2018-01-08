package com.local;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {
    static class Box{
        int h;
        int w;
        int d;
        int a1;
        int a2;
        int a3;

        public Box() {
        }

        public Box(int l, int b, int h) {
            this.h = l;
            this.w = b;
            this.d = h;
            a1 = l*b;
            a2 = b*h;
            a3 = l*h;
        }
        int getBaseArea(){
            return d * w;
        }
        public int getMaxBaseArea() {

            int t;
            if(a1>a2 && a1>a3){
                return a1;
            }else if(a2>a1 && a2>a3){
                 t = h;
                 h = d;
                 d = t;
                return a2;
            }else{
                t = w;
                w = d;
                d = t;
                return a3;
            }
        }

        @Override
        public String toString() {
            return "Box{" +
                    "h=" + h +
                    ", w=" + w +
                    ", d=" + d +
                    ",a=" + w * d +
                    "}";
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32}};
        Box[] boxes = new Box[arr.length*3];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            boxes[index] = new Box(arr[i][0],arr[i][1],arr[i][2]);
            index++;

            boxes[index] = new Box();
            boxes[index].h = arr[i][1];
            boxes[index].d = Utils.max(arr[i][0], arr[i][2]);
            boxes[index].w = Utils.min(arr[i][0], arr[i][1]);
            index++;

            boxes[index] = new Box();
            boxes[index].h = arr[i][2];
            boxes[index].d = Utils.max(arr[i][0], arr[i][1]);
            boxes[index].w = Utils.min(arr[i][0], arr[i][1]);
            index++;
        }
//        for (int i = 0; i < boxes.length; i++) {
//            System.out.println(boxes[i]);
//        }
        System.out.println();
        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return -Integer.compare(o1.d * o1.w,o2.d *o2.w);
            }
        });
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(boxes[i]);
        }
        System.out.println();
        System.out.println(LDS(boxes));
    }

    private static int LDS(Box[] boxes) {
        int[] lds = new int[boxes.length];
        for (int i = 0; i < lds.length; i++) {
            lds[i] = boxes[i].h;
        }
        for(int i = 1;i<lds.length;i++){
            for (int j = 0; j < i; j++) {
                if(boxes[i].w <boxes[j].w && boxes[i].d < boxes[j].d){
                    if(lds[i] < lds[j] + boxes[i].h){
                        lds[i] = lds[j] + boxes[i].h;
                    }
                }
            }
        }
//        for (int i = 0; i < lds.length; i++) {
//            System.out.println(lds[i]);
//        }
        int max = lds[0];
        for (int i = 1; i < lds.length; i++) {
            if(max<lds[i]){
                max = lds[i];
            }
        }
        return max;
    }
}
