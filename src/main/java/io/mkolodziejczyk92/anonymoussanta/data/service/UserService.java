package io.mkolodziejczyk92.anonymoussanta.data.service;

import io.mkolodziejczyk92.anonymoussanta.data.entity.User;
import io.mkolodziejczyk92.anonymoussanta.data.model.UserDto;
import io.mkolodziejczyk92.anonymoussanta.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static List<UserDto> getAllUsers() {
        return null;
    }
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    public void updateUserById(Long id, UserDto userDto) {
    }

    public void deleteUser(Long id) {
    }
    public User getUserById(String organizerId) {
        return userRepository.findById(Long.valueOf(organizerId)).orElseThrow();
    }

    public Long getUserIdByUsernameAsMail(String email) {
        return userRepository.findByEmail(email).get().getId();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow();
    }
}
