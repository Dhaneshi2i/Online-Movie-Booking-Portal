package com.ideas2it.bookmymovie.repoImpl;

import java.util.List;
import javax.persistence.*;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.User;
import org.springframework.stereotype.Repository;


@Repository
public class QueryClass {
	@PersistenceContext
	EntityManager eManager;

	public List<Booking> getAllByMovieId(int movieId) {
		TypedQuery<Booking> qry = eManager
				.createQuery("select b from Booking b join b.show s where s.movie.movieId = :id", Booking.class);
		qry.setParameter("id", movieId);
		return qry.getResultList();
	}

	public User findByUserName(String username) throws NotFoundException {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.username like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new NotFoundException("User Not Available !!");
		return user.get(0);
	}

}
