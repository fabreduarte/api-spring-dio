package dio.diospringsecurityjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private dio.diospringsecurityjwt.repository.UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	public void createUser(dio.diospringsecurityjwt.model.User user) {
		String pass = user.getPassword();
		// criptografando antes de salvar no banco
		user.setPassword(encoder.encode(pass));
		repository.save(user);
	}
}
