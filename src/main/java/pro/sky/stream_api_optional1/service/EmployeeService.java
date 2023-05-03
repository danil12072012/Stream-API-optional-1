package pro.sky.stream_api_optional1.service;

import org.springframework.stereotype.Service;
import pro.sky.stream_api_optional1.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class EmployeeService {
    private final ValidatorServce validatorServce;

    private Employee[] staff = new Employee[10];
    EmployeeService(ValidatorServce validatorServce) {
        this.validatorServce = validatorServce;
        staff [0] = new Employee();
        staff [1] = new Employee();
        staff [2] = new Employee();
        staff [3] = new Employee();
        staff [4] = new Employee();
        staff [5] = new Employee();
        staff [6] = new Employee();
        staff [7] = new Employee();
        staff [8] = new Employee();
        staff [9] = new Employee();
    }
    public Employee getMaxSalaryByDept(int department) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Нет сотрудников в отделе"));
    }
    public Employee getMinSalaryByDept(int department) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Нет сотрудников в отделе"));
    }
    public Map<Integer, List<Employee>> showAll() {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .collect(Collectors.groupingBy(Employee ::getDepartment));

    }
    public Map<Integer, List<Employee>> showAllDept(int department) {
        return (Map<Integer , List<Employee>>) Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());


    }
    public Employee add (String nameEmployee,
                         String surnameEmployee,
                         String patronymicEmployee,
                         int department,
                         int salary) {
        Employee employee = new Employee(
        );

        return employee;
    }

}
