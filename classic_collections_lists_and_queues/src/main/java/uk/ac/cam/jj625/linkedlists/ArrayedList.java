package uk.ac.cam.jj625.linkedlists;

import java.io.ObjectStreamException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayedList<T> implements OopList<T>{
    private Object[] arr;
    private int length;

    public ArrayedList() {
        arr = new Object[0];
        length = 0;
    }
    public ArrayedList(int l) {
        arr = new Object[l];
        length = l;
    }

    public ArrayedList(T[] elements) {
        arr = elements.clone();
        length = elements.length;
    }

    @Override
    public void addFirst(T element) {
        // This runs in O(n) time, because they wanted the first item, which is bad for arrays.
        // Bit confused as to why I wasn't asked to implement the equivalent for the end of the array, which would be O(logn)
        // Maybe I could've implemented the array backward? That'd mean this op is O(logn)
        if (length == 0) {
            arr = new Object[1];
        } else if(arr.length == length) {
            Object[] narr = new Object[length*2];
            System.arraycopy(arr, 0, narr, 1, length);
            arr = narr;
        } else {
            Object[] narr = new Object[arr.length];
            System.arraycopy(arr, 0, narr, 1, length);
            arr = narr;
        }
        arr[0] = element;
        length++;
    }

    @Override
    public T removeFirst() {
        if(length == 0) {
            throw(new NoSuchElementException());
        } else {
            T first = (T) arr[0];
            length--;

            for(int i = 0; i<length; i++) {
                arr[i] = arr[i+1];
            }

            return first;
        }
    }

    @Override
    public T get(int n) {
        if(length <= n) {
            throw(new NoSuchElementException());
        } else {
            return (T) arr[n];
        }
    }

    @Override
    public int length() {
        return length;
    }

    public static <T> ArrayedList<T> create(T[] elements) {
        return new ArrayedList<>(elements);
    }

    public void reverse() {
        var narr = new Object[arr.length];
        for(int i = 0; i<length; i++) {
            narr[length-i-1] = arr[i];
        }
        arr = narr;
    }

    @Override
    public String toString() {
        if(length == 0) { return "[]"; }
        StringBuilder s = new StringBuilder("[");

        for(int i = 0; i<length-1; i++) {
            s.append(arr[i].toString()).append(",");
        }
        s.append(arr[length-1].toString());
        s.append("]");
        return s.toString();
    }
}
