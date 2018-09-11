package com.company;
import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;



public class SinglyLinkedList<T> implements Iterable<T> {

    Entry<T> head, tail;
    int size;

    public static class Entry<E>{
        E element;
        Entry<E> next;

        Entry(E x, Entry<E> nxt){
            this.element = x;
            this.next = nxt;
        }
    }

    SinglyLinkedList(){
        this.head = new Entry(null,null);
        this.tail = head;
        size = 0;
    }


    public Iterator<T> iterator(){ return new SLLIterator();}


    protected class SLLIterator implements Iterator<T>{
        Entry<T> cursor, prev;
        boolean readynext;

        SLLIterator(){
            cursor = head;
            prev = null;
            readynext = false;
        }

        public boolean hasNext(){ return cursor.next!=null;}

        public T next(){
            readynext = true;
            prev = cursor;
            cursor = cursor.next;
            return cursor.element;
        }

        public void remove(){
            if(!readynext){
                throw new NoSuchElementException();
            }
            prev.next = cursor.next;
            if(cursor==tail){
                tail = prev;
            }
            cursor = prev;
            readynext = false;
            size--;
        }
    }

    public void add(T elementToAdd){
        add(new Entry<>(elementToAdd,null));
    }

    public void add(Entry<T> ent){
        tail.next = ent;
        tail = tail.next;
        size++;
    }

    public void print(){
        System.out.println(this.size+" :");
        for(T item:this){
            System.out.print(item+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int n = 10;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for(int i=0;i<n;i++){
            list.add(Integer.valueOf(i));
        }
        list.print();


        Iterator<Integer> it = list.iterator();
        Scanner in = new Scanner(System.in);
        whileloop:
        while(in.hasNext()) {
            int com = in.nextInt();
            switch(com) {
                case 1:  // Move to next element and print it
                    if (it.hasNext()) {
                        System.out.println(it.next());
                    } else {
                        break whileloop;
                    }
                    break;
                case 2:  // Remove element
                    it.remove();
                    list.print();
                    break;
                default:  // Exit loop
                    break whileloop;
            }
        }

    }

}
