package com.ds.doniraj.repository;

import com.ds.doniraj.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    @Query(value = "SELECT * FROM Privileges p WHERE p.role = :role", nativeQuery = true)
    Privilege findByRole(@Param("role") String role);
}
