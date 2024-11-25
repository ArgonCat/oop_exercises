/*
 * Copyright 2024 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, J. Jinkinson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jj625.linkedlists;

import java.util.NoSuchElementException;

public class LinkList<T> implements OopList<T> {

  public static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }

    Node(T value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }
  }

  private Node<T> head;

  LinkList() {
    this.head = null;
  }

  public void addFirst(T element) {
    if (head == null) {
      head = new Node<T>(element);
    } else {
      head = new Node<T>(element, head);
    }
  }

  public T removeFirst() {
    if (this.head == null) {
      throw new NoSuchElementException();
    } else {
      Node<T> ohead = this.head;
      this.head = ohead.next;
      return ohead.value;
    }
  }

  public T get(int n) {
    Node<T> a = this.head;
    if( a == null) {
      throw new NoSuchElementException();
    }
    for (int i = 0; i<n; i++) {
      if( a.next == null) {
        throw new NoSuchElementException();
      }
      a = a.next;
    }
    return a.value;
  }

  public int length() {
    Node<T> a = this.head;
    if (this.head == null) { return 0; }
    else {
      int l = 1;
      while(a.next != null) {
        a = a.next;
        l++;
      }
      return l;
    }
  }

  public static <T> LinkList<T> create(  T[] elements ) {
    var linkList = new LinkList<T>();
    for(int i = 0; i<elements.length; i++) {
        linkList.addFirst(elements[elements.length-i-1]);
    }
    return linkList;
  }

  public void reverse() {
    Node<T> prev = null;
    Node<T> current = head;
    while(current != null) {
      Node<T> next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}
