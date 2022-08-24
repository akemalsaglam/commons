package com.aks.commons.controller;

import com.aks.commons.security.SecurityContextUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class BaseDeleteRequest extends BaseRequest {
    private final @Email String deletedByEmail = SecurityContextUtil.getUserEmailFromContext();
    private final ZonedDateTime deletedTime = ZonedDateTime.now();
}
