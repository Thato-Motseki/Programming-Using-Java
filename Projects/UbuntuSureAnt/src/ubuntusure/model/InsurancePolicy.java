package ubuntusure.model;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Common policy contract. Product subclasses own their premium formula. */
public abstract class InsurancePolicy {
    protected int id; protected String policyNumber; protected int customerId; protected LocalDate startDate, endDate;
    protected BigDecimal coverageAmount; protected PolicyStatus status;
    protected InsurancePolicy(String policyNumber, int customerId, LocalDate startDate, LocalDate endDate, BigDecimal coverageAmount, PolicyStatus status) {
        this.policyNumber=policyNumber; this.customerId=customerId; this.startDate=startDate; this.endDate=endDate; this.coverageAmount=coverageAmount; this.status=status;
    }
    public abstract String getProductType();
    public abstract BigDecimal calculateAnnualPremium();
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getPolicyNumber(){return policyNumber;} public int getCustomerId(){return customerId;}
    public LocalDate getStartDate(){return startDate;} public LocalDate getEndDate(){return endDate;}
    public BigDecimal getCoverageAmount(){return coverageAmount;} public PolicyStatus getStatus(){return status;}
    public void setStatus(PolicyStatus status){this.status=status;}
}
