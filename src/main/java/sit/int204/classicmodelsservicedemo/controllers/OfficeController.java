package sit.int204.classicmodelsservicedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservicedemo.entities.Employee;
import sit.int204.classicmodelsservicedemo.entities.Office;
import sit.int204.classicmodelsservicedemo.services.OfficeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office>getAllOffices(){
        return service.getAllOffices();
    }

    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode){
        return service.getOffice(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployee(@PathVariable String officeCode){
        return service.getOfficeEmployee(officeCode);
    }

    @PostMapping("")
    public Office addNewOffice(@RequestBody Office office){
        return service.createNewOffice(office);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode) {
        return service.updateOffice(officeCode, office);
    }

    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode) {
        service.removeOffice(officeCode);
    }
}
