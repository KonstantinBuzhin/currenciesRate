package startingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import startingApp.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	@Override
	public List<User> findAll();

	public User findByEmail(String email);

	public User findByEmailAndPassword(String email, String password);

}
