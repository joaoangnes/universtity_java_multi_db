package com.example.university.factories.database;

import com.example.university.repository.I_UniversityRepository;

// Interface of the DB users repository
public interface UniversityRepositoryFactory {
  I_UniversityRepository createUserRepository();
}
