package ubuntusure.dao;

import ubuntusure.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ubuntusure.dao.PolicyDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class PolicyDAO {

    public List<Object[]> getAllPolicies() throws SQLException {

        List<Object[]> policies = new ArrayList<>();

        String sql = """
            SELECT
                p.policy_ID,
                p.policy_number,
                CONCAT(c.firstname, ' ', c.surname) AS customer_name,
                p.policy_type,
                p.coverage_amount,
                p.annual_premium,
                p.start_date,
                p.end_date,
                p.status
            FROM INSURANCE_POLICY p
            INNER JOIN CUSTOMER c
                ON p.customer_ID = c.customer_ID
            ORDER BY p.created_at DESC
            """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Object[] row = {
                    rs.getInt("policy_ID"),
                    rs.getString("policy_number"),
                    rs.getString("customer_name"),
                    rs.getString("policy_type"),
                    rs.getBigDecimal("coverage_amount"),
                    rs.getBigDecimal("annual_premium"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getString("status")
                };

                policies.add(row);
            }
        }

        return policies;
    }

    
}
