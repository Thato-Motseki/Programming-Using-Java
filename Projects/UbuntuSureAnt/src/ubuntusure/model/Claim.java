package ubuntusure.model;
import java.math.BigDecimal; import java.time.LocalDate;
public record Claim(int id,String claimNumber,int policyId,int customerId,LocalDate dateSubmitted,BigDecimal claimAmount,String description,ClaimStatus status,BigDecimal approvedAmount,String rejectionReason) {}
