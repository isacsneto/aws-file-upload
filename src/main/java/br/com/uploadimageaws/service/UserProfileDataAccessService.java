package br.com.uploadimageaws.service;

import br.com.uploadimageaws.datastore.FakeUserProfileData;
import br.com.uploadimageaws.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessService {

    private final FakeUserProfileData fakeUserProfileData;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileData fakeUserProfileData) {
        this.fakeUserProfileData = fakeUserProfileData;
    }

    List<UserProfile> getUserProfiles() {
        return fakeUserProfileData.getUserProfiles();
    }
}
