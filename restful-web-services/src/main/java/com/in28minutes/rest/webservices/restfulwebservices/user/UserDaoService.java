package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import java.util.function.Predicate;

@Component
public class UserDaoService {
	// all user
	// user(String user)
	// user findone(int id)

	private static List<User> users = new ArrayList<>();
	private static int count =0;

	static {
		users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++count, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++count, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id; 
		return users.stream().filter(predicate).findFirst().orElse(null);

	}

	public User createNewUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}

	public void deleteUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}

}
