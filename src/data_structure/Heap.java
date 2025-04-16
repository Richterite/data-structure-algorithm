package data_structure;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap;


    public Heap(){
        this.heap = new ArrayList<>();
    }

    public ArrayList<Integer> getHeap(){
        return new ArrayList<Integer>(this.heap);
    }

    private int leftChildIdx(int index){
        return  2 * index + 1;
    }

    private  int rightChildIdx(int index){
        return 2* index + 2;
    }

    private int parentIdx(int index){
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2){
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    private void sinkDown(int index){
        int maxIndex = index;
        while (true){
            int leftIndex = leftChildIdx(index);
            int rightIndex = rightChildIdx(index);

            if (leftIndex < this.heap.size() && heap.get(leftIndex) > this.heap.get(maxIndex)){
                maxIndex = leftIndex;
            }

            if (rightIndex < this.heap.size() && heap.get(rightIndex) > this.heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            if (maxIndex !=  index){
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public void insert(int value){
        heap.add(value);
        int currentIdx = this.heap.size() - 1;

        while (currentIdx > 0 && this.heap.get(currentIdx) > heap.get(parentIdx(currentIdx)) ) {
            swap(currentIdx, this.parentIdx(currentIdx));
            currentIdx = parentIdx(currentIdx);
        }
    }

    public Integer remove(){
        if (this.heap.isEmpty()) return  null;
        if (this.heap.size() == 1) return this.heap.remove(0);

        int maxValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(heap.size() - 1 ));
        this.sinkDown(0);

        return maxValue;
    }



}
