package com.aks.commons.aws.s3.service;

import com.aks.commons.controller.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PresignedUrlRequest extends BaseRequest {
    String fileName;
}
