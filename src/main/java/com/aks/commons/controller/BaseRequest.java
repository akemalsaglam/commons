package com.aks.commons.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class BaseRequest implements Serializable {
    private Object id;
    private @Email String createdByEmail;
    private ZonedDateTime createdTime;
    private @Email String updatedByEmail;
    private ZonedDateTime updatedTime;
    private @Email String deletedByEmail;
    private ZonedDateTime deletedTime;

}
