package com.example.springwithpostgrsql.homeController;

import com.example.springwithpostgrsql.exceptions.NoutFoundEmployeeException;
import com.example.springwithpostgrsql.model.Employee;
import com.example.springwithpostgrsql.repo.EmployeeRepo;
import com.example.springwithpostgrsql.servises.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vr/")
public class EmployeeController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("employees")
    public List<Employee> getAllEmployee() {
        return employeesService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws NoutFoundEmployeeException {
        return employeesService.getEmployeeById(employeeId);
    }

    @PostMapping("employees")
    public Employee createEmp(@RequestBody Employee employee) {
        return employeesService.createEmp(employee);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,  @RequestBody Employee employeeDetails) throws NoutFoundEmployeeException {
        return employeesService.updateEmployee(employeeId,employeeDetails);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws NoutFoundEmployeeException {
        return employeesService.deleteEmployee(employeeId);
    }
    @GetMapping("/getByName/{f}")
    public List<Employee> getEmployeeByFistName(@PathVariable(value = "f") String f)
            throws NoutFoundEmployeeException {
        return employeesService.getEmpByFirstName(f);
    }


    @GetMapping("/empsearch")
    public List<Employee> getEmployeeByFistNameAndLastName(@RequestParam String fname,@RequestParam String lname)
            throws NoutFoundEmployeeException {
        return employeesService.getEmpٍSearch(fname,lname);
    }


    @GetMapping("/getByLnameOrFname")
    public List<Employee> getEmployeeByFistNameorLast(@RequestParam String fname,@RequestParam String lname)
            throws NoutFoundEmployeeException {
        return employeesService.getEmpByFirstNameOrLastName(fname,lname);
    }
  @GetMapping("departments/{deptId}/employees")
   public List<Employee> getEmployeeByDeptID(@PathVariable long deptId) {
       return employeesService.getDeptEmps(deptId);
   }


}
