package pro.sky.stream_api_optional1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.stream_api_optional1.model.Employee;
import pro.sky.stream_api_optional1.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeContrller {
    private final EmployeeService service;


    public EmployeeContrller(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/departments/max-salary")
    public Employee getMaxSalaryByDept (@RequestParam("departmentsId") Integer id) {
        return service.getMaxSalaryByDept(id);
    }
    @GetMapping("/departments/min-salary")
    public Employee getMinSalaryByDept (@RequestParam ("departmentsId") Integer id) {
        return service.getMaxSalaryByDept(id);
    }
    @GetMapping("/departments/all")
    public Map<Integer , List<Employee>> getEmployeeByDept (@RequestParam(value = "departmentsId", required = false ) Integer id) {
        if (id == null) {
            return  service.showAll();
        }
        return  service.showAllDept(id);
    }


}
