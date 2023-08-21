package com.foodies.backend.endpoint;

import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserDTO;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEndpointService {

    private final UserRepository userRepository;


    public List<UserDTO> getFollowing(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
        List<User> followingUsers = user.getUserFollowing();
        return followingUsers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getFollowers(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
        List<User> followers = user.getFollowers();
        return followers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public void followUser(String userNameToFollow, String username) {
        User currentUser = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        User userToFollow = userRepository.findByUsername(userNameToFollow).orElseThrow(() -> new RuntimeException("User not found"));

        if(currentUser.getUserFollowing().contains(userToFollow)) {
            throw new RuntimeException("You are already following this user");
        }

        currentUser.getUserFollowing().add(userToFollow);
        userToFollow.getFollowers().add(currentUser);
        userRepository.save(currentUser);
        userRepository.save(userToFollow);
    }
}
