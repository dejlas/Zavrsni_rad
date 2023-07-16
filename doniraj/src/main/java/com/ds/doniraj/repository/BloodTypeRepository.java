package com.ds.doniraj.repository;

import com.ds.doniraj.entity.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
    @Query(value = "SELECT * FROM blood_type b WHERE b.symbol = :symbol", nativeQuery = true)
    BloodType findBySymbol(@Param("symbol") String symbol);
}
