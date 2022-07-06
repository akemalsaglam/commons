package com.aks.commons.aws.mail.template;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BaseMailTemplateModel {

    public Map<String, Object> getModelMap() {
        final Field[] declaredFields = this.getClass().getDeclaredFields();
        final HashMap<String, Object> templateModelMap = new HashMap<>();
        try {
            for (Field declaredField : declaredFields) {
                templateModelMap.put(declaredField.getName(), declaredField.get(this));
            }
        } catch (IllegalAccessException e) {
            log.error("message='getting error while mapping mail template data.'");
        }
        return templateModelMap;
    }
}
