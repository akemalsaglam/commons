package com.aks.commons.aws.s3.service;

import com.amazonaws.HttpMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class PresignedUrlService {

    private static final String X_AMZ_DATE = "X-Amz-Date";
    private static final String X_AMZ_EXPIRES = "X-Amz-Expires";
    private final AmazonS3FileUploader fileUploader;

    @Autowired
    public PresignedUrlService(AmazonS3FileUploader fileUploader) {
        this.fileUploader = fileUploader;
    }

    public String refreshPresignedUrl(String presignedUrl)
            throws URISyntaxException, ParseException, MalformedURLException {
        List<NameValuePair> params =
                URLEncodedUtils.parse(new URI(presignedUrl), StandardCharsets.UTF_8);
        final String createdDate = getValueFromPresignedUrl(params, X_AMZ_DATE);
        final String expireSeconds = getValueFromPresignedUrl(params, X_AMZ_EXPIRES);

        final String yearString = createdDate.substring(0, 4);
        final String monthString = createdDate.substring(4, 6);
        final String dayString = createdDate.substring(6, 8);

        final Instant instant = getExpiredDate(expireSeconds, yearString, monthString, dayString);

        if (Instant.now().plus(1, ChronoUnit.DAYS).isAfter(instant)) {
            final String path = new URL(presignedUrl).getPath();
            final String fileKey = URLDecoder.decode(path.substring(1), StandardCharsets.UTF_8);
            return fileUploader.createPresignedUrl(fileKey, HttpMethod.GET);
        } else {
            return presignedUrl;
        }
    }

    private String getValueFromPresignedUrl(List<NameValuePair> params, String xAmzDate) {
        return params.stream()
                .filter(item -> item.getName().equals(xAmzDate))
                .findFirst()
                .get()
                .getValue();
    }

    private Instant getExpiredDate(
            String expireSeconds, String yearString, String monthString, String dayString)
            throws ParseException {
        String createdDateString = monthString + "-" + dayString + "-" + yearString;
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date date = df.parse(createdDateString);
        return date.toInstant().plusSeconds(Long.parseLong(expireSeconds));
    }
}
