package com.aks.commons.jpa.auditing;


import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.security.SecurityContextUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuditingUtil {

    public static void setCreateAuditInfo(BaseEntity baseEntity) {
        baseEntity.setCreatedByEmail(SecurityContextUtil.getUserEmailFromContext());
        baseEntity.setCreatedTime(ZonedDateTime.now());
    }

    public static void setUpdateAuditInfo(BaseEntity baseEntity) {
        baseEntity.setUpdatedByEmail(SecurityContextUtil.getUserEmailFromContext());
        baseEntity.setUpdatedTime(ZonedDateTime.now());
    }

    public static void setDeleteAuditInfo(BaseEntity baseEntity) {
        baseEntity.setDeletedByEmail(SecurityContextUtil.getUserEmailFromContext());
        baseEntity.setDeletedTime(ZonedDateTime.now());
    }
}
