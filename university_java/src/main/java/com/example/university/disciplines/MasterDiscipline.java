package com.example.university.disciplines;

import com.example.university.grades.AbstractGrades;

// Concrete class of Master Disciplines
public class MasterDiscipline implements I_Discipline{
  private String name;
  private AbstractGrades grade;

  public MasterDiscipline(String name, AbstractGrades grade) {
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
