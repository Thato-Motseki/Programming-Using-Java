/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ubuntusure.dao;

import ubuntusure.config.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClaimAssessmentDAO {

    public void saveAssessment(
            int claimID,
            int assessedByUserID,
            String decision,
            BigDecimal approvedAmount,
            String assessmentNotes,
            String rejectionReason) throws SQLException {

        String insertAssessmentSQL = """
            INSERT INTO CLAIM_ASSESSMENT
                (claim_ID, assessed_by_user_id, decision,
                 approved_amount, assessment_notes, rejection_reason)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        String updateClaimSQL = """
            UPDATE CLAIM
            SET status = ?
            WHERE claim_ID = ?
            """;

        try (Connection conn = DatabaseConnection.getConnection()) {

            conn.setAutoCommit(false);

            try {
                try (PreparedStatement stmt =
                        conn.prepareStatement(insertAssessmentSQL)) {

                    stmt.setInt(1, claimID);
                    stmt.setInt(2, assessedByUserID);
                    stmt.setString(3, decision);

                    if (approvedAmount == null) {
                        stmt.setNull(4, java.sql.Types.DECIMAL);
                    } else {
                        stmt.setBigDecimal(4, approvedAmount);
                    }

                    stmt.setString(5, assessmentNotes);
                    stmt.setString(6, rejectionReason);

                    stmt.executeUpdate();
                }

                try (PreparedStatement stmt =
                        conn.prepareStatement(updateClaimSQL)) {

                    stmt.setString(1, decision);
                    stmt.setInt(2, claimID);

                    int rowsUpdated = stmt.executeUpdate();

                    if (rowsUpdated == 0) {
                        throw new SQLException("Claim not found.");
                    }
                }

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;

            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
