/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.dao;

/**
 *
 * @author thato
 */
import ubuntusure.config.DatabaseConnection;
import ubuntusure.model.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public boolean registerCustomer(Customer customer)
            throws SQLException {

        String sql = "INSERT INTO CUSTOMER "
                + "(registered_by_user_ID, firstname, surname, "
                + "national_ID, DOB, gender, phone_number, email, address) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection
                = DatabaseConnection.getConnection(); PreparedStatement statement
                = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, customer.getRegisteredByUserID());
            statement.setString(2, customer.getFirstname());
            statement.setString(3, customer.getSurname());
            statement.setString(4, customer.getNationalID());
            statement.setDate(5, Date.valueOf(customer.getDateOfBirth()));
            statement.setString(6, customer.getGender());
            statement.setString(7, customer.getPhoneNumber());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getAddress());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted == 1) {
                try (ResultSet keys = statement.getGeneratedKeys()) {
                    if (keys.next()) {
                        customer.setCustomerID(keys.getInt(1));
                    }
                }
                return true;
            }

            return false;
        }
    }

    public boolean nationalIDExists(String nationalID) throws Exception {

        String sql = "SELECT COUNT(*) FROM CUSTOMER WHERE national_ID = ?";

        try (java.sql.Connection connection
                = ubuntusure.config.DatabaseConnection.getConnection(); java.sql.PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setString(1, nationalID.trim());

            try (java.sql.ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }

        return false;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT customer_ID, firstname, surname, national_ID, "
                + "DOB, gender, phone_number, email, address "
                + "FROM CUSTOMER ORDER BY customer_ID DESC";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();

                customer.setCustomerID(resultSet.getInt("customer_ID"));
                customer.setFirstname(resultSet.getString("firstname"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setNationalID(resultSet.getString("national_ID"));

                java.sql.Date dob = resultSet.getDate("DOB");
                if (dob != null) {
                    customer.setDateOfBirth(dob.toLocalDate());
                }

                customer.setGender(resultSet.getString("gender"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));

                customers.add(customer);
            }
        }

        return customers;

    }

}
