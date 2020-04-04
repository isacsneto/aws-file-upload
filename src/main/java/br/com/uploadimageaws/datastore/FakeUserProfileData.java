package br.com.uploadimageaws.datastore;

import br.com.uploadimageaws.model.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileData {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("a06f5d9c-ac9c-4736-8f32-dadfa28a6590"), "Roberto", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("50b0e763-37cf-457c-934f-29459a14b104"), "Jane", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
