package com.pipa.sort;

/**
 * The quick sort algorithm realizes sorting by multiple comparisons and exchanges
 *
 * (1) First, set a boundary value, through which the array is divided into two parts.
 *
 * (2) The data greater than or equal to the boundary value is set to the right of the
 * array,and the data less than the boundary value is set to the left of the array. At
 * this time,the elements in the left part are less than or equal to the boundary value,
 * while the elements in the right part are greater than or equal to the boundary value.
 *
 * (3) Then, the data on the left and right can be sorted independently. For the array
 * data on the left, you can also take a boundary value to divide the data into two parts:
 * left and right. Similarly, you can place smaller values on the left and larger values
 * on the right. The array data on the right can be processed similarly.
 *
 * (4) Repeat the above process, you can see that this is a recursive definition.After
 * the left part is sorted recursively, the right part is sorted recursively.When the
 * data of the left and right parts are sorted, the sorting of the whole array
 * is completed.
 * author: hwf
 * created: 2021/1/25
 */
public class QuickSort2 {
    public static void main(String[] args) {
        final int SIZE = 10000;
        int[] input = new int[SIZE];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random()*10000);
        }
        Long startTime = System.currentTimeMillis();
        boolean isOrdered = false;
        quickSort(input);
        for (int i = 0; i < input.length - 1; i++) {
            if(input[i+1] < input[i]){
                break;
            }
            isOrdered = true;
        }
        Long endTime = System.currentTimeMillis();
        Long consume = endTime - startTime;
        System.out.println("is ordered?: " + isOrdered);
        System.out.printf("quick sort consume: "+consume + " ms");
    }

    private static void quickSort(int[] input) {
        quickSort(input,0,input.length - 1);
    }



    private static void quickSort(int[] input, int left, int right) {
        if(left >= right)
            return;

        int pivotIndex = partition(input,left,right);
        quickSort(input,left,pivotIndex);
        quickSort(input,pivotIndex + 1,right);

    }

    //双边循环法
    private static int partition(int[] input, int startIndex, int endIndex){
        int left = startIndex;
        //基准元素选在最左侧
        int pivotIndex = startIndex;
        int pivot = input[pivotIndex];
        int right = endIndex;
        while (left < right)
        {
            //找到一个比pivot小的元素
            while (left < right && input[right] >= pivot) {
                right--;
            }

            //找到一个比pivot大的元素
            while (left < right && input[left] <= pivot) {
                left++;
            }

            //交换两个元素的位置
            swap(input,left,right);
        }
        //把基准元素交换到中介处
        swap(input,pivotIndex,left);
        return left;
    }


    private static void swap(int[] a, int i, int j) {
        if (i==j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
