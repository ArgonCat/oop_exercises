package uk.ac.cam.jj625.linkedlists;

public interface OopList<T> {
    void addFirst(T element);
    T removeFirst();
    T get(int n);
    int length();
}
