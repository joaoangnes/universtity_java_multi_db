
import java.util.List;
import java.util.ArrayList;

import com.example.university.disciplines.BachelorDiscipline;
import com.example.university.disciplines.I_Discipline;
import com.example.university.disciplines.MasterDiscipline;
import com.example.university.disciplines.TechnicalDiscipline;
import com.example.university.factories.database.DatabaseFactory;
import com.example.university.factories.database.UniversityRepositoryFactory;
import com.example.university.factories.students.BachelorStudentFactory;
import com.example.university.factories.students.MasterStudentFactory;
import com.example.university.factories.students.TechnicalStudentFactory;
import com.example.university.grades.BachelorGrade;
import com.example.university.grades.MasterGrade;
import com.example.university.grades.TechnicalGrade;
import com.example.university.repository.I_UniversityRepository;
import com.example.university.services.StudentService;
import com.example.university.students.AbstractStudent;
import com.example.university.types.DatabaseType;

public class MySqlConnectionTest {
    public static void main(String[] args) {
        UniversityRepositoryFactory factory = DatabaseFactory.createDatabaseFactory(DatabaseType.MYSQL);

        try {
            I_UniversityRepository mySQLRepository = factory.createUserRepository();

            System.out.println("======================");
            createAndAddMasterStudent(mySQLRepository);
            System.out.println("======================");
            createAndAddBachelorStudent(mySQLRepository);
            System.out.println("======================");
            createAndAddTechnicalStudent(mySQLRepository);

            // mySQLRepository.getStudentById("59a2ca71-f5f4-4c44-b4e7-22ae3aa39101");
            // mySQLRepository.getAllStudents();

        } catch (Error e) {
            e.printStackTrace();
        }
    }

    private static void createAndAddMasterStudent(I_UniversityRepository repository) {
        List<I_Discipline> masterDisciplines = new ArrayList<>();
        masterDisciplines.add(new MasterDiscipline("Math", new MasterGrade('A')));
        masterDisciplines.add(new MasterDiscipline("Physics", new MasterGrade('D')));
        I_Discipline historyDiscipline = new MasterDiscipline("History", new MasterGrade('B'));

        StudentService studentMasterService = new StudentService(new MasterStudentFactory());
        AbstractStudent masterStudent = studentMasterService.createStudent("Rubinho da Silva", 30, masterDisciplines);
        
        // test add disciplines
        studentMasterService.addDiscipline(masterStudent, historyDiscipline);
        // repository.addStudent(masterStudent);
        // System.out.println("\n");
        // masterStudent.isApproved();
        // get the certificate
        masterStudent.getCertificate();
    }

    private static void createAndAddBachelorStudent(I_UniversityRepository repository) {
        List<I_Discipline> bachelorDisciplines = new ArrayList<>();
        bachelorDisciplines.add(new BachelorDiscipline("Science", new BachelorGrade(6.0)));
        bachelorDisciplines.add(new BachelorDiscipline("Math", new BachelorGrade(8.0)));
        I_Discipline historyDiscipline = new BachelorDiscipline("History", new BachelorGrade(3.0));

        StudentService studentBachelorService = new StudentService(new BachelorStudentFactory());
        AbstractStudent bachelorStudent = studentBachelorService.createStudent("Jhon Doe", 22, bachelorDisciplines);

        studentBachelorService.addDiscipline(bachelorStudent, historyDiscipline);
        // repository.addStudent(bachelorStudent);
        // System.out.println("\n");
        // bachelorStudent.isApproved();

        // get the certificate
        bachelorStudent.getCertificate();
    }

    private static void createAndAddTechnicalStudent(I_UniversityRepository repository) {
        List<I_Discipline> technicalDisciplines = new ArrayList<>();
        technicalDisciplines.add(new TechnicalDiscipline("Science", new TechnicalGrade(7.0)));
        technicalDisciplines.add(new TechnicalDiscipline("Math", new TechnicalGrade(8.0)));
        I_Discipline historyDiscipline = new TechnicalDiscipline("History", new TechnicalGrade(6.0));

        StudentService studentTechnicalService = new StudentService(new TechnicalStudentFactory());
        AbstractStudent technicalStudent = studentTechnicalService.createStudent("Junior Capixaba", 19, technicalDisciplines);

        studentTechnicalService.addDiscipline(technicalStudent, historyDiscipline);
        // repository.addStudent(technicalStudent);
        // System.out.println("\n");
        // technicalStudent.isApproved();

        // get the certificate
        technicalStudent.getCertificate();
    }
}
