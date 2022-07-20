package com.company;

import static org.junit.Assert.*;

import org.junit.Test;

public class TranscriptTest {

  @Test
  public void getCourseWithScores() {
  }

  @Test
  public void addCourse() {
    Student studentTest = new Student("alice", 123);
    Transcript transTest = new Transcript(studentTest);
    CourseWithScore courseWithScoreTest = new CourseWithScore("test course", 999, 100.00);
    assertFalse(transTest.addCourse(courseWithScoreTest));
    assertEquals(2, transTest.getCourseWithScores().length);
  }

  @Test
  public void removeCourse() {
  }

  @Test
  public void editCourse() {
  }

  @Test
  public void getFinalScore() {
  }

  @Test
  public void testToString() {
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void search() {
  }
}