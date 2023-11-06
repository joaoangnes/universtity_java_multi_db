package com.example.university.students;

import java.util.List;
import java.util.UUID;

import com.example.university.disciplines.I_Discipline;
import com.example.university.disciplines.StudentDisciplineCollection;

// Abstract class for the differents students
public abstract class AbstractStudent {
    private String id;
    private String name;
    private Integer age;
    private String degreeProgram;

    protected StudentDisciplineCollection disciplineCollection;

    public AbstractStudent(String name, Integer age, String degreeProgram, List<I_Discipline> disciplines) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.degreeProgram = degreeProgram;
        this.disciplineCollection = new StudentDisciplineCollection(disciplines);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getDegreeProgram() {
        return this.degreeProgram;
    }

    public List<I_Discipline> getDisciplines() {
        return disciplineCollection.getDisciplines();
    }

    public void addDiscipline(I_Discipline discipline) {
        disciplineCollection.addDiscipline(discipline);
    }

    public void removeDiscipline(I_Discipline discipline) {
        disciplineCollection.removeDiscipline(discipline);
    }

    // Abstract methods for the exclusive students implementation
    public abstract boolean isApproved();
    public abstract void getCertificate();

}
