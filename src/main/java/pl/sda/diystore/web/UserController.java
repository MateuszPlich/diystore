package pl.sda.diystore.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.sda.diystore.model.User;
import pl.sda.diystore.service.UserService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Transactional
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}/user")
    public ResponseEntity<User> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.get(userId));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PatchMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{userId}/user")
    public ResponseEntity<Boolean> delete(@PathVariable Long userId) {
        userService.remove(userId);
        return ResponseEntity.ok(true);
    }
}
