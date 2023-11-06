package com.example.university.decorators;

import java.io.FileWriter;
import java.io.IOException;

import com.example.university.students.AbstractStudent;

// Certificate basic class of the decorator pattern
public class Certificate implements I_Certificate {
    @Override
    public void generateCertificate(AbstractStudent student) {
        try {
            FileWriter writer = new FileWriter(student.getName() + "_certificate.txt");
            writer.write("Course Conclusion Certificate\n\n");
            writer.write("Student Name: " + student.getName() + "\n");
            writer.write("Age: " + student.getAge() + "\n");
            writer.write("\nDegree Programs Certificates:\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




