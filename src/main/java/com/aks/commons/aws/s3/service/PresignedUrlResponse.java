package com.aks.commons.aws.s3.service;

import com.aks.commons.controller.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class PresignedUrlResponse extends BaseRequest {
    String getUrl;
    String putUrl;
}
