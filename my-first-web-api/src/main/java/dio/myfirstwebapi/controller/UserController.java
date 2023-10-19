package dio.myfirstwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.myfirstwebapi.model.User;
import dio.myfirstwebapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping()
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/{username}")
	public User getOne(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}

	@PostMapping()
	public void postUser(@RequestBody User user) {
		repository.save(user);
	}

	@PutMapping()
	public void putUser(@RequestBody User user) {
		repository.save(user);
	}

}
