package com.example.university.factories.database;

import com.example.university.config.MySqlConnectionConfig;
import com.example.university.repository.I_UniversityRepository;
import com.example.university.repository.MySQLUniversityRepository;

// Concrete MySQL Factory implementation
public class MySqlFactory implements UniversityRepositoryFactory {
  // Create the MySQL repository instance 
  @Override
  public I_UniversityRepository createUserRepository() {
    // Connect with the MySQL
      MySqlConnectionConfig mySqlConnectionConfig = MySqlConnectionConfig.getInstance();  
      return new MySQLUniversityRepository(mySqlConnectionConfig); // Return the MySQL repository instance
  }
}
