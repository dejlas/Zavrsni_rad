package com.ds.doniraj.converter;

import com.ds.doniraj.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PrivilegeWebConfig implements WebMvcConfigurer {
    @Autowired
    private PrivilegeService privilegeService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PrivilegeConverter(privilegeService));
    }
}

