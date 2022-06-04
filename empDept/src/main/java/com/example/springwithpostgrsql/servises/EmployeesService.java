package com.example.springwithpostgrsql.servises;

import com.example.springwithpostgrsql.exceptions.NoutFoundEmployeeException;
import com.example.springwithpostgrsql.model.Employee;
import com.example.springwithpostgrsql.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesService {


    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getDeptEmps(long deptId) {
        return this.employeeRepo.findByDepartmentId(deptId);
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepo.findAll();
    }

    public ResponseEntity<Employee> getEmployeeById(Long employeeId)
            throws NoutFoundEmployeeException {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new NoutFoundEmployeeException("Eutmployee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    public Employee createEmp(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws NoutFoundEmployeeException {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new NoutFoundEmployeeException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setFname(employeeDetails.getFname());
        employee.setLname(employeeDetails.getLname());
        final Employee updatedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    public Map<String, Boolean> deleteEmployee(Long employeeId)
            throws NoutFoundEmployeeException {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new NoutFoundEmployeeException("Employee not found for this id :: " + employeeId));

        employeeRepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Employee> getEmpByFirstName(String firstName) {
        return this.employeeRepo.findByFname(firstName);
    }


    public List<Employee> getEmpٍSearch(String fname, String lname) {
        return this.employeeRepo.empSearch(fname, lname);
    }

    public List<Employee> getEmpByFirstNameOrLastName(String fname, String lname) {
        return this.employeeRepo.findByFnameOrLname(fname, lname);

    }

}
