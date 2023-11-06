import java.util.ArrayList;
import java.util.List;

import com.example.university.decorators.BachelorCertificate;
import com.example.university.decorators.Certificate;
import com.example.university.decorators.I_Certificate;
import com.example.university.decorators.MasterCertificate;
import com.example.university.decorators.TechnicalCertificate;
import com.example.university.disciplines.BachelorDiscipline;
import com.example.university.disciplines.I_Discipline;
import com.example.university.disciplines.TechnicalDiscipline;
import com.example.university.factories.students.BachelorStudentFactory;
import com.example.university.factories.students.TechnicalStudentFactory;
import com.example.university.grades.BachelorGrade;
import com.example.university.grades.TechnicalGrade;
import com.example.university.services.StudentService;
import com.example.university.students.AbstractStudent;

public class CertificateTest {
    public static void main(String[] args) {
        List<I_Discipline> bachelorDisciplines = new ArrayList<>();
        bachelorDisciplines.add(new BachelorDiscipline("Science", new BachelorGrade(6.0)));
        bachelorDisciplines.add(new BachelorDiscipline("Math", new BachelorGrade(8.0)));
        I_Discipline historyDiscipline = new BachelorDiscipline("History", new BachelorGrade(3.0));

        StudentService studentBachelorService = new StudentService(new BachelorStudentFactory());
        AbstractStudent bachelorStudent = studentBachelorService.createStudent("Alice", 22, bachelorDisciplines);
        studentBachelorService.addDiscipline(bachelorStudent, historyDiscipline);

        /// ---------------
        List<I_Discipline> technicalDisciplines = new ArrayList<>();
        technicalDisciplines.add(new TechnicalDiscipline("Teste01", new TechnicalGrade(9.0)));
        technicalDisciplines.add(new TechnicalDiscipline("Teste02", new TechnicalGrade(5.0)));
        I_Discipline testDiscipline = new TechnicalDiscipline("Teste03", new TechnicalGrade(8.0));

        StudentService studentTechnicalService = new StudentService(new TechnicalStudentFactory());
        AbstractStudent technicalStudent = studentTechnicalService.createStudent("Alice", 22, technicalDisciplines);

        studentTechnicalService.addDiscipline(technicalStudent, testDiscipline);
        // System.out.println("\n");
        technicalStudent.isApproved();
        // -----------------------------


        I_Certificate certificate = new Certificate();
        certificate = new TechnicalCertificate(certificate);
        certificate = new BachelorCertificate(certificate);
        certificate = new MasterCertificate(certificate);
        certificate.generateCertificate(technicalStudent);

        // certificate = new BachelorCertificate(certificate);
        // certificate = new MasterCertificate(certificate)

        // System.out.println("\n");
        bachelorStudent.isApproved();
        technicalStudent.isApproved();
    }

    
}