package com.company;
// Problem1 [30 pts]
// Design a class called "Course" which represents a university course.
// It has a name and an id. You should provide equals(), toString(), constructors, setters and getters.
// Next, design a Student class. Each student has a name, an id, and a list of courses they have taken.
// For simplicity, assume 100 as the maximum number of courses a student can take.
// Other than the normal methods, you need to provide the following:
// -> A method for adding a course to a Student object.
// -> A method for searching if a student has taken a particular course. Two methods should be provided.
//    One searches by id, one searches by name.
// -> A method for removing a course. Again, two method should be provided.
public class Course implements Comparable<Course> {
    private String name;
    private int id;
    // constructor without parameters
    public Course(){}
    // constructor with parameters
    public Course(String name, int id){
       setName(name);
       setId(id);
    }
    // getter method
    public String getName(){
        return new String(this.name);
    }
    public int getId(){
        return this.id;
    }
    // setter method
    public void setName(String name){
        this.name = new String(name);
    }
    public void setId(int id){
        this.id = id;
    }
    // equals method
    public boolean equals(Course a){
        return a != null && this.name.equals(a.name) && this.id == a.id;
    }
    // override string
    public String toString(){
        return "The course name is "+ name + " and the course id is " + id;
    }
    @Override
    public int compareTo(Course o) {
        if(o.getId() != this.id) {
            return this.id - o.getId();
        }
        return this.name.compareTo(o.getName());
    }
}
