package sit.int204.classicmodelsservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
}
