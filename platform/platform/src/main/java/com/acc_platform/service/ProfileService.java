package com.acc_platform.service;

import com.acc_platform.mapper.ProfileMapper;
import com.acc_platform.model.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileMapper profileMapper;

    public ProfileService(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    @Transactional
    public Profile registerProfile(Profile profile) {
        profileMapper.insertProfile(profile);
        return profile;
    }

    public List<Profile> getAllProfiles() {
        return profileMapper.findAllProfiles();
    }

    public Profile getProfileById(Long id) {
        return profileMapper.findProfileById(id);
    }

    @Transactional
    public Profile updateProfile(Long id, Profile updatedProfile) {
        Profile existing = profileMapper.findProfileById(id);
        if(existing == null) {
            throw new RuntimeException("프로필이 존재하지 않습니다.");
        }
        existing.setName(updatedProfile.getName());
        existing.setSkill(updatedProfile.getSkill());
        existing.setInstrument(updatedProfile.getInstrument());
        existing.setContent(updatedProfile.getContent());
        existing.setPortfolioUrl(updatedProfile.getPortfolioUrl());
        existing.setAvailability(updatedProfile.getAvailability());
        existing.setRegion(updatedProfile.getRegion());
        profileMapper.updateProfile(existing);
        return existing;
    }
}
