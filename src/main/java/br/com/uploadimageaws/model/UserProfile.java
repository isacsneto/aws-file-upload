package br.com.uploadimageaws.model;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    //not final bcz im not using an actual db
    private UUID userID;
    private String userName;
    private String userProfileImage; //s3 key

    public UserProfile(UUID userID, String userName, String userProfileImage) {
        this.userID = userID;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Optional<String> getUserProfileImage() {
        return Optional.ofNullable(userProfileImage);
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userProfileImage, that.userProfileImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userName, userProfileImage);
    }
}
