package pl.sda.diystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.diystore.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
