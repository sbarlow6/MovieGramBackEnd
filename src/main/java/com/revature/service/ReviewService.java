package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.Review;
import com.revature.repository.ReviewRepository;
import com.revature.repository.UserRepository;

@Service(value="reviewService")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	public List<Review> randomReview() {
		return this.reviewRepository.findAll();
	}
	public void insertReview(Review r) {
		System.out.println("hit the service");
		this.reviewRepository.save(r);
	}
	public void deleteReviewByRevid(int revid) {
		System.out.println("hit the service");
		this.reviewRepository.deleteReviewByRevid(revid);
	}
	public List<Review> reviewsByUserid(int username) {
		return this.reviewRepository.findReviewByUserid(username);
	}
	public List<Review> reviewsByMovieid(String imdbid) {
		return this.reviewRepository.findReviewByMovieid(imdbid);
	}
	public List<Review> reviewsByOne(int revid) {
		return this.reviewRepository.findReviewByRevid(revid);
	}

}
