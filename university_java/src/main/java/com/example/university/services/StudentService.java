package com.example.university.services;

import java.util.List;

import com.example.university.disciplines.I_Discipline;
import com.example.university.factories.students.StudentFactory;
import com.example.university.students.AbstractStudent;

// Class for students services methods
public class StudentService {
    private StudentFactory studentFactory;

    // Student Factory Dependency injection in the constructor of the service
    public StudentService(StudentFactory studentFactory) {
        this.studentFactory = studentFactory;
    }

    // Create the students with the factory injected in the constructor
    public AbstractStudent createStudent(String name, Integer age, List<I_Discipline> disciplines) {
        return studentFactory.createStudent(name, age, disciplines);
    }
    
    // Add a discipline with the factory injected in the constructor
    public void addDiscipline(AbstractStudent student, I_Discipline discipline){
        try {
            studentFactory.addDiscipline(student, discipline);
            System.out.println("Discipline added successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding discipline: " + e.getMessage());
        }
    }

    // Remove a discipline with the factory injected in the constructor
    public void removeDiscipline(AbstractStudent student, I_Discipline discipline){
        try {
            studentFactory.removeDiscipline(student, discipline);
            System.out.println("Discipline removed successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error removing discipline: " + e.getMessage());
        }
    }
}
