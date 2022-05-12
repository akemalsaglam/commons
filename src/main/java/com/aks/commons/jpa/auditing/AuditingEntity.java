package com.aks.commons.jpa.auditing;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class AuditingEntity {

    @Email
    private String createdByEmail;
    private ZonedDateTime createdTime;

    @Email
    private String updatedByEmail;
    private ZonedDateTime updatedTime;

    @Email
    private String deletedByEmail;
    private ZonedDateTime deletedTime;

}
