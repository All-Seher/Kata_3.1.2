package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.entity.User;
import springboot.repositor.UsereRepository;

import java.util.List;

@Service
@Transactional
public class UserSrvice {

    private final UsereRepository usereRepository;

    @Autowired
    public UserSrvice(UsereRepository usereRepository) {
        this.usereRepository = usereRepository;
    }

    public List<User> listAll() {
        return usereRepository.findAll();
    }

    public void save(User user) {
        usereRepository.save(user);
    }

    public User get(int id) {
        return usereRepository.findById(id).get();
    }

    public void delete(int id) {
        usereRepository.deleteById(id);
    }
}
