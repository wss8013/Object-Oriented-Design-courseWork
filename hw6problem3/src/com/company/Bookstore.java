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
public class Bookstore {

  private String name;
  private String address;
  private Book[] books;
  private int bookStored;

  // constructor
  public Bookstore(String name, String address) {
    setName(name);
    setAddress(address);
    books = new Book[1000];
    bookStored = 0;
  }

  public Bookstore(String name, String address, Book[] books) {
    setName(name);
    setAddress(address);
    setBooks(books);
  }

  // getter method
  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public Book[] getBooks() {
    return this.books;
  }

  // setter method
  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setBooks(Book[] books) {
    this.books = new Book[1000];
    bookStored = 0;
    for (int i = 0; i < Math.min(books.length, 1000); i++) {
      if (books[i] != null) {
        this.books[bookStored] = books[i];
        bookStored++;
      }
    }
  }

  // get more copies of books
  public boolean importBook(Book book, int amount) {
    if (amount + bookStored > 1000 || book == null) {
      System.out.println(" not enough room to store " + amount + " books or the book is invalid");
      return false;
    }
    int j = amount;
    for (int i = 0; i < 1000; i++) {
      if (j == 0) {
        break;
      }
      if (books[i] == null) {
        books[i] = new Book(book);
        bookStored++;
        j--;
      }
    }
    return true;
  }

  // search with title to find the book in store or not
  public boolean searchTitle(String title) {
    if (title == null) {
      return false;
    }
    for (int i = 0; i < 1000; i++) {
      if (books[i] != null && books[i].getTitle().equals(title)) {
        return true;
      }
    }
    return false;
  }

  //Removing all the copies of one specific book from list
  public void removeBook(Book book) {
    if (book == null) {
      return;
    }
    for (int i = 0; i < 1000; i++) {
      if (books[i] != null && books[i].equals(book)) {
        books[i] = null;
        bookStored--;
      }
    }
  }

  //Get the amount of copies of specific book title
  public int getCopyNum(String title) {
    int numOfCopy = 0;
    for (int i = 0; i < 1000; i++) {
      if (books[i] != null && books[i].getTitle().equals(title)) {
        numOfCopy++;
      }
    }
    return numOfCopy;
  }

  //Get and print all the books in the book list
  public void display() {
    System.out.println("The stored books are: \n");
    for (int i = 0; i < 1000; i++) {
      if (books[i] != null) {
        System.out.println(books[i].toString() + "\n");
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("======================test book=======================");
    Date date = new Date(1577865600000L);
    System.out.println(date);
    Book book1 = new Book("The sky", "Tom", date, 10.0);
    Book book2 = new Book("The sun", "Jerry", date, 19.99);
    System.out.println(book1);
    System.out.println(book2);
    Book book1copy = new Book("The sky", "Tom", date, 10.0);
    System.out.println(book1.equals(book1copy));
    System.out.println(book1.equals(book2));

    System.out.println("================test bookstore==================");
    Book[] books = {book1, book2};
    Bookstore bookstore1 = new Bookstore("apple", "a123", books);
    Bookstore bookstore2 = new Bookstore("banana", "b456");
    Bookstore bookstore2copy = new Bookstore("banana", "b456");
    bookstore1.display();
    //bookstore2.display();
    //bookstore2copy.display();
    System.out.println(bookstore1.equals(bookstore2));
    System.out.println(bookstore2.equals(bookstore2copy));
    bookstore1.importBook(book1, 10);
    System.out.println(bookstore1.getCopyNum("The sky"));
    bookstore1.removeBook(book2);
    bookstore1.display();
    System.out.println(bookstore1.searchTitle("pear"));
    System.out.println(bookstore1.searchTitle("The sky"));

  }
}