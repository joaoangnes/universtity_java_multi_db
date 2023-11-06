package com.example.university.factories.database;

import java.sql.SQLException;

import com.example.university.repository.I_UniversityRepository;
import com.example.university.types.DatabaseType;

// Database Abstract Factory
public abstract class DatabaseFactory {
    public abstract UniversityRepositoryFactory createUniversityRepositoryFactory();

    // Create the student repository with the factory instance
    public I_UniversityRepository createUserRepository() throws SQLException {
        UniversityRepositoryFactory factory = createUniversityRepositoryFactory();
        return factory.createUserRepository();
    }

    // Build the database factory instance with the type injected
    public static UniversityRepositoryFactory createDatabaseFactory(DatabaseType type) {
        switch (type) {
            case MYSQL:
                return new MySqlFactory();
            case MONGODB:
                return new MongoDbFactory();
            default:
                throw new IllegalArgumentException("Tipo de banco de dados não suportado: " + type);
        }
    }
}
