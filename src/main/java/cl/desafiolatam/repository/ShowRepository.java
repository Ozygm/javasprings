package cl.desafiolatam.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cl.desafiolatam.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

	List<Show> findAll();
}
