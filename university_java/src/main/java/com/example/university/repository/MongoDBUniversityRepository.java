package com.example.university.repository;

import java.util.List;
import java.util.ArrayList;
import org.bson.Document;

import com.example.university.config.MongoDbConnectionConfig;
import com.example.university.disciplines.I_Discipline;
import com.example.university.students.AbstractStudent;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

// Clas for implementation of MongoDB DML Functions
public class MongoDBUniversityRepository implements I_UniversityRepository{
    private MongoCollection<Document> studentCollection;

    public MongoDBUniversityRepository(MongoDbConnectionConfig mongoDbConnectionConfig) {
        MongoDatabase database = mongoDbConnectionConfig.getDatabase();
        this.studentCollection = database.getCollection("students");
    }

    @Override
    public void addStudent(AbstractStudent student) {
        try{
            Document studentDocument = new Document("student_id", student.getId())
                .append("name", student.getName())
                .append("age", student.getAge())
                .append("degreeProgram", student.getDegreeProgram());

            List<Document> disciplineDocuments = new ArrayList<>();

            for (I_Discipline discipline : student.getDisciplines()) {
                Document disciplineDocument = new Document("name", discipline.getName())
                        .append("grade", discipline.getGrade().toString());
                disciplineDocuments.add(disciplineDocument);
            }

            studentDocument.append("disciplines", disciplineDocuments);

            studentCollection.insertOne(studentDocument);
            System.out.println("Student has been successfully added in MongoDB");
        } catch (MongoException e) {
            System.err.println("Error adding student in MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void printStudentInformation(Document studentDocument) {
        if (studentDocument != null) {
            String name = studentDocument.getString("name");
            Integer age = studentDocument.getInteger("age");
            String degreeProgram = studentDocument.getString("degreeProgram");
            
            System.out.println("Student ID: " + studentDocument.getString("student_id"));
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Degree Program: " + degreeProgram);

            @SuppressWarnings("unchecked")
            List<Document> disciplineDocuments = (List<Document>) studentDocument.get("disciplines", List.class);

            System.out.println("Disciplines:");

            for (Document disciplineDocument : disciplineDocuments) {
                String disciplineName = disciplineDocument.getString("name");
                String grade = disciplineDocument.getString("grade");

                System.out.println("  Discipline: " + disciplineName);
                System.out.println("  Grade: " + grade);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void getStudentById(String id) {
        try {
            Document query = new Document("student_id", id);
            Document studentDocument = studentCollection.find(query).first();
    
            printStudentInformation(studentDocument);
    
        } catch (MongoException e) {
            System.err.println("Error reading student data in MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getAllStudents() {
        try{
            try (MongoCursor<Document> cursor = studentCollection.find().iterator()) {
                while (cursor.hasNext()) {
                    Document studentDocument = cursor.next();
                    printStudentInformation(studentDocument);
                }
            }

        } catch (MongoException e) {
            System.err.println("Error read students data in MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(AbstractStudent student) {
        try{
            Document query = new Document("_id", student.getId());
            Document update = new Document("$set",
                new Document("student_id", student.getId())
                    .append("name", student.getName())
                    .append("age", student.getAge())
                    .append("degreeProgram", student.getDegreeProgram())
            );

            List<Document> disciplineDocuments = new ArrayList<>();

            for (I_Discipline discipline : student.getDisciplines()) {
                Document disciplineDocument = new Document("name", discipline.getName())
                        .append("grade", discipline.getGrade().toString());
                disciplineDocuments.add(disciplineDocument);
            }

            update.append("disciplines", disciplineDocuments);

            studentCollection.updateOne(query, update);
            System.out.println("Student has been successfully updated in MongoDB");
        } catch (MongoException e) {
            System.err.println("Error updating student data in MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String id) {
        try{
            Document query = new Document("student_id", id);
            studentCollection.deleteOne(query);
            System.out.println("Student has been successfully deleted in MongoDB");
        } catch (MongoException e) {
            System.err.println("Error delete student data in MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
