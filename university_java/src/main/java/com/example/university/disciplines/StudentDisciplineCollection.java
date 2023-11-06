package com.example.university.disciplines;

import java.util.List;

public class StudentDisciplineCollection {
    private List<I_Discipline> disciplines;

    public StudentDisciplineCollection(List<I_Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public List<I_Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<I_Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void addDiscipline(I_Discipline discipline) {
        disciplines.add(discipline);
    }

    public void removeDiscipline(I_Discipline discipline) {
        disciplines.remove(discipline);
    }
}
