package com.ds.doniraj.converter;

import com.ds.doniraj.entity.Privilege;
import com.ds.doniraj.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrivilegeConverter implements Converter<String, Privilege> {
    private final PrivilegeService privilegeService;

    @Override
    public Privilege convert(String role) {
        return privilegeService.findByRole(role);
    }
}
