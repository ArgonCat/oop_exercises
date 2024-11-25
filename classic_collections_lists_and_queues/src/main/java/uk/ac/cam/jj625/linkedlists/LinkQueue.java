package uk.ac.cam.jj625.linkedlists;

import java.util.NoSuchElementException;

public class LinkQueue<T> implements OopQueue<T>{
    private LinkList<T> in;
    private LinkList<T> out;

    public LinkQueue() {
        in = new LinkList<>();
        out = new LinkList<>();
    }

    @Override
    public void push(T obj) {
        in.addFirst(obj);
    }

    @Override
    public T pop() {
        try{
            return out.removeFirst();
        } catch (NoSuchElementException e) {
            out = in;
            in = new LinkList<>();
            out.reverse();
            return out.removeFirst();
        }
    }
}
