package uz.mamatsalay.incomemanagementservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.mamatsalay.incomemanagementservice.model.User;
import uz.mamatsalay.incomemanagementservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

}
