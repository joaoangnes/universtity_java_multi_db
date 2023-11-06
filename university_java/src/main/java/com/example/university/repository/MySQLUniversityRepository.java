package com.example.university.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.university.config.MySqlConnectionConfig;
import com.example.university.disciplines.I_Discipline;
import com.example.university.students.AbstractStudent;

// Clas for implementation of MySQL DML Functions
public class MySQLUniversityRepository implements I_UniversityRepository {
    private Connection connection;

    private String selectQueryAll = "select students.student_id\n" + //
            "     , students.name\n" + //
            "     , students.age\n" + //
            "     , students.degreeProgram\n" + //
            "     , disciplines.discipline_name\n" + //
            "\t , disciplines.grade\n" + //
            "from university_db.Students as students\n" + //
            "    ,university_db.StudentDisciplines as disciplines\n" + //
            "where students.student_id = disciplines.student_id";

    private String selectQueryByID = "select students.student_id\n" + //
            "     , students.name\n" + //
            "     , students.age\n" + //
            "     , students.degreeProgram\n" + //
            "     , disciplines.discipline_name\n" + //
            "\t , disciplines.grade\n" + //
            "from university_db.Students as students\n" + //
            "    ,university_db.StudentDisciplines as disciplines\n" + //
            "where students.student_id = disciplines.student_id\n" + //
            "  and students.student_id = ?";

    public MySQLUniversityRepository(MySqlConnectionConfig mySqlConnectionConfig) {
        this.connection = mySqlConnectionConfig.getConnection();
    }

    @Override
   public void addStudent(AbstractStudent student) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO Students (student_id, name, age, degreeProgram) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getDegreeProgram());
            preparedStatement.executeUpdate();

            // Inserir disciplinas do aluno no banco de dados
            for (I_Discipline discipline : student.getDisciplines()) {
                insertDisciplineForStudent(student.getId(), discipline);
            }
            System.out.println("Student has been successfully added in MySQL database");
        } catch (SQLException e) {
            System.err.println("Error adding student in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void insertDisciplineForStudent(String studentId, I_Discipline discipline) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO StudentDisciplines (student_id, discipline_name, grade) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, discipline.getName());
            preparedStatement.setString(3, discipline.getGrade().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding student disciplines in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void printStudentInformation(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                System.out.println("====================================================================");
    
                while (resultSet.next()) {
                    System.out.println("Student ID: " + resultSet.getString("student_id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Age: " + resultSet.getInt("age"));
                    System.out.println("Degree Program: " +  resultSet.getString("degreeProgram"));
                    System.out.println("Disciplines: ");
                    System.out.println("  Discipline Name: " + resultSet.getString("discipline_name"));
                    System.out.println("  Grade: " + resultSet.getString("grade"));
                    System.out.println("====================================================================");
                }
            } else {
                System.out.println("No students found.");
            }
        } catch (SQLException e) {
            System.err.println("Error printing student information: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getStudentById(String id) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(this.selectQueryByID)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                printStudentInformation(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Error read student data in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getAllStudents() {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(this.selectQueryAll);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                printStudentInformation(resultSet);;
            }
        } catch (SQLException e) {
            System.err.println("Error read students data in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(AbstractStudent student) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE Students SET name = ?, age = ?, degreeProgram = ? WHERE id = ?")) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getDegreeProgram());
            preparedStatement.setString(4, student.getId());
            
            preparedStatement.executeUpdate();
            System.out.println("Student has been successfully updated in MySQL database");
        } catch (SQLException e) {
            System.err.println("Error updating student data in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String id) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM Students WHERE id = ?")) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Student has been successfully deleted in MySQL database");
        } catch (SQLException e) {
            System.err.println("Error delete student data in MySQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}