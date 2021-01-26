package com.pipa.sort;

/**
 * purpose:
 * author: hwf
 * created: 2021/1/26
 */
public class MergeSort{
    private static int[] temp;

    public static void sort(int[] array) {
        temp = new int[array.length];
        mergeSort(array,0,array.length - 1);
    }

    private static void merge(int[] a, int i, int mid, int j) {
        if(i == j)
            return;
        //左数组指针
        int left = i;
        //右数组指针
        int right = mid + 1;
        //左右部分数据都已经有序了,排序只要依次比较两个数组最左侧的值
        for (int k = i; k <= j; k++) {
            if(left > mid){
                temp[k] = a[right];
                right++;
                continue;
            }
            if(right > j){
                temp[k] = a[left];
                left++;
                continue;
            }
            if(a[left] <= a[right]){
                temp[k] = a[left];
                left ++;
            }else {
                temp[k] = a[right];
                right++;
            }
        }

        for (int k = i; k <= j; k++) {
            a[k] = temp[k];
        }
    }

    private static void mergeSort(int[] a, int i, int j) {
        if( i == j)
            return;
        int mid = (j - i ) / 2 + i;
        mergeSort(a,i,mid);
        mergeSort(a,mid + 1, j);
        merge(a,i,mid,j);
    }

    public static void main(String[] args) {
        final int SIZE = 10000000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        sort(input);
        Long endTime = System.currentTimeMillis();
        Long consume = endTime - startTime;
        boolean isOrdered = true;
        int i = 0;
        while (isOrdered && i < input.length - 1){
            if(input[i+1] < input[i]){
                isOrdered = false;
            }
            i++;
        }
        System.out.println("is ordered?: " + isOrdered);
        System.out.println("quick sort consume: "+consume + " ms");
    }

}
