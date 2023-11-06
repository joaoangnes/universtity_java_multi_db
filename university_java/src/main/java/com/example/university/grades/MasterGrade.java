package com.example.university.grades;

// Concrete Master grades class implementation
public class MasterGrade extends AbstractGrades{
  private char value;

  // Return a char value
  public MasterGrade(char value) {
      this.value = value;
  }

  @Override
  public boolean isApproved() {
    // Implement the Master grades validation
    return value != 'D';
  }

  @Override
  public String toString() {
    return String.valueOf(value); 
  }

}
