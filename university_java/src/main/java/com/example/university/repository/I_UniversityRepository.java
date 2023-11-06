package com.example.university.repository;

import com.example.university.students.AbstractStudent;

// Interface fot the students dml functions
public interface I_UniversityRepository {
  void getStudentById(String id); 
  void getAllStudents(); 
  void addStudent(AbstractStudent student);
  void updateStudent(AbstractStudent student);
  void deleteStudent(String id);
}
