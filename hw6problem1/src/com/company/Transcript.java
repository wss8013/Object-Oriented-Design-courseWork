package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Problem2 [40 pts]
 * Let's design a class Transcript that contains a Student and an array of CourseWithScore.
 * - You could just use the class 'Student' in Problem1 here.
 * - CourseWithScore is similar to the class 'Course' in Question 1, but it has
 *   one more variable 'score'(double). So, you should consider using inheritance here.
 * - Transcript
 *    > Transcript only has one constructor. You just need to name the student.
 *      The number of courses in the transcript cannot exceed the number of courses the student has taken.
 *    > A method called 'addCourse', add a course to this transcript. You should check whether
 *      this student has taken this course or not. And you cannot add duplicate courses to the transcript.
 *    > A method called 'removeCourse', remove by id. If such id doesn't exist, throw an IllegalArgumentException.
 *    > A method called 'editCourse', edit score by course id. If such id doesn't exist, or the score is invalid, throw an IllegalArgumentException.
 *    > A method called 'getFinalScore', which will return the average score of all courses in this transcript.
 */
public class Transcript {
  private Student student;
  private CourseWithScore[] courseWithScores;
  private int courseAdded;

  // constructor
  public Transcript(Student s){
    this.student = new Student(s);
    courseWithScores = new CourseWithScore[student.getCourseTaken()];
    courseAdded = 0;
  }

  public CourseWithScore[] getCourseWithScores() {
    return Arrays.copyOf(courseWithScores, courseAdded);
  }
  // add course method
  public boolean addCourse(CourseWithScore courseWithScore) {
    if(courseAdded >= student.getCourseTaken()) {
      return false;
    }
    int index = student.search(courseWithScore.getId());
    if(index == -1) {
      return false;
    }
    for(int i=0;i<courseWithScores.length;i++) {
      if(courseWithScores[i] !=null && courseWithScores[i].equals(courseWithScore)){
        return false;
      }
    }
    courseWithScores[courseAdded] = courseWithScore;
    courseAdded++;
    return true;
  }

  //removeCourse
  public void removeCourse(int id) throws IllegalArgumentException{
    int i;
    for(i =0; i < courseAdded; i++) {
      if(id == courseWithScores[i].getId()) {
        break;
      }
    }
    if(i == courseAdded) {
      throw new IllegalArgumentException("No course with id: "+ id + " was found" );
    }
    for (int j = i; j < courseWithScores.length-1;j++) {

      courseWithScores[j] = courseWithScores[j+1];
    }
    courseAdded--;
  }

  public void editCourse(int id, double score) {
    int i, index = -1;
    for(i =0; i < courseAdded; i++) {
      if(id == courseWithScores[i].getId()) {
        index = i;
        break;
      }
    }
    if(index == -1) {
      throw new IllegalArgumentException("No course with id: "+ id + " was found" );
    }
    courseWithScores[index].setScore(score);
  }

  public double getFinalScore(){
  double sum = 0;
    for( int i =0; i < courseAdded; i++) {
      sum += courseWithScores[i].getScore();
    }
    return sum / courseAdded;
  }

  public String toString() {
    String res = student.toString() + "\n Course added is " + courseAdded ;
    for (CourseWithScore c: courseWithScores){
      if (c != null){
      res += (" \n " + c.toString());
      }
    }
    return res;
  }

  public boolean equals(Transcript t) {
    if (t == null || !t.student.equals(this.student)) {
      return false;
    }
    CourseWithScore[] thisCourse = getCourseWithScores();
    CourseWithScore[] tCourse = t.getCourseWithScores();
    if (thisCourse.length != tCourse.length) {
      return false;
    }
    // compare 1 element at a time
    for (int i = 0; i < thisCourse.length; i++) {
      if (thisCourse[i] == null) {
        continue;
      }
      int index = t.search(thisCourse[i].getId());
      if (index == -1 || !thisCourse[i].equals(tCourse[index])) {
        return false;
      }
    }
    return true;
  }

  public int search (int id) {
    for (int i =0; i < courseAdded; i++) {
      if(this.courseWithScores[i].getId() == id) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    //======================test Course===================================
    System.out.println(" =========================test course======================================");
    Course cs123 = new Course ("cs123", 123);
    Course cs456 = new Course("cs456",456);
    System.out.println(cs123);
    System.out.println(cs456);
    Course cs123copy = new Course("cs123", 123);
    System.out.println(cs123.equals(cs123copy));
    System.out.println(cs123.equals(cs456));
// =========================test Student======================================
    System.out.println(" =========================test student======================================");
    Course [] courses = {cs123,cs456};
    Student bob = new Student("bob",100);
    Student alice = new Student("alice",101,courses);
    Student bobCopy = new Student("bob",100);
    System.out.println(bob);
    System.out.println(alice);
    System.out.println(bobCopy);
    System.out.println(bob.equals(bobCopy));
    System.out.println(bob.equals(alice));
    bob.addCourse(cs123);
    System.out.println(" add cs123 to bob ");
    System.out.println(bob);
    bob.addCourse(cs123copy);
    System.out.println(" add  copy to  bob ");
    System.out.println(bob);

    System.out.println(bob.search(123));
    System.out.println(alice.search("someCourse"));
    System.out.println(alice.search("cs456"));
    System.out.println(alice.search(456));

    System.out.println(bob.remove(123));
    System.out.println(bob);
    System.out.println(bob.remove(123));
    System.out.println(bob.getCourseTaken());
    System.out.println(bob.addCourse(cs123));
    System.out.println(bob.getCourseTaken());


    // =========================test Transcript======================================
    System.out.println(" =========================test Transcript======================================");

    Transcript transcriptBob = new Transcript(bob);
    Transcript transcriptAlice = new Transcript(alice);
    CourseWithScore cs123WithScore90 = new CourseWithScore("cs123",123,90.00);
    CourseWithScore cs123WithScore100 = new CourseWithScore("cs123",123,100.00);
    CourseWithScore cs456WithScore90 = new CourseWithScore("cs456",456,90.00);
    CourseWithScore cs101WithScore90 = new CourseWithScore("cs 101",101,90.00);

    System.out.println("bob transcript ");
    System.out.println(transcriptBob);
    System.out.println("alice transcript ");
    System.out.println(transcriptAlice);
    System.out.println(" add cs101 to alice "+ transcriptAlice.addCourse(cs101WithScore90));
    System.out.println(" add cs123 to alice "+ transcriptAlice.addCourse(cs123WithScore90));
    System.out.println(" add cs123 to alice "+ transcriptAlice.addCourse(cs123WithScore100));
    System.out.println(transcriptAlice);
    System.out.println("add cs456 to alice "+ transcriptAlice.addCourse(cs456WithScore90));
    System.out.println(transcriptAlice);
    System.out.println("alice final score " + transcriptAlice.getFinalScore());
    System.out.println("edit cs456");
    transcriptAlice.editCourse(456,100.00);
    System.out.println(transcriptAlice);
    System.out.println("alice final score after edit " + transcriptAlice.getFinalScore());
    try{
      transcriptAlice.removeCourse(789);
    }catch (Exception e  ) {
      System.out.println("got exception "+ e.toString());
    }
    transcriptAlice.removeCourse(456);
    System.out.println(transcriptAlice);
    System.out.println("alice final score after removing 456 " + transcriptAlice.getFinalScore());
    // test equals
    bob.addCourse(cs456);
    bobCopy.addCourse(cs123);
    bobCopy.addCourse(cs456);
    Transcript transcriptBobOriginal  = new Transcript(bob);
    Transcript transcriptBobCopy  = new Transcript(bobCopy);
    transcriptBobOriginal.addCourse(cs123WithScore90);
    transcriptBobCopy.addCourse(cs456WithScore90);
    transcriptBobCopy.addCourse(cs123WithScore90);
    transcriptBobOriginal.addCourse(cs456WithScore90);
    System.out.println(bob.equals(bobCopy));
    System.out.println("bob " + bob);
    System.out.println("bobCopy " +  bobCopy);
    System.out.println(transcriptBobCopy);
    System.out.println(transcriptBobCopy.equals(transcriptBobOriginal));
  }
}
