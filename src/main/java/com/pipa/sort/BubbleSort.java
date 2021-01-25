package com.pipa.sort;

/**
 * purpose:
 * author: hwf
 * created: 2021/1/25
 */
public class BubbleSort {

    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        boolean isOrdered = false;
        bubbleSort(input);
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
     * let the element goes up to right position
     * @param a
     */
    public static void bubbleSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int current = i;
            while(current > 0 && a[current] < a[current-1]){
                swap(a,current,current-1);
                current--;
            }
        }
    }

    private static void swap(int[]a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
