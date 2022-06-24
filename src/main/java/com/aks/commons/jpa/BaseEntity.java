package com.aks.commons.jpa;

import com.aks.commons.jpa.auditing.AuditingEntity;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity extends AuditingEntity {

    private String status;
}
