package com.example.university.disciplines;

import com.example.university.grades.AbstractGrades;

// Concrete class of Techinical Disciplines
public class TechnicalDiscipline implements I_Discipline {
  private String name;
  private AbstractGrades grade;

  public TechnicalDiscipline(String name, AbstractGrades grade) {
      this.name = name;
      this.grade = grade;
  }

  @Override
  public String getName() {
      return name;
  }

  @Override
  public AbstractGrades getGrade() {
      return grade;
  }

  @Override
  public boolean isApproved() {
    return grade.isApproved();
  }
}
