package br.com.uploadimageaws.controller;

import br.com.uploadimageaws.model.UserProfile;
import br.com.uploadimageaws.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfileImg() {
        return userProfileService.getUserProfiles();
    }

    @PostMapping(path = {"{userID}/img/upload"},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadUserProfileImage(@PathVariable("userID") UUID userID,
                                       @RequestParam("file")MultipartFile file) {
        userProfileService.uploadUserProfileImg(userID, file);
    }

    @GetMapping(path = {"{userID}/img/download"})
    public byte[] downloadUserProfileImg(@PathVariable("userID") UUID userID) {
        return userProfileService.downloadUserProfileImage(userID);
    }

}
