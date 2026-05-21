```java
package com.example.core.service;

import com.example.core.model.UserProfile;
import com.example.core.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public Optional<UserProfile> getUserProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile updateUserProfile(Long id, UserProfile userProfileDetails) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserProfile not found with id: " + id));

        userProfile.setUsername(userProfileDetails.getUsername());
        userProfile.setEmail(userProfileDetails.getEmail());
        userProfile.setBio(userProfileDetails.getBio());
        userProfile.setAvatarUrl(userProfileDetails.getAvatarUrl());

        return userProfileRepository.save(userProfile);
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
```