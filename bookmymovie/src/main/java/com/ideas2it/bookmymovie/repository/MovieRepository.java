package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
<<<<<<< HEAD


=======
  //  Object findAllByActive(String active);

    //Optional<Movie> findByLangugae(String language);

    //Optional<Movie> findByScreening(String screening);

//    Optional<Movie> findByGenre(String genre);
>>>>>>> 20f47ba (Movie-Ticket-Booking:)
}
