package com.ds.doniraj.service;

import com.ds.doniraj.entity.DonatingDate;
import com.ds.doniraj.entity.User;
import com.ds.doniraj.repository.DonatingDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DonatingDateService {

    @Autowired
    DonatingDateRepository donatingDateRepository;

    public DonatingDate findByDate(Date date) {
        DonatingDate donatingDate = donatingDateRepository.findByDate(date);
        return donatingDate;
    }

    public void saveDonatingDate(DonatingDate donatingDate) {

        donatingDateRepository.save(donatingDate);
    }

    public List<DonatingDate> findByUser(User user) {
        return donatingDateRepository.findByUser(user);
    }
}
