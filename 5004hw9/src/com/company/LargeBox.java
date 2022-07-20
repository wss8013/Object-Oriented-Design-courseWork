package com.company;

public class LargeBox extends Box<Item>{

  public LargeBox(int size) {
    super(size);
  }

  @Override
  boolean put(Item item) {
    if (item.getSize() > this.availableSpace()) {
      return false;
    }
    items.add(item);
    this.usedSpace += item.getSize();
    return true;
  }

  @Override
  boolean remove(Item item) {
    if (!items.contains(item)) {
      return false;
    }
    items.remove(item);
    this.usedSpace -= item.size;
    return true;
  }
}
