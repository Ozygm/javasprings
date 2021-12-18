package cl.desafiolatam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.desafiolatam.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findAll();
}

