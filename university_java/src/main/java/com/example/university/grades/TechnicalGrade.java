package com.example.university.grades;

// Concrete Technical grades class implementation
public class TechnicalGrade extends AbstractGrades {
  private double value;

  // Return a double value
  public TechnicalGrade(double value) {
      this.value = value;
  }

  @Override
  public boolean isApproved() {
    // Implement the Technical grades validation
    return value >= 7.0;
  }

  @Override
  public String toString() {
    return String.valueOf(value); 
  }
}
