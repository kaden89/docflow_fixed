package ru.karachurin.docflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends BaseEntity {
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "POSITION")
    private String position;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "executor")
    private List<Order> ordersToExecute;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Order> givenOrders;
    @Transient
    private String name;

    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName, String middleName, String position, Organization organization) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.organization = organization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Order> getOrdersToExecute() {
        return ordersToExecute;
    }

    public void setOrdersToExecute(List<Order> ordersToExecute) {
        this.ordersToExecute = ordersToExecute;
    }

    public List<Order> getGivenOrders() {
        return givenOrders;
    }

    public void setGivenOrders(List<Order> givenOrders) {
        this.givenOrders = givenOrders;
    }

    public String getName() {
        return firstName+" "+lastName+" "+middleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", organization=" + organization +
                '}';
    }
}
