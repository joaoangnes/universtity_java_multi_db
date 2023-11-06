package com.example.university.factories.students;

import java.util.List;

import com.example.university.disciplines.I_Discipline;
import com.example.university.disciplines.MasterDiscipline;
import com.example.university.students.AbstractStudent;
import com.example.university.students.MasterStudent;

// Master Student Factory implementation
public class MasterStudentFactory implements StudentFactory{
    @Override
    public AbstractStudent createStudent(String name, Integer age, List<I_Discipline> disciplines) {
        return new MasterStudent(name, age, "Master", disciplines);
    }

   @Override
    public void addDiscipline(AbstractStudent student, I_Discipline discipline) {
        // Verify with the discipline and the student is a Master type, if not return a error
        if (student instanceof MasterStudent && discipline instanceof MasterDiscipline) {
            student.addDiscipline(discipline);
        } else {
            throw new IllegalArgumentException("Cannot add discipline to a non-Master student using the MasterStudentFactory.");
        }
    } 

    @Override
    public void removeDiscipline(AbstractStudent student, I_Discipline discipline) {
        // Verify with the discipline is a Master discipline, if not return a error
      if (discipline instanceof MasterDiscipline) {
          student.removeDiscipline(discipline);
      } else {
          throw new IllegalArgumentException("Cannot remove discipline non-Master MasterStudentFactory.");
      }
    } 

}
