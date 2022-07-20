package com.company;

import java.util.Date;
/**
 * Problem3 [30 pts]
 * Let's design a class "Book", it has title, author, publishing date and price.
 * - You should provide constructors, setters and getters, equals() and toString().
 * Then, design a Bookstore class. Bookstore has name, address, and a list of books.
 * For simplicity, assume 1000 as the maximum number of books a bookstore can store.
 * Design following methods:
 *    > The bookstore tries to get more number of copies of one book, this method takes in two parameters: the book and the amount of copies to import
 *    > The bookstore can search with title to find the book in store or not, return type: boolean
 *    > Removing all the copies of one specific book from list
 *    > Get the amount of copies of specific book title, return type: int
 *    > Get and print all the books in the book list
 */
public class Book {

  private String title;
  private String author;
  private Date publishingDate;
  private double price;

  // constructor
  public Book(String title, String author, Date publishingDate, double price) {
    setAuthor(author);
    setTitle(title);
    setPublishingDate(publishingDate);
    setPrice(price);
  }

  // copy of a constructor
  public Book(Book book) {
    if (book == null) {
      System.out.println("Cannot copy null object");
      System.exit(1);
    }
    setAuthor(book.author);
    setTitle(book.title);
    setPublishingDate(book.publishingDate);
    setPrice(book.price);

  }

  // getter method
  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public Date getPublishingDate() {
    return new Date(this.publishingDate.getTime());
  }

  public double getPrice() {
    return this.price;
  }

  // setter method
  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublishingDate(Date publishingDate) {
    this.publishingDate = new Date(publishingDate.getTime());
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // equals method
  public boolean equals(Book b) {
    return b != null && this.title.equals(b.title) && this.author.equals(b.author)
        && this.publishingDate.equals(b.publishingDate) && this.price == b.price;
  }

  // toString method
  public String toString() {
    return "Book title is " + title + ", author is " + author + ", publishing date is "
        + publishingDate.toString() + ", price is " + price;
  }




}

