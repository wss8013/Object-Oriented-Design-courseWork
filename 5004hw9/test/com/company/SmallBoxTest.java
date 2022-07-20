package com.company;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SmallBoxTest {
  @Test
  public void put() {
    SmallBox smallBox = new SmallBox(10);
    SmallBox smallBox2 = new SmallBox(10);
    SmallItem smallItem1 = new SmallItem("item1", 3);
    SmallItem smallItem2 = new SmallItem("item2", 3);
    SmallItem smallItem3 = new SmallItem("item3", 3);
    SmallItem smallItem4 = new SmallItem("item4", 3);
    assertEquals(smallBox.getItems().size(), 0);
    assertEquals(smallBox.getSize(), 10);
    assertEquals(smallBox.numberOfItems(), 0);
    assertEquals(smallBox.usedSpace(), 0);
    assertEquals(smallBox.availableSpace(), 10);
    assertEquals(smallBox.compareTo(smallBox2), 0);
    assertTrue(smallBox.put(smallItem1));
    assertTrue(smallBox.put(smallItem2));
    assertEquals(smallBox.getItems().size(), 2);
    assertEquals(smallBox.numberOfItems(), 2);
    assertEquals(smallBox.usedSpace(), 6);
    assertEquals(smallBox.availableSpace(), 4);
    assertEquals(smallBox.compareTo(smallBox2), 6);
    assertTrue(smallBox.put(smallItem3));
    assertFalse(smallBox.put(smallItem4));
    assertEquals(smallBox.getItems().size(), 3);
    assertEquals(smallBox.numberOfItems(), 3);
    assertEquals(smallBox.usedSpace(), 9);
    assertEquals(smallBox.availableSpace(), 1);
    assertEquals(smallBox.compareTo(smallBox2), 9);
  }

  @Test
  public void remove() {
    SmallBox smallBox = new SmallBox(10);
    SmallBox smallBox2 = new SmallBox(10);
    SmallItem smallItem1 = new SmallItem("item1", 3);
    SmallItem smallItem2 = new SmallItem("item2", 3);
    SmallItem smallItem3 = new SmallItem("item3", 3);
    SmallItem smallItem4 = new SmallItem("item4", 3);
    assertTrue(smallBox.put(smallItem1));
    assertTrue(smallBox.put(smallItem1));
    assertTrue(smallBox.put(smallItem1));
    assertTrue(smallBox.remove(smallItem1));
    assertEquals(smallBox.usedSpace(),6);
    assertTrue(smallBox.remove(smallItem1));
    assertEquals(smallBox.usedSpace(),3);
    assertFalse(smallBox.remove(smallItem2));
  }
}
