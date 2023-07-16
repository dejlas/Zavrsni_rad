package com.ds.doniraj.converter;

import com.ds.doniraj.entity.Town;
import com.ds.doniraj.service.TownService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TownConverter implements Converter<String, Town> {
    private final TownService townService;
    @Override
    public Town convert(String name) {
        return townService.findByName(name);
    }
}
