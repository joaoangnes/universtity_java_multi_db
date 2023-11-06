package com.example.university.decorators;

import java.io.FileWriter;
import java.io.IOException;

import com.example.university.students.AbstractStudent;

// Master Certificate decorator
public class MasterCertificate extends CertificateDecorator{
    public MasterCertificate(I_Certificate certificate) {
        super(certificate);
    }

    @Override
    public void generateCertificate(AbstractStudent student) {
        certificate.generateCertificate(student);

        try {
            FileWriter writer = new FileWriter(student.getName() + "_certificate.txt", true);
            writer.write("\n - Master Certificate;");
            // writer.write("Matérias Realizadas:\n");
            // for (I_Discipline discipline : student.getDisciplines()) {
            //     writer.write(discipline.getName() + " - Grade: " + discipline.getGrade() + "\n");
            // }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}