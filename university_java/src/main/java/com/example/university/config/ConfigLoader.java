package com.example.university.config;
import io.github.cdimascio.dotenv.Dotenv;

// Class used to fetch the project's environment variables
public class ConfigLoader {
   private static final Dotenv dotenv = Dotenv.configure().load();

    public static String getDatabaseName() {
      return dotenv.get("DATABASE_NAME");
    }

    public static String getMongoDBUri() {
        return dotenv.get("MONGODB_URI");
    }

    public static String getMySQLUrl() {
        return dotenv.get("MYSQL_URL");
    }

    public static String getMySQLUser() {
        return dotenv.get("MYSQL_USER");
    }

    public static String getMySQLPassword() {
        return dotenv.get("MYSQL_PASSWORD");
    }
}
