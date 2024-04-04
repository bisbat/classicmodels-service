package sit.int204.classicmodelsservicedemo.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservicedemo.entities.Employee;
import sit.int204.classicmodelsservicedemo.entities.Office;
import sit.int204.classicmodelsservicedemo.repositories.OfficeRepository;

import java.util.List;
import java.util.Set;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices(){
        return officeRepository.findAll();
    }

    public Office getOffice(String officeCode){
        return officeRepository.findById(officeCode).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Office Id "+officeCode+" DOES NOT EXIST!!!")
        );
    }
    // Get all employee for office id = ... eg. Get all employee for office id = 1
    public Set<Employee> getOfficeEmployee(String officeCode){
        Office office=officeRepository.findById(officeCode).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Office Id "+officeCode+" DOES NOT EXIST!!!")
        );
        return office.getEmployees();
    }
    @Transactional
    public Office createNewOffice(Office office){
        return officeRepository.save(office);
    }

    @Transactional
    public void removeOffice(String officeCode){
        Office office=officeRepository.findById(officeCode).orElseThrow(
                ()->new HttpClientErrorException(HttpStatus.NOT_FOUND,"Office Id "+officeCode+" DOES NOT EXIST!!!")
        );
        officeRepository.delete(office);
    }

    @Transactional
    public Office updateOffice(String officeCode,Office office){
        if(office.getOfficeCode()!=null&&!office.getOfficeCode().trim().isEmpty()){
            if (!office.getOfficeCode().equals(officeCode)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                        "Conflict Office code  !!! (" + officeCode +
                                " vs " + office.getOfficeCode() + ")");
            }
        }
        Office existingOffice = officeRepository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        return officeRepository.save(office);
    }
}
