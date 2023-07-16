package com.ds.doniraj.converter;

import com.ds.doniraj.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TownWebConfig implements WebMvcConfigurer {

    @Autowired
    private TownService townService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new TownConverter(townService));
    }
}
