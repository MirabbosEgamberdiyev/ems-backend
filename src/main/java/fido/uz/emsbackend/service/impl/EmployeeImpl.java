package fido.uz.emsbackend.service.impl;

import fido.uz.emsbackend.dto.EmployeeDto;
import fido.uz.emsbackend.entity.Employee;
import fido.uz.emsbackend.exception.ResourceNotFoundException;
import fido.uz.emsbackend.mapper.EmployeeMapper;
import fido.uz.emsbackend.repository.EmployeeRepository;
import fido.uz.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDtos.add(EmployeeMapper.mapToEmployeeDto(employee));
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exist with given " + employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee save = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(save);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exist with given " + employeeId));
        employeeRepository.delete(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

}
