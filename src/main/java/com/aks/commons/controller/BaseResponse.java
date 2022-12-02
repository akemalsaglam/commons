package com.aks.commons.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BaseResponse implements Serializable {
    private @Email String createdBy;
    private LocalDateTime createdDate;
    private @Email String modifiedBy;
    private LocalDateTime modifiedDate;
}
