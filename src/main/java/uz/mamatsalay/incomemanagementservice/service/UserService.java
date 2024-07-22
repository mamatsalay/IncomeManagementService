package uz.mamatsalay.incomemanagementservice.service;

import org.springframework.stereotype.Service;
import uz.mamatsalay.incomemanagementservice.model.User;
import uz.mamatsalay.incomemanagementservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}