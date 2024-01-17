package com.revature.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Review;

@Repository("reviewRepository")
@CrossOrigin(origins = "http://localhost:4200")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findAll();
	<R extends Review> R save(R r);
	List<Review> deleteReviewByRevid(int revid);
	List<Review> findReviewByUserid(int username);
	List<Review> findReviewByMovieid(String movieid);
	Review findReviewByRevid(int revid);
}
