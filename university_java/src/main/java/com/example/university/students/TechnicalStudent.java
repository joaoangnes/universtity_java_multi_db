package com.example.university.students;

import java.util.List;

import com.example.university.decorators.Certificate;
import com.example.university.decorators.I_Certificate;
import com.example.university.decorators.TechnicalCertificate;
import com.example.university.disciplines.I_Discipline;

// Concrete Technical Students class
public class TechnicalStudent extends AbstractStudent{
  public TechnicalStudent(String name, Integer age, String degreeProgram, List<I_Discipline> disciplines) {    
    super(name, age, degreeProgram, disciplines);
  }

  @Override
  public boolean isApproved() {
    // Checks if there is at least one failed subject, if there is, returns that the student has failed.
    for (I_Discipline discipline : getDisciplines()) {
        if (!discipline.isApproved()) {
            System.out.println("Technical Student " + this.getName() + " fails..");
            return false;
        }
    }
    System.out.println("Technical Student " + this.getName() + " approved!!");
    return true;
  }

  @Override
  public void getCertificate() {
    // Verify if the student is approved to generate a certificate
    if (isApproved()) {
      // Generate the technical certificate
      try{
        I_Certificate certificate = new Certificate();
        certificate = new TechnicalCertificate(certificate);
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
