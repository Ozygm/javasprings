package cl.desafiolatam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.model.Show;
import cl.desafiolatam.repository.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepo;
	
	public Show findById(Long id) {
		Optional<Show> optionalShow = showRepo.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	public List<Show> findAll(){
		return showRepo.findAll();
	}
	
	public void saveShow(Show show) {
		showRepo.save(show);
	}
	
	public void delShow(Long id) {
		showRepo.deleteById(id);
	}
	
	public void edit (Show show) {
		showRepo.save(show);
	}
	
}
