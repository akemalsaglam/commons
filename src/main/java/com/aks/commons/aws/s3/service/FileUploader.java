package com.aks.commons.aws.s3.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

public interface FileUploader {

    PutObjectResult uploadFile(String key, File file);

    String createPresignedUrl(String key, HttpMethod httpMethod);
}
