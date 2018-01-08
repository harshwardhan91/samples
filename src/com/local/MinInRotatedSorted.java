package com.local;

/**
 * Created by harsh on 2/9/17.
 */
/*
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.

Examples

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1
*/

public class MinInRotatedSorted {
    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low) {
            System.out.println(" got this case " + arr.toString());
            return arr[0];}

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }









    static int findMin2(int[] arr,int low,int high){
        if(high<low) return arr[low];
        if(high==low) return arr[low];
        int mid = (low+high)/2;

        if(mid>0&&arr[mid]<arr[mid-1]){
            return arr[mid];
        }
        if(mid<arr.length-1&&arr[mid]>arr[mid+1]){
            return arr[mid+1];
        }
        if(arr[mid]<arr[high]){
            return findMin2(arr,low,mid-1);
        }else{
            return findMin2(arr,mid+1,high);
        }
    }



    public static void main(String[] args) {
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMin(arr1, 0, n1-1));
        System.out.println("The minimum element is "+ findMin2(arr1, 0, n1-1));

        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMin(arr2, 0, n2-1));
        System.out.println("The minimum element is "+ findMin2(arr2, 0, n2-1));

        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ findMin(arr3, 0, n3-1));
        System.out.println("The minimum element is "+ findMin2(arr3, 0, n3-1));

        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMin(arr4, 0, n4-1));
        System.out.println("The minimum element is "+ findMin2(arr4, 0, n4-1));
        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMin(arr5, 0, n5-1));
        System.out.println("The minimum element is "+ findMin2(arr5, 0, n5-1));

        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMin(arr6, 0, n1-1));
        System.out.println("The minimum element is "+ findMin2(arr6, 0, n1-1));

        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMin(arr7, 0, n7-1));
        System.out.println("The minimum element is "+ findMin2(arr7, 0, n7-1));

        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMin(arr8, 0, n8-1));
        System.out.println("The minimum element is "+ findMin2(arr8, 0, n8-1));

        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMin(arr9, 0, n9-1));
        System.out.println("The minimum element is "+ findMin2(arr9, 0, n9-1));


    }
}
