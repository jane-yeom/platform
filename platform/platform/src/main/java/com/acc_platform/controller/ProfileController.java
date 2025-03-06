package com.acc_platform.controller;

import com.acc_platform.model.Profile;
import com.acc_platform.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@Validated @RequestBody Profile profile) {
        Profile created = profileService.registerProfile(profile);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getMyProfile(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        if(profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    // 프로필 수정 (또는 등록 후 수정)
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateMyProfile(@PathVariable Long id, @Validated @RequestBody Profile profile) {
        Profile updated = profileService.updateProfile(id, profile);
        return ResponseEntity.ok(updated);
    }
}
