package com.example.university.factories.students;

import java.util.List;

import com.example.university.disciplines.I_Discipline;
import com.example.university.disciplines.TechnicalDiscipline;
import com.example.university.students.AbstractStudent;
import com.example.university.students.TechnicalStudent;

// Technical Student Factory implementation
public class TechnicalStudentFactory implements StudentFactory{

  @Override
  public AbstractStudent createStudent(String name, Integer age, List<I_Discipline> disciplines) {
    return new TechnicalStudent(name, age, "Technical", disciplines);
  }

  @Override
    public void addDiscipline(AbstractStudent student, I_Discipline discipline) {
      // Verify with the discipline and the student is a Technical type, if not return a error
      if (student instanceof TechnicalStudent && discipline instanceof TechnicalDiscipline) {
          student.addDiscipline(discipline);
      } else {
          throw new IllegalArgumentException("Cannot add discipline to a non-Tecnhnical student using the TecnhnicalStudentFactory.");
      }
  } 
  
  @Override
  public void removeDiscipline(AbstractStudent student, I_Discipline discipline) {
    // Verify with the discipline is a Technical discipline, if not return a error
    if (discipline instanceof TechnicalDiscipline) {
        student.removeDiscipline(discipline);
    } else {
        throw new IllegalArgumentException("Cannot remove discipline non-Tecnhnical TecnhnicalStudentFactory.");
    }
  } 
}
