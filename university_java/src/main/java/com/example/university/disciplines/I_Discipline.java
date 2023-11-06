package com.example.university.disciplines;

import com.example.university.grades.AbstractGrades;

// Interface of the disciplines
public interface I_Discipline {
  String getName();
  AbstractGrades getGrade();
  boolean isApproved();
}
