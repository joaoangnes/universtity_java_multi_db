package com.example.university.factories.students;

import java.util.List;

import com.example.university.disciplines.BachelorDiscipline;
import com.example.university.disciplines.I_Discipline;
import com.example.university.students.AbstractStudent;
import com.example.university.students.BachelorStudent;

// Bachelor Student Factory implementation
public class BachelorStudentFactory implements StudentFactory{
  @Override
  public AbstractStudent createStudent(String name, Integer age, List<I_Discipline> disciplines) {
    return new BachelorStudent(name, age, "Bachelor", disciplines);
  }

  @Override
  public void addDiscipline(AbstractStudent student, I_Discipline discipline) {
    // Verify with the discipline and the student is a Bachelor type, if not return a error
    if (student instanceof BachelorStudent && discipline instanceof BachelorDiscipline) {
        student.addDiscipline(discipline);
    } else {
        throw new IllegalArgumentException("Cannot add discipline to a non-Bachelor student using the BachelorStudentFactory.");
    }
  }

  @Override
  public void removeDiscipline(AbstractStudent student, I_Discipline discipline) {
    // Verify with the discipline is a Bachelor discipline, if not return a error
    if (discipline instanceof BachelorDiscipline) {
        student.removeDiscipline(discipline);
    } else {
        throw new IllegalArgumentException("Cannot remove discipline non-Bachelor BachelorStudentFactory.");
    }
  } 
  }
