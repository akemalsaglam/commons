package com.aks.commons.aws.mail.template;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

public class TemplateMapperConfiguration {

    public static final String MAIL_TEMPLATES_PATH = "/mail-templates";

    public FreeMarkerConfigurer getConfigurer(String mailTemplatePath) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        TemplateLoader templateLoader = new ClassTemplateLoader(this.getClass(), mailTemplatePath);
        configuration.setTemplateLoader(templateLoader);
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setConfiguration(configuration);
        return freeMarkerConfigurer;
    }

}
