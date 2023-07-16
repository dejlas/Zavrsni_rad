package com.ds.doniraj.repository;

import com.ds.doniraj.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    @Query(value = "SELECT * FROM Towns t WHERE t.name = :name", nativeQuery = true)
    Town findByName(@Param("name") String name);
}
