package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This Language repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByLanguageId(int languageId);

    boolean existsByLanguageName(String languageName);
}
