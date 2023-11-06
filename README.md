# universtity_java_multi_db
Project built in Java for a college assignment, with the aim of creating a student grade management system for different types of degree, 
where you can check if the student has passed, with different types of grade validation rules, generate certificates and store your data 
in multiple databases (MySQL and MongoDB), being able to easily expand to another database, without changing the basic structure.

SOLID patterns were used to build the project, as well as the design patterns:
- Abstract Factory;
- Factory;
- Decorator;
- Singleton;

Requirements:
- Develop a module that allows the use of different databases of your choice;

- The factory for accessing the databases must be developed by the team and the use of an ORM framework for database injection will not be accepted;

- The active database must be sensitized. For example, if MySql is injected, data must be written to or queried from a table. If MongoDb is injected, it must create or query a document;
  
- Flexibility that allows objects of different natures to be processed with an emphasis on the possibility of incorporating new objects in the future;

- Your system must be able to process values according to the following rules:
  i. Technical course: the student passes if they obtain an average of 7.0 (seven) or more in all subjects. Otherwise, the student fails;<br>
  ii. Bachelor's degree course: the student passes each subject (individually) if they achieve an average of 6.0 (six) or more. Otherwise, the student fails;<br>
  iii. Master's course: the student is disqualified from the course if they obtain a D in any of the subjects. A, B or C grades are approved and the student is kept in the program;<br>
  
- Build a certificate with Decorator Pattern;
  
Design Pattern of the program:
![UniverstyProject](https://github.com/joaoangnes/universtity_java_multi_db/assets/74597614/0fccd244-557d-4c63-841e-3cfbab29b2e5)
