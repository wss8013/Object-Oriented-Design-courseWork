package com.company;

import java.util.ArrayList;

public abstract class Box<T> implements Comparable<Box> {

  protected int size;
  protected int usedSpace;
  protected ArrayList<T> items;

  public Box(int size) {
    this.size = size;
    items = new ArrayList<>();
    usedSpace = 0;
  }

  public ArrayList<T> getItems() {
    return new ArrayList<>(items);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size){this.size = size;}

  public void setItems(ArrayList<T> item){this.items = new ArrayList<>(item);}

  abstract boolean put(T item);

  abstract boolean remove(T item);

  int availableSpace() {
    return size - usedSpace;
  }

  int usedSpace() {
    return usedSpace;
  }

  int numberOfItems() {
    return items.size();
  }

  @Override
  public int compareTo(Box other) {
    if (other == null) {
      throw new IllegalArgumentException();
    }
    if (other.usedSpace() != this.usedSpace()) {
      return this.usedSpace() -  other.usedSpace();
    }
    return this.numberOfItems() - other.numberOfItems();
  }
}
