package fido.uz.emsbackend.service;

import fido.uz.emsbackend.dto.EmployeeDto;
import fido.uz.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAll();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
    EmployeeDto deleteEmployee(Long employeeId);
}
