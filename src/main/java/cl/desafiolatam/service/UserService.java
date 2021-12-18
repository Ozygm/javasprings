package cl.desafiolatam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.model.User;

import cl.desafiolatam.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	public void guardarUser(User user) {
		userRepo.save(user);
	}
	
	public User findByName(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User findById(Long id) {
		Optional <User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public void createUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(User user) {
		userRepo.save(user);
	}
	
	public void delUser(Long id) {
		userRepo.deleteById(id);
	}
}
