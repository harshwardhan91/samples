package com.local;

/**
 * Created by harsh on 2/9/17.
 */
public class CountInversionsInArray {

    //sorting is necessary here


    static  int invertCount =0;
    static void merge(int[] arr,int low,int mid,int high){
        int i,j;
     for(i=low,j=mid+1;i<=mid && j<=high;){
         if(arr[i]>arr[j]){
             invertCount++;
         }
         if(arr[i]<arr[j]){
             i++;
         }else{
             j++;
         }
     }
     if(j>high){j=high;i++;}
     if(i>mid){i=mid;j++;}
     if(i<mid+1 && j==high){
         while(i<=mid){
             if(arr[i]>arr[j]){
                 invertCount++;
             }
             i++;
         }
     }else if(j<high+1&& i ==mid){
         while(j<=high){
             if(arr[i]>arr[j]){
                 invertCount++;
             }
             j++;
         }
     }
    }

    static void merge1(int[] arr,int low,int mid,int high,int[] tmp){
        int i =low;
        int j=mid;
        int k = low;
        while(i<mid && j<=high){
            if(arr[i]<arr[j]){
                tmp[k++] = tmp[i++];
            }else{
                tmp[k++] = tmp[j++];
                invertCount += mid -i;
            }
        }
        while(i<mid){
            tmp[k++] = tmp[i++];
        }
        while ((j<=high)){
            tmp[k++] = tmp[j++];
        }
        for (i=low ; i <= high; i++)
            arr[i] = tmp[i];
    }







    static void countInvert(int[] arr, int low, int high, int[] tmp){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        countInvert(arr,low,mid, tmp);
        countInvert(arr,mid+1,high, tmp);
        merge1(arr,low,mid,high,tmp);
    }



    public static void main(String[] args) {
        int[] p = {2,4,1,3,5};
        int[] ar = {1, 20, 6, 4, 5};
        int[] tmp = new int[ar.length];
        countInvert(p,0,p.length-1,tmp);
        System.out.println(invertCount);
        invertCount=0;
        tmp = new int[ar.length];
        countInvert(ar,0,ar.length-1,tmp);
        System.out.println(invertCount);
    }
}
