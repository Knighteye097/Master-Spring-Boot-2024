package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;

	static {
		users.add(new User(++userCount, "Satyam", LocalDate.now().minusYears(24)));
		users.add(new User(++userCount, "Shivam", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Rohith", LocalDate.now().minusYears(23)));
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);

		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
