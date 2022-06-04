package com.example.springwithpostgrsql.homeController;

import com.example.springwithpostgrsql.exceptions.NoutFoundEmployeeException;
import com.example.springwithpostgrsql.model.Department;
import com.example.springwithpostgrsql.model.Employee;
import com.example.springwithpostgrsql.servises.DepartmentService;
import com.example.springwithpostgrsql.servises.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vrr/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // get All departments
    @GetMapping("departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }
    // add new  department
    @PostMapping("departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

// delete department
    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long departmentId)
            throws NoutFoundEmployeeException {
        return departmentService.deleteDepartment(departmentId);
    }

    @PutMapping("/departments")
    public Department updateEmployee(@RequestBody Department department) throws NoutFoundEmployeeException {
        return departmentService.updateDepartment(department);
    }


}
