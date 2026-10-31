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
import java.util.ArrayList;
import java.util.List;

public class ClaimDAO {

    public List<Object[]> getAllClaims() throws SQLException {

        List<Object[]> claims = new ArrayList<>();

        String sql = """
            SELECT
                cl.claim_ID,
                cl.claim_number,
                CONCAT(c.firstname, ' ', c.surname) AS customer_name,
                p.policy_number,
                cl.date_submitted,
                cl.claim_amount,
                cl.status
            FROM CLAIM cl
            INNER JOIN INSURANCE_POLICY p
                ON cl.policy_id = p.policy_ID
            INNER JOIN CUSTOMER c
                ON p.customer_ID = c.customer_ID
            ORDER BY cl.date_submitted DESC
            """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Object[] row = {
                    rs.getInt("claim_ID"),
                    rs.getString("claim_number"),
                    rs.getString("customer_name"),
                    rs.getString("policy_number"),
                    rs.getTimestamp("date_submitted"),
                    rs.getBigDecimal("claim_amount"),
                    rs.getString("status")
                };

                claims.add(row);
            }
        }

        return claims;

    }

    public List<Object[]> getClaimsByStatus(String status) throws SQLException {

        List<Object[]> claims = new ArrayList<>();

        String sql = """
        SELECT
            cl.claim_ID,
            cl.claim_number,
            CONCAT(c.firstname, ' ', c.surname) AS customer_name,
            p.policy_number,
            cl.date_submitted,
            cl.claim_amount,
            cl.status
        FROM CLAIM cl
        INNER JOIN INSURANCE_POLICY p
            ON cl.policy_id = p.policy_ID
        INNER JOIN CUSTOMER c
            ON p.customer_ID = c.customer_ID
        WHERE cl.status = ?
        ORDER BY cl.date_submitted DESC
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("claim_ID"),
                        rs.getString("claim_number"),
                        rs.getString("customer_name"),
                        rs.getString("policy_number"),
                        rs.getTimestamp("date_submitted"),
                        rs.getBigDecimal("claim_amount"),
                        rs.getString("status")
                    };

                    claims.add(row);
                }
            }
        }

        return claims;
    }

}
