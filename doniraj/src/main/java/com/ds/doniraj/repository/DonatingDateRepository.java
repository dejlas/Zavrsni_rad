package com.ds.doniraj.repository;

import com.ds.doniraj.entity.DonatingDate;
import com.ds.doniraj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


@Repository
public interface DonatingDateRepository extends JpaRepository<DonatingDate, Long> {
    @Query(value = "SELECT * FROM donating_date d WHERE d.date = :date", nativeQuery = true)
    DonatingDate findByDate(@Param("date") Date date);

    List<DonatingDate> findByUser(User user);

}
