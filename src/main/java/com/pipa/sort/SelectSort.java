package com.pipa.sort;

/**
 * purpose:
 * author: hwf
 * created: 2021/1/25
 */
public class SelectSort {
    public static void main(String[] args) {
        final int SIZE = 10000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        boolean isOrdered = false;
        selectSort(input);
        for (int i = 0; i < input.length - 1; i++) {
            if(input[i+1] < input[i]){
                break;
            }
            isOrdered = true;
        }
        Long endTime = System.currentTimeMillis();
        Long consume = endTime - startTime;
        System.out.println("is ordered?: " + isOrdered);
        System.out.printf("bubble sort consume: "+consume + " ms");
    }

    /**
     * select the minimum value at each round.
     * @param input
     */
    public static void selectSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int minimum = input[i];
            int minimum_index = i;
            for (int j = i; j < input.length; j++) {
                if(input[j] < minimum){
                    minimum = input[j];
                    minimum_index = j;
                }
            }
            if(i != minimum_index)
                swap(input,i,minimum_index);
        }
    }

    private static void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
