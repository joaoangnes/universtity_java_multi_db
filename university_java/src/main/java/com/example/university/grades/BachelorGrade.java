package com.example.university.grades;

// Concrete Bachelor grades class implementation
public class BachelorGrade extends AbstractGrades {
  private double value;

  // Return a double value
  public BachelorGrade(double value) {
    this.value = value;
  }

  @Override
  public boolean isApproved() {
    // Implement the Bachelor grades validation
    return value >= 6.0;
  }
  
  @Override
  public String toString() {
    return String.valueOf(value); 
  }
}
