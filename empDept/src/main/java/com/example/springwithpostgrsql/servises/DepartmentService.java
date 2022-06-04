package com.example.springwithpostgrsql.servises;

import com.example.springwithpostgrsql.exceptions.NoutFoundEmployeeException;
import com.example.springwithpostgrsql.model.Department;
import com.example.springwithpostgrsql.model.Employee;
import com.example.springwithpostgrsql.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

// select * from Department
    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

// Add new department
    public Department addDepartment(Department department) {
        return this.departmentRepository.save(department);
    }
// update
    public Department updateDepartment( Department department) throws NoutFoundEmployeeException {
        return this.departmentRepository.save(department);
    }

// delete department
    public Map<String, Boolean> deleteDepartment(Long departmentId)
            throws NoutFoundEmployeeException {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NoutFoundEmployeeException("Department not found for this id :: " + departmentId));

        departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
