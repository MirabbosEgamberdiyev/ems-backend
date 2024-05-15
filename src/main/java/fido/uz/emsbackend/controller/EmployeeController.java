package fido.uz.emsbackend.controller;

import fido.uz.emsbackend.dto.AddEmployeeDto;
import fido.uz.emsbackend.dto.EmployeeDto;
import fido.uz.emsbackend.entity.Employee;
import fido.uz.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmloyee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeById = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeById);
    }
    @GetMapping("/get-all-amployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAll();
        return ResponseEntity.ok(employeeDtos);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody AddEmployeeDto employeeDto) {
        Employee employee = employeeService.addEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }


    @PostMapping("/test")
    public ResponseEntity<Employee> test(@Valid @RequestBody AddEmployeeDto employeeDto) {
        Employee employee = employeeService.addEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }
}
