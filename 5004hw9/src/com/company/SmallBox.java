package com.company;

public class SmallBox extends Box<SmallItem> {

  public SmallBox(int size){
    super(size);
  }
  @Override
  boolean put(SmallItem item) {
    if (item.getSize() > this.availableSpace()) {
      return false;
    }
    items.add(item);
    this.usedSpace += item.getSize();
    return true;
  }

  @Override
  boolean remove(SmallItem item) {
    if (!items.contains(item)) {
      return false;
    }
    items.remove(item);
    this.usedSpace -= item.size;
    return true;
  }
}
