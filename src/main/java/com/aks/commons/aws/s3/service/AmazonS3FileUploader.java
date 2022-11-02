package com.aks.commons.aws.s3.service;

import com.aks.commons.aws.AmazonSDKProperties;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

@Service
public class AmazonS3FileUploader implements FileUploader {

    private final AmazonSDKProperties amazonSDKProperties;
    private final AmazonS3 s3Client;

    @Autowired
    public AmazonS3FileUploader(AmazonSDKProperties amazonSDKProperties, AmazonS3 s3Client) {
        this.amazonSDKProperties = amazonSDKProperties;
        this.s3Client = s3Client;
    }

    @Override
    public PutObjectResult uploadFile(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(amazonSDKProperties.getS3BucketName(), key, file);
        return s3Client.putObject(putObjectRequest);
    }

    @Override
    public String createPresignedUrl(String key, HttpMethod httpMethod) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(amazonSDKProperties.getS3BucketName(), key).withMethod(httpMethod).withExpiration(getExpiration(httpMethod));
        return s3Client.generatePresignedUrl(generatePresignedUrlRequest).toString();
    }

    private Date getExpiration(HttpMethod httpMethod) {
        if (httpMethod == HttpMethod.GET) {
            return getGetExpiration();
        }
        return getPutExpiration();
    }

    private Date getPutExpiration() {
        Date expiration = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expiration);
        calendar.add(Calendar.HOUR, 2);
        expiration = calendar.getTime();
        return expiration;
    }

    private Date getGetExpiration() {
        Date expiration = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expiration);
        calendar.add(Calendar.DATE, 7);
        expiration = calendar.getTime();
        return expiration;
    }
}
