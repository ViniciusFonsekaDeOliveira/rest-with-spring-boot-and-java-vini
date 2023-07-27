package br.com.vini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vini.exceptions.FindByIdOperationException;
import br.com.vini.model.User;
import br.com.vini.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private Logger logger = Logger.getLogger(UserService.class.getName());


	public List<User> findAll() {
		logger.info("Finding all users");
		List<User> users = new ArrayList<User>();
		users = this.userRepository.findAll();
		return users;
	}


	public User findById(Long id) {
		logger.info("Finding the user");
		User user = this.userRepository.findById(id).orElseThrow(() -> new FindByIdOperationException("No records found for this ID!") );
		return user;
	}


	public User create(User user) {
		logger.info("Creating the user");
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}


	public User update(Long id, User user) {
		logger.info("Updating the user");
		
		User foundUser = this.userRepository.findById(id).orElseThrow(() -> new FindByIdOperationException("No records found for this ID!"));
		
		foundUser.setFirstName(user.getFirstName());
		foundUser.setLastName(user.getLastName());
		foundUser.setGender(user.getGender());
		
		
		return this.userRepository.save(foundUser);
	}


	public User updatePartial(Long id, User user) {
		logger.info("Patching the user");
		return user;
	}


	public void delete(Long id) {
		logger.info("Deleting the user");
		User foundUser = userRepository.findById(id).orElseThrow(() -> new FindByIdOperationException("No records found for this ID!"));
		
		this.userRepository.delete(foundUser);
		
		return;
	}

}
