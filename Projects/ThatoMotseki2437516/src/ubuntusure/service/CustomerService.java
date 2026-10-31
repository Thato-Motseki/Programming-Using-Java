/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.service;

/**
 *
 * @author thato
 */
import ubuntusure.dao.CustomerDAO;
import ubuntusure.model.Customer;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public CustomerService(CustomerDAO customerDAO) {
        if (customerDAO == null) {
            throw new IllegalArgumentException(
                    "CustomerDAO cannot be null."
            );
        }

        this.customerDAO = customerDAO;
    }

    public void registerCustomer(Customer customer) throws Exception {

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer information is required."
            );
        }

        validateCustomer(customer);

        if (customerDAO.nationalIDExists(customer.getNationalID())) {
            throw new IllegalArgumentException(
                    "A customer with this national ID or passport number already exists."
            );
        }

        customerDAO.registerCustomer(customer);
    }

    private void validateCustomer(Customer customer) {

        if (isBlank(customer.getFirstname())) {
            throw new IllegalArgumentException(
                    "First name is required."
            );
        }

        if (isBlank(customer.getSurname())) {
            throw new IllegalArgumentException(
                    "Surname is required."
            );
        }

        if (isBlank(customer.getNationalID())) {
            throw new IllegalArgumentException(
                    "National ID or passport number is required."
            );
        }

        if (customer.getDateOfBirth() == null) {
            throw new IllegalArgumentException(
                    "Date of birth is required."
            );
        }

        if (!customer.getDateOfBirth().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Date of birth must be in the past."
            );
        }

        if (isBlank(customer.getGender())) {
            throw new IllegalArgumentException(
                    "Gender is required."
            );
        }

        if (isBlank(customer.getPhoneNumber())
                || !customer.getPhoneNumber()
                        .matches("[+]?[0-9() -]{7,20}")) {
            throw new IllegalArgumentException(
                    "Enter a valid phone number."
            );
        }

        if (isBlank(customer.getEmail())
                || !Pattern.matches(
                        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                        customer.getEmail().trim())) {
            throw new IllegalArgumentException(
                    "Enter a valid email address."
            );
        }

        if (isBlank(customer.getAddress())) {
            throw new IllegalArgumentException(
                    "Residential address is required."
            );
        }

        if (customer.getRegisteredByUserID() <= 0) {
            throw new IllegalArgumentException(
                    "A valid registering officer must be selected."
            );
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
