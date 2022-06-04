package com.example.springwithpostgrsql.repo;

import com.example.springwithpostgrsql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    public List<Employee> findByFname(String firstName);

    public List<Employee> findByFnameOrLname(String lname, String fname);

    @Query("select emp from Employee emp where emp.lname =:lnameBind and emp.fname=:fnameBind")
    public List<Employee> empSearch(@Param("fnameBind") String firstName, @Param("lnameBind") String lastName);

    public List<Employee> findByDepartmentId(long departmentId);
}
