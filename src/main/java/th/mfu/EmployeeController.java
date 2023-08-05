package th.mfu;

import java.util.Collection;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    // Create Hashmap for DB
    @Autowired
    private EmployeeRespository employeeRespository;

    // Select all Employee
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeRespository.findAll();
    }

    // Select Employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable long id) {
        Optional<Employee> optEmlpoyee = employeeRespository.findById(id);

        // check if id is null
        if (!optEmlpoyee.isPresent()) {
            // return error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        Employee emp = optEmlpoyee.get();
        return ResponseEntity.ok(emp);
    }

    // Select Employee by First name
    @GetMapping("/employees/firstname/{fname}")
    public ResponseEntity getEmployeeByName(@PathVariable String fname) {
        List<Employee> employee = employeeRespository.findByfname(fname);

        if (employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.ok(employee);
    }

    // Create New Employee

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        // chesk if id already exist

        // add new employee to respository
        employeeRespository.save(employee);

        // retrun success message
        return ResponseEntity.ok("Employee created success!");
    }

    // update employee with some fields using patch
    // @PatchMapping("/employees/{id}")
    // public ResponseEntity<String> patchEmployee(@PathVariable long id,
    // @RequestBody HashMap<String, Object> fieldstoupdate) {
    // // check if id not exists
    // if (!employeesDB.containsKey(id)) {
    // // return error message
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not
    // found");
    // }

    // // get employee from db
    // Employee emp = employeesDB.get(id);
    // // loop throught fields to update
    // fieldstoupdate.forEach((key, value) -> {
    // // check if field is firstname
    // if (key.equals("fname")) {
    // // update firstname
    // emp.setFname((String) value);
    // }
    // // check if field is lastname
    // if (key.equals("lname")) {
    // // update lastname
    // emp.setLname((String) value);
    // }
    // // check if field is salary
    // if (key.equals("salary")) {
    // // update salary
    // emp.setSalary(Long.valueOf("" + value));
    // }

    // });

    // // update employee
    // employeesDB.put(id, emp);

    // // return success message
    // return ResponseEntity.ok("Employee updated");
    // }

    // update employee
    @PutMapping("/employees/")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        // check if id not exists
        if (!employeeRespository.existsById(employee.getId())) {
            // return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        // update employee
        employeeRespository.save(employee);

        // return success message
        return ResponseEntity.ok("Employee updated");
    }

    // Delete Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        // check if id not exists
        if (!employeeRespository.existsById(id)) {
            // return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        // delete employee
        employeeRespository.deleteById(id);

        // return success message
        return ResponseEntity.ok("Employee deleted");
    }

}
