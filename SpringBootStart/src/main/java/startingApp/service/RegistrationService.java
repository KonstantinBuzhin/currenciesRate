package startingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startingApp.model.User;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User fetchUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}
}
