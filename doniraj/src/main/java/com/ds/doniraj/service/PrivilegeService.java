package com.ds.doniraj.service;

import com.ds.doniraj.entity.Privilege;
import com.ds.doniraj.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public Privilege findByRole(String role){
        Privilege privilege = privilegeRepository.findByRole(role);
        return privilege;
    }
    public void savePrivilege(Privilege privilege) {
        privilegeRepository.save(privilege);
    }
}
