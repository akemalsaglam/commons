package com.aks.commons.jpa.auditing;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
