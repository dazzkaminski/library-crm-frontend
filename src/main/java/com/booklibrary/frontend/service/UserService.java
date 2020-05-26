package com.booklibrary.frontend.service;

import com.booklibrary.frontend.dto.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  @Value("${library.users.endpoint}")
  private String usersEndpoint;

  @Autowired private RestTemplate restTemplate;

  public List<User> getUsers() {

    User[] users = restTemplate.getForObject(usersEndpoint, User[].class);

    return Arrays.asList(Optional.ofNullable(users).orElse(new User[0]));
  }

  public List<User> search(String userName) {

    User[] users =
        restTemplate.getForObject(usersEndpoint + "/search/" + userName, User[].class);

    return Arrays.asList(Optional.ofNullable(users).orElse(new User[0]));
  }

  public User getUser(int id) {

    User user = restTemplate.getForObject(usersEndpoint + "/" + id, User.class);

    return user;
  }

  public void createUser(User user) {
    restTemplate.postForObject(usersEndpoint, user, User.class);
  }

  public void delete(int id) {
    restTemplate.delete(usersEndpoint + "/" + id);
  }
}
