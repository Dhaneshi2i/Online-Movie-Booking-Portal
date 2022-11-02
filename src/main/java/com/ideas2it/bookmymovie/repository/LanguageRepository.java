package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByLanguageId(int languageId);

    boolean existsByLanguageName(String languageName);
}
