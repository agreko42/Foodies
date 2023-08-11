package com.foodies.backend.endpoint;


import com.foodies.backend.security.config.JwtService;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserEndpointService userEndpointService;
    private final JwtService jwtService;

    @GetMapping("/{userId}/following")
    public ResponseEntity<List<UserDTO>> getFollowing(@PathVariable Long userId) {
        List<UserDTO> followingUsers = userEndpointService.getFollowing(userId);
        return ResponseEntity.ok(followingUsers);
    }

    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<UserDTO>> getFollowers(@PathVariable Long userId) {
        List<UserDTO> followers = userEndpointService.getFollowers(userId);
        return ResponseEntity.ok(followers);
    }

    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Long userIdToFollow, @RequestHeader String authorization) {
        String pureToken = authorization.substring(7);
        String username = jwtService.extractUsername(pureToken);
        userEndpointService.followUser(userIdToFollow, username);
        return ResponseEntity.ok().build();
    }
}
