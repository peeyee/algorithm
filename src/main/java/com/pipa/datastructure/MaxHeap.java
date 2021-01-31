package com.pipa.datastructure;

public class MaxHeap<Key extends Comparable<Key>> {

    //最后一个元素的位置，数据存储于1..N中
    private int N = 0;
    private Key[] heap;

    public MaxHeap(int size) {
        heap = (Key[]) new Comparable[size+1];
    }

    public int size()
    {
        return this.N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void insertKey(Key key)
    {
        heap[++N] = key;
        //在尾部追加，然后上浮到合适的位置
        swim(N);
    }

    public Key delMax()
    {
        Key max = heap[1];
        swap(N,1);
        sink(1);
        N--;
        return max;
    }

    /**
     * 将第k个元素下沉到合适的位置
     */
    private void sink(int i) {
        //在一个完全2叉树中，第i个节点的左右儿子的位置分别是2i,2i+1
        while(2*i <= N)
        {
            int k = max(2*i,2*i + 1);
            if(heap[i].compareTo(heap[k]) < 0)
            {
                swap(i,k);
                i = k;
            }else {
                break;
            }
        }
    }

    private int max(int k1,int k2) {
        if(k2 > N){ return k1;}
        if(k1 > N){ return k2;}
        return heap[k1].compareTo(heap[k2]) < 0 ? k2 : k1;
    }

    //将第k个元素上升到合适的位置
    private void swim(int k) {
        //和它的父元素比较
        while(k > 1 && heap[k].compareTo(heap[k/2]) > 0)
        {
            swap(k,k/2);
            k = k / 2;
        }
    }

    private void swap(int i, int j)
    {
        Key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(11);
        for (int i = 0; i < 10; i++) {
            int k = (int) (Math.random()*1000);
            maxHeap.insertKey(k);
        }
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.delMax());
        }
    }

}
