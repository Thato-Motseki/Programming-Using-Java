/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubuntusure.dao;

import ubuntusure.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportsDAO {

    public List<Object[]> getCustomerReport() throws SQLException {
        String sql = "SELECT customer_ID, firstname, surname, email, phone_number "
                   + "FROM CUSTOMER ORDER BY customer_ID";

        return executeReport(sql, null);
    }

    public List<Object[]> getPolicyReport(Date fromDate, Date toDate)
            throws SQLException {

        String sql = "SELECT p.policy_number, "
                   + "CONCAT(c.firstname, ' ', c.surname) AS customer_name, "
                   + "p.policy_type, p.start_date, p.end_date, "
                   + "p.annual_premium, p.status "
                   + "FROM INSURANCE_POLICY p "
                   + "INNER JOIN CUSTOMER c ON p.customer_ID = c.customer_ID "
                   + "WHERE 1=1";

        List<Object> parameters = new ArrayList<>();

        if (fromDate != null) {
            sql += " AND p.start_date >= ?";
            parameters.add(fromDate);
        }

        if (toDate != null) {
            sql += " AND p.start_date <= ?";
            parameters.add(toDate);
        }

        sql += " ORDER BY p.policy_ID";

        return executeReport(sql, parameters);
    }

    public List<Object[]> getClaimsReport(Date fromDate, Date toDate)
            throws SQLException {

        String sql = "SELECT cl.claim_number, "
                   + "CONCAT(c.firstname, ' ', c.surname) AS customer_name, "
                   + "p.policy_number, cl.date_submitted, "
                   + "cl.claim_amount, cl.status "
                   + "FROM CLAIM cl "
                   + "INNER JOIN INSURANCE_POLICY p ON cl.policy_id = p.policy_ID "
                   + "INNER JOIN CUSTOMER c ON p.customer_ID = c.customer_ID "
                   + "WHERE 1=1";

        List<Object> parameters = new ArrayList<>();

        if (fromDate != null) {
            sql += " AND DATE(cl.date_submitted) >= ?";
            parameters.add(fromDate);
        }

        if (toDate != null) {
            sql += " AND DATE(cl.date_submitted) <= ?";
            parameters.add(toDate);
        }

        sql += " ORDER BY cl.claim_ID";

        return executeReport(sql, parameters);
    }

    public List<Object[]> getPaymentsReport(Date fromDate, Date toDate)
            throws SQLException {

        String sql = "SELECT cp.payment_reference, cl.claim_number, "
                   + "cp.payment_date, cp.payment_amount, cp.payment_status "
                   + "FROM CLAIM_PAYMENT cp "
                   + "INNER JOIN CLAIM cl ON cp.claim_ID = cl.claim_ID "
                   + "WHERE 1=1";

        List<Object> parameters = new ArrayList<>();

        if (fromDate != null) {
            sql += " AND DATE(cp.payment_date) >= ?";
            parameters.add(fromDate);
        }

        if (toDate != null) {
            sql += " AND DATE(cp.payment_date) <= ?";
            parameters.add(toDate);
        }

        sql += " ORDER BY cp.payment_ID";

        return executeReport(sql, parameters);
    }

    private List<Object[]> executeReport(String sql, List<Object> parameters)
            throws SQLException {

        List<Object[]> results = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            if (parameters != null) {
                for (int i = 0; i < parameters.size(); i++) {
                    statement.setObject(i + 1, parameters.get(i));
                }
            }

            try (ResultSet rs = statement.executeQuery()) {
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();

                while (rs.next()) {
                    Object[] row = new Object[columnCount];

                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }

                    results.add(row);
                }
            }
        }

        return results;
    }
}