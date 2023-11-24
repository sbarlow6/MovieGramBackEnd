package com.revature.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Movies;
import com.revature.model.Review;
import com.revature.model.User;

@Repository("movieRepository")
@CrossOrigin(origins = "http://localhost:4200")
public interface MovieRepository extends JpaRepository<Movies, Integer> {
	public Movies findMovieByid(String imdbID);
	<M extends Movies> M save(M m);
}
