package br.com.uploadimageaws.service;

import br.com.uploadimageaws.model.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public interface UserProfileService {

    List<UserProfile> getUserProfiles();

    void uploadUserProfileImg(UUID userProfileId, MultipartFile file);

    byte[] downloadUserProfileImage(UUID userId);
}
