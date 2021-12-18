package cl.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.model.Rating;
import cl.desafiolatam.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	public List<Rating> findAll(){
		return ratingRepo.findAll();
	}
	
	public Rating findByRatingId(Long id) {
		return ratingRepo.findById(id).orElse(null);
	}
	
	public void addRating(Rating rating) {
		ratingRepo.save(rating);
	}

}
