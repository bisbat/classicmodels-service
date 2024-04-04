package sit.int204.classicmodelsservicedemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Integer employeeNumber;
    //connected with Office
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;
    @Column(name = "email", nullable = false, length = 100)
    private String email;



    //connected itself
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee employees;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;

    //connected with Customer
    @JsonIgnore
    @OneToMany(mappedBy = "sales")
    private Set<Customer> customers=new LinkedHashSet<>();

}

