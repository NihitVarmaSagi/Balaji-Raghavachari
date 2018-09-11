package com.company;

public class BoundedQueue<T> {

    Object[] array;
    int start; int end;
    int length; private int size;

    BoundedQueue(int length){
        this.length = length;
        array = new Object[length];
        start = 0;
        end = -1;
    }

    public boolean offer(T x){
        if(size<length){
            array[(++end)%length] = x;
            size++;
            return true;
        }
        return false;
    }

    public T poll(){
        if(start!=end){
            T temp = (T)array[(start)%length];
            start = start+1;
            size--;
            return temp;
        }
        return null;
    }

    public T peek(){
        if(size==0){
            return null;
        }
        return (T)array[(start)%length];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(start==end || end==-1){
            return true;
        }
        return false;
    }

    public void clear(){
        size=0;
        start=0;
        end=-1;
    }

    public void toArray(T[] a){
        int length = a.length; int i=0;
        for(Object item:array){
            if(i<length){
                a[i] = (T)item;
            }
        }
    }

    public static void main(String[] args){
        BoundedQueue<String> queue = new BoundedQueue(5);
//        queue.offer("venkata");
//        queue.offer("santosh");
//        queue.offer("nihit");
          queue.offer("varma");
          queue.offer("sagi");
//          System.out.println(queue.offer("sivasai"));
          System.out.println(queue.peek());
//        System.out.println(queue.offer("sivasai"));
//        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
        queue.clear();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
    }


}
