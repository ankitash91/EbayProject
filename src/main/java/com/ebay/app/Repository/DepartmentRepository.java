package com.ebay.app.Repository;

import com.ebay.app.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("update Department d set d.name = :name WHERE d.id = :id")
    @Modifying
    void updateDepartmentName(@Param("id") Integer id, @Param("name") String name);

}
