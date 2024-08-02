package org.gokapture.blogapi.services;



import org.gokapture.blogapi.exception.UserAlreadyExistsException;
import org.gokapture.blogapi.exception.UserDoesNotFoundException;
import org.gokapture.blogapi.models.User;
import org.gokapture.blogapi.repositories.UserRepository;
import org.gokapture.blogapi.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    public User signup(String username, String password) throws UserAlreadyExistsException  {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(username + " already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        User savedUser = userRepository.save(user);

        return savedUser;

    }

    public String login(String username, String password) throws UserDoesNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {

            throw new UserDoesNotFoundException("Username " + username + " Does Not Exist");

        }

        if (!passwordEncoder.matches(password, userOptional.get().getPassword())) {
            throw new UserDoesNotFoundException("Username " + username + " Password Does Not Match");
        }

        return JwtUtil.generateToken(username);

    }
}
