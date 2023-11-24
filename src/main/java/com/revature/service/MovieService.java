package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.Movies;
import com.revature.model.User;
import com.revature.repository.MovieRepository;
import com.revature.repository.ReviewRepository;
import com.revature.repository.UserRepository;

@Service(value="movieService")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	public Movies findMoviebyimdbID(String imdbID) {
		return this.movieRepository.findMovieByid(imdbID);
	}
	public void insertMovie(Movies m) {
        this.movieRepository.save(m);
	}

}
