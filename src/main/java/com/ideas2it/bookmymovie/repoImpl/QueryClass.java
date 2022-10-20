package com.ideas2it.bookmymovie.repoImpl;


import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class QueryClass {
	@PersistenceContext
	EntityManager entityManager;

	public List<Booking> getAllByMovieId(int movieId) {
		TypedQuery<Booking> qry = entityManager
				.createQuery("select b from Booking b join b.show s where s.movie.movieId = :id", Booking.class);
		qry.setParameter("id", movieId);
		return qry.getResultList();
	}

	public User findByUserName(String username) throws NotFoundException {
		TypedQuery<User> qry = entityManager.createQuery("select u from User u where u.username like :name", User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if (user.size() == 0)
			throw new NotFoundException("User Not Available !!");
		return user.get(0);
	}
}
