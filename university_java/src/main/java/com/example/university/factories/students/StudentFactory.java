package com.example.university.factories.students;

import java.util.List;

import com.example.university.disciplines.I_Discipline;
import com.example.university.students.AbstractStudent;

// Student factory interface 
public interface StudentFactory {
  AbstractStudent createStudent(String name, Integer age, List<I_Discipline> disciplines);
  void addDiscipline(AbstractStudent student, I_Discipline discipline);
  void removeDiscipline(AbstractStudent student, I_Discipline discipline);
}
