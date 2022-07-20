package com.company;

public class Item {

  protected String name;
  protected int size;

  public Item(String name, int size) {
    setName(name);
    setSize(size);
  }

  public int getSize() {
    return size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSize(int size) {
    if (size < 0) {
      throw new IllegalArgumentException();
    }
    this.size = size;
  }

}
