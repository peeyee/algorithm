package com.pipa.sort;


public class Sorter {
    public static void main(String[] args) {
        final int SIZE = 100;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        insertSort(input);
        Long endTime = System.currentTimeMillis();

    }

    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++) {

            int position = findPosition(a,i);

            insert(a,i,position);
        }
    }


    private static void insert(int[] a,int source,int target) {
        int temp = a[source];
        for(int i = source - 1; i >= target; i--)
        {
            a[i+1] = a[i];
        }
        a[target] = temp;
    }

    private static int findPosition(int[] a, int i) {
        int left = i - 1;
        while(left >= 0 && a[i] < a[left]){
            left--;
        }
        return left + 1;
    }
}
