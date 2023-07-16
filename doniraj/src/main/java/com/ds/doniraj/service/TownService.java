package com.ds.doniraj.service;

import com.ds.doniraj.entity.Town;
import com.ds.doniraj.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TownService {

    @Autowired
    TownRepository townRepository;

    public Town findByName(String name){
        Town town = townRepository.findByName(name);
        return town;
    }

    public void saveTown(Town town) {

        townRepository.save(town);
    }
}
