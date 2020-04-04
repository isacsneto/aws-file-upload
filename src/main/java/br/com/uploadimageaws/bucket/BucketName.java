package br.com.uploadimageaws.bucket;

public enum BucketName {

    PROFILE_IMAGE("isac-userprofileimage-aws");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
