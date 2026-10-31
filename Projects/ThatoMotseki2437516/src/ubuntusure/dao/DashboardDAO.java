/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.dao;

import ubuntusure.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardDAO {


public int getTotalCustomers() throws SQLException {
    return getCount("SELECT COUNT(*) FROM CUSTOMER");
}

public int getTotalPolicies() throws SQLException {
    return getCount("SELECT COUNT(*) FROM INSURANCE_POLICY");
}

public int getTotalClaims() throws SQLException {
    return getCount("SELECT COUNT(*) FROM CLAIM");
}

private int getCount(String sql) throws SQLException {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        return 0;
    }
}


}

