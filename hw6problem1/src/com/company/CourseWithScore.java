package com.company;

public class CourseWithScore extends Course {

  private double score;

  // constructor
  public CourseWithScore(String name, int id, double score) {
    setName(name);
    setId(id);
    setScore(score);
  }

  public double getScore() {
    return this.score;
  }

  public void setScore(double score) {
    if (score < 0) {
      this.score = 0;
      return;
    }
    this.score = score;
  }

  public boolean equals(CourseWithScore c) {
    // ignoring the score since two courses with same name and id but not the same score are still
    // the same course. it could help Transcript class to determine whether to add a course to the
    // courseWithScore array if there is a course with same name and id but different score existed
    // in the array
    return c != null && c.getName().equals(this.getName()) && c.getId() == this.getId();
  }

  public String toString() {
    return "The course name is " + this.getName() + " and the course id is " + this.getId()
        + " and the course score is " + this.getScore();
  }
}
