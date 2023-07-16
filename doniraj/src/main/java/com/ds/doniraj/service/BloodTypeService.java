package com.ds.doniraj.service;

import com.ds.doniraj.entity.BloodType;
import com.ds.doniraj.repository.BloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodTypeService {

    @Autowired
    BloodTypeRepository bloodTypeRepository;

    public BloodType findBySymbol(String symbol){
        BloodType bloodType = bloodTypeRepository.findBySymbol(symbol);
        return bloodType;
    }

    public void saveBloodType(BloodType bloodType) {

        bloodTypeRepository.save(bloodType);
    }
}
