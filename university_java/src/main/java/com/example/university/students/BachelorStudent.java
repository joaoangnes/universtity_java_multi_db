package com.example.university.students;

import java.util.ArrayList;
import java.util.List;

import com.example.university.decorators.BachelorCertificate;
import com.example.university.decorators.Certificate;
import com.example.university.decorators.I_Certificate;
import com.example.university.decorators.TechnicalCertificate;
import com.example.university.disciplines.I_Discipline;

// Concrete Bachelor Students class
public class BachelorStudent extends AbstractStudent{
    
    public BachelorStudent(String name, Integer age, String degreeProgram, List<I_Discipline> disciplines) {    
        super(name, age, degreeProgram, disciplines);
    }

    @Override
    public boolean isApproved() {
      // Verify which subjects the student has passed and failed
      List<I_Discipline> approvedDisciplines = getApprovedDisciplines();
      List<I_Discipline> failedDisciplines = getFailedDisciplines();

      System.out.println("Approved Discipliness:");
      for (I_Discipline discipline : approvedDisciplines) {
          System.out.println("- "+discipline.getName());
      }

      System.out.println("Failed Disciplines:");
      for (I_Discipline discipline : failedDisciplines) {
          System.out.println("- "+discipline.getName());
      }
      
      // If thers any failes discplines, return false
      return !approvedDisciplines.isEmpty(); 
    }

    public List<I_Discipline> getApprovedDisciplines() {
        List<I_Discipline> approvedDisciplines = new ArrayList<>();
        for (I_Discipline discipline : getDisciplines()) {
            if (discipline.isApproved()) {
                approvedDisciplines.add(discipline);
            }
        }
        return approvedDisciplines;
    }

    public List<I_Discipline> getFailedDisciplines() {
        List<I_Discipline> failedDisciplines = new ArrayList<>();
        for (I_Discipline discipline : getDisciplines()) {
            if (!discipline.isApproved()) {
                failedDisciplines.add(discipline);
            }
        }
        return failedDisciplines;
    }

    @Override
    public void getCertificate() {
      // Verify if the student is approved to generate a certificate
      if (isApproved()) {
        // Generate the bachelor certificate
        try{
          I_Certificate certificate = new Certificate();
          certificate = new TechnicalCertificate(certificate);
          certificate = new BachelorCertificate(certificate);
          certificate.generateCertificate(this);
          System.out.println("Certificate "+this.getName() + "_certificate.txt generated successfully!");
        } catch (Error e){
          System.out.println("Error generating certificate, error: "+e.getMessage());
        }

      } else{
        System.out.println("[ERROR]: Only approved students can receive their certificate, the student: "+this.getName()+" is not approved");
      }
    }
  
}
