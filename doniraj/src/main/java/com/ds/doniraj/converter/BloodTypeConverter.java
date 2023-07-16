package com.ds.doniraj.converter;

import com.ds.doniraj.entity.BloodType;
import com.ds.doniraj.service.BloodTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BloodTypeConverter implements Converter<String, BloodType> {
    private final BloodTypeService bloodTypeService;

    @Override
    public BloodType convert(String symbol) {
        return bloodTypeService.findBySymbol(symbol);
    }
}

