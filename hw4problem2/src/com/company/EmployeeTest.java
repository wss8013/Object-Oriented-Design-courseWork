package com.company;
/**
 * Problem 2 [40pts]
 * Create a class Employee that includes the following instance variables
 * • First name (String) cannot be empty,
 * • Last name (String) cannot be empty,
 * • Monthly salary (double) must be non-negative.
 * Provide a set and a get method for each instance variable. The setters must return boolean
 * and perform validation. If the monthly salary is not positive, set its value to zero. If a name is
 * empty set it to “[empty]”.
 * Provide a constructor that initializes the three instance variables.
 * No default constructor is required. Also, overwrite equals() and toString(). Write a
 * test class named EmployeeTest that demonstrates class Employee’s capabilities. Create two
 * different Employee objects. Use println() to display information about each employee (this
 * will invoke toString()). Then compare the two using equals() and display the result.
 * Submission format: You MUST define TWO classes. One is Employee which must be declared
 * as a non-public class. Two is EmployeeTest which is public and contains the main()
 * method. So, you must submit one file EmployeeTest.java containing the above two classes.
 * The tests must be performed in the main() method.
 */
// class declaration
public class EmployeeTest {

  public static void main(String[] args) {
    Employee a = new Employee("", "", -10000);
    Employee b = new Employee("shasha", "wang", 12300);
    System.out.println(a.toString());
    System.out.println(b.toString());
    System.out.println(a.equals(b));
  }

}

class Employee {

  private String firstName;
  private String lastName;
  private double salary;

  // constructor declaration of class
  public Employee(String firstName, String lastName, double salary) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setSalary(salary);
  }

  // getter method
  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public double getSalary() {
    return this.salary;
  }

  // setter method
  public boolean setFirstName(String firstName) {
    if (firstName.isEmpty()) {
      this.firstName = "[empty]";
      return false;
    } else {
      this.firstName = firstName;
      return true;
    }
  }

  public boolean setLastName(String lastName) {
    if (lastName.isEmpty()) {
      this.lastName = "[empty]";
      return false;
    } else {
      this.lastName = lastName;
      return true;
    }
  }

  public boolean setSalary(double salary) {
    if (salary < 0) {
      this.salary = 0;
      return false;
    } else {
      this.salary = salary;
      return true;
    }
  }

  public boolean equals(Employee employee) {
    if (this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName)
        && this.salary == employee.salary) {
      return true;
    } else {
      return false;
    }
  }

  public String toString() {
    return "Employee's first name is " + firstName + ", lastname is " + lastName
        + ", monthly salary is " + salary;
  }


}
