package springboot.service;

import springboot.entity.User;

import java.util.List;

public interface UserService {
     List<User> listAll();
     void save(User user);
     User get(int id);
     void delete(int id);
}
