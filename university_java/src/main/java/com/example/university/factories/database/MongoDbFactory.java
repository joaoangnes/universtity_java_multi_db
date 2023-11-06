package com.example.university.factories.database;

import com.example.university.config.MongoDbConnectionConfig;
import com.example.university.repository.I_UniversityRepository;
import com.example.university.repository.MongoDBUniversityRepository;

// Concrete MongoDB Factory implementation
public class MongoDbFactory implements UniversityRepositoryFactory {
    // Create the MongoDB repository instance
    @Override
    public I_UniversityRepository createUserRepository() {
        // Connect with the MongoDB
        MongoDbConnectionConfig mongoDbConnectionConfig = MongoDbConnectionConfig.getInstance();
        return new MongoDBUniversityRepository(mongoDbConnectionConfig); // Return the MongoDB repository instance
    }
}
