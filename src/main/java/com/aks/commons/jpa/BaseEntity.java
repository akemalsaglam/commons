package com.aks.commons.jpa;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    private Status status;
}
