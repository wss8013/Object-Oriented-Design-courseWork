package com.company;

import java.util.Arrays;

// Problem1 [30 pts]
// Design a class called "Course" which represents a university course.
// It has a name and an id. You should provide equals(), toString(), constructors, setters and getters.
// Next, design a Student class. Each student has a name, an id, and a list of courses they have taken.
// For simplicity, assume 100 as the maximum number of courses a student can take.
// Other than the normal methods, you need to provide the following:
// -> A method for adding a  to a Student object.
// -> A method for searching if a student has taken a particular course. Two methods should be provided.
//    One searches by id, one searches by name.
// -> A method for removing a course. Again, two method should be provided.
public class Student {
  private String name;
  private int id;
  private Course [] courses;
  int courseTaken;
  // constructor
  public Student(String name, int id){
    setName(name);
    setId(id);
    this.courses = new Course[100];
    courseTaken = 0;
  }
  public Student(String name, int id, Course[] courses){
    setName(name);
    setId(id);
    setCourses(courses);
  }

  // copy of a constructor
  public Student(Student s) {
    if(s == null) {
      new Student("",0);
    }
    setName(s.getName());
    setId(s.getId());
    setCourses(s.getCourse());
  }

  // getter method
  public int getCourseTaken() {
    return courseTaken;
  }
  public String getName(){
    return new String(this.name);
  }

  public int getId(){
    return this.id;
  }

  public Course[] getCourse(){
    return  Arrays.copyOf(courses, courseTaken);
  }

  // setter method
  public void setName(String name){
    this.name = new String(name);
  }

  public void setId(int id){
    this.id = id;
  }

  public void setCourses(Course[] courses){
    this.courses = new Course[100];
    courseTaken = 0;
    if(courses == null) {
      return;
    }
    for(int i = 0; i < courses.length;i++) {
      addCourse(courses[i]);
    }

  }

  public String toString(){
    String res = "Student name: " + this.name + " Student Id "+ this.id + " courses: ";
    for(int i = 0;i < courses.length;i++) {
      if (courses[i] != null){
        res += ("\n " + courses[i].toString());
      }
    }
    return res;
  }

  public boolean equals(Student s) {
    if (s == null || !s.name.equals(this.name) || s.id != this.id) {
      return false;
    }
    Course [] sCourse = s.getCourse();
    Course [] thisCourse = getCourse();
    Arrays.sort(sCourse);
    Arrays.sort(thisCourse);
    return  Arrays.equals(sCourse, thisCourse);
  }

  // adding course to a student object
  public boolean addCourse(Course c) {
    if(c == null || courseTaken >= 100 || search(c.getId()) != -1) {
      return false;
    }

    courses[courseTaken] = c;
    courseTaken++;
    return true;
  }

  // searching if a student has taken a particular course by name
  public int search (String name){
    for (int i =0; i < courseTaken; i++) {
      if(this.courses[i].getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  // searching if a student has taken a particular course by id
  public int search(int id){
    for (int i =0; i < courseTaken; i++) {
      if(this.courses[i].getId() == id) {
        return i;
      }
    }
    return -1;
  }

  // removing a course by name
  public boolean remove(String name){
    int index = search(name);
    if(index == -1) {
      return false;
    }
    for(int i = index; i < courses.length-1;i++) {
      courses[i] = courses[i+1];
    }
    courseTaken--;
    return true;
  }

  // removing a course by id
  public boolean remove(int id) {
    int index = search(id);
    if(index == -1) {
      return false;
    }
    for(int i = index; i < courses.length -1; i++) {
      courses[i] = courses[i+1];
    }
    courseTaken--;
    return true;
  }
}
