package com.pipa.sort;

/**
 * 单边循环法
 * L组：左元组，小于主元pivot的组，其元素称为左元
 * R组：右元组，大于等于主元pivot的组，其元素称为右元
 * U组：未遍历的组
 * L|R|U 从左至右组成了整个数组，初始时候 L=R={}
 * U=整个数组，假定主元选在最左侧，如果扫到右元则继续；
 * 如果扫到一个左元，则于右元组最左侧的元素交换位置，
 * 且L，R之间的界限mark向右移动一位，扫描完成后，交换
 * pivot和mark所指元素的位置，这样pivot左边的都是左元，
 * pivot右边的都是右元，然后递归的排序左元组和右元组
 * author: hwf
 * created: 2021/1/25
 */
public class QuickSort1 {
    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        quickSort(input);
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

    public static void quickSort(int[] input){
        quickSort(input,0,input.length - 1);
    }

    private static void quickSort(int[] input, int left, int right) {
        if(left >= right){return;}
        //找到主元的位置，并且使得两侧部分有序
        int pivotIndex = partition(input,left,right);
        //递归地排序左边和右边
        quickSort(input,left,pivotIndex - 1);
        quickSort(input,pivotIndex + 1, right);
    }


    private static int partition(int[] a, int i, int j) {
        int pivotIndex = i;
        int pivot = a[pivotIndex];
        //L,R的界限标记,L组的最右边那个
        int mark = i;
        for (int k = i + 1; k <= j; k++) {
            //找到一个右元，继续
            if(a[k] >= pivot){
                continue;
            }// 找到一个左元交换它与R最左边元素的位置，mark右移
            else {
                swap(a,k,mark+1);
                mark++;
            }
        }
        //扫描完成后交换mark位置元素与pivot的位置，使得数组变成L|pivot|R的形式
        swap(a,pivotIndex,mark);
        return mark;
    }

    private static void swap(int[] a, int i, int j) {
        if (i==j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
