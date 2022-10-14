package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Language findLanguageByName(String name);
}
