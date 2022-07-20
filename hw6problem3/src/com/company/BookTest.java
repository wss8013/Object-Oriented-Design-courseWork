package com.company;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

public class BookTest {

  @Test
  public void getTitle() {
  }

  @Test
  public void getAuthor() {
  }

  @Test
  public void equals(){
    Book book1 = new Book("","",new Date(0),10.00);
    Book book2 = new Book("","",new Date(0),10.00);
    assertTrue(book1.equals(book2));

  }
}