package springboot.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.entity.User;

public interface UsereRepository extends JpaRepository<User, Integer> {
}
