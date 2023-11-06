package com.example.university.config;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

// Class to create the MongoDB connection with a Singleton design pattern
public class MongoDbConnectionConfig {
    private static final String DATABASE_NAME = ConfigLoader.getDatabaseName();
    private static final String MONGODB_URI = ConfigLoader.getMongoDBUri();

    // Instance mongo (Singleton)
    private static MongoDbConnectionConfig instance;

    private MongoClient mongoClient;
    private MongoDatabase database;

    private MongoDbConnectionConfig() {
        try {
            // Creates a MongoDB client with the specified connection URL
            mongoClient = MongoClients.create(MONGODB_URI);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("MongoDB connection successfully established.");
        } catch (Exception e) {
            System.out.println("MongoDB connection failed: " + e.getMessage());
        }
    }

    public static MongoDbConnectionConfig getInstance() {
        if (instance == null) {
            synchronized (MongoDbConnectionConfig.class) {
                if (instance == null) {
                    instance = new MongoDbConnectionConfig();
                }
            }
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void closeConnection() {
        try {
            mongoClient.close();
            System.out.println("MongoDB connection closed successfully.");
        } catch (Exception e) {
            System.out.println("[ERROR] - Failed to close connection to MongoDB: " + e.getMessage());
        }
    }
}
