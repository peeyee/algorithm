package com.pipa.sort;


public class InsertSort {
    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        boolean isOrdered = false;
        insertSort(input);
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
     * insert the element to the right position for each round.
     * @param a
     */
    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            //find the position to put the element
            int position = findPosition(a,i);
            //insert the element
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
