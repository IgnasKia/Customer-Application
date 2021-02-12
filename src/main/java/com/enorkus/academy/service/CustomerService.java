package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validator.CustomerValidator;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerValidator customerValidator;

    public CustomerService() {
        this.customerRepository = new MemoryCustomerRepository();
        this.customerValidator = new CustomerValidator();
    }

    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerValidator.validate(customer, "Validation failed");
        Customer newCustomer = new Customer.CustomerBuilder(
                capitalizeFirstLetter(customer.getFirstName()),
                capitalizeFirstLetter(customer.getLastName()),
                dashAfterFourDigits(customer.getPersonalNumber())
        )
                .middleName(customer.getMiddleName())
                .age(customer.getAge())
                .countryCode(customer.getCountryCode())
                .city(customer.getCity())
                .monthlyIncome(customer.getMonthlyIncome())
                .employer(customer.getEmployer())
                .gender(customer.getGender())
                .maritalStatus(customer.getMaritalStatus())
                .build();
        customerRepository.insert(newCustomer);
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    public String capitalizeFirstLetter(String word){
        if (word.isEmpty()){
            return word;
        } return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    public String dashAfterFourDigits(String number){
        if (number.length() < 4){
            return number;
        } return number.substring(0,4)+ "-" + number.substring(4);
    }
}
