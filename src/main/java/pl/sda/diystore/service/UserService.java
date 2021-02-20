package pl.sda.diystore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.diystore.model.User;
import pl.sda.diystore.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("No such user in database"));
    }
    public User update(User user){
        return userRepository.save(user);
    }

    public void remove(Long id){
        userRepository.delete(get(id));
    }
}
