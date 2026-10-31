package ubuntusure.model;
import java.math.BigDecimal; import java.time.LocalDate;
public class HealthPolicy extends InsurancePolicy {
    private final String plan; private final int dependants;
    public HealthPolicy(String n,int c,LocalDate s,LocalDate e,BigDecimal coverage,PolicyStatus st,String plan,int dependants){super(n,c,s,e,coverage,st);this.plan=plan;this.dependants=dependants;}
    @Override public String getProductType(){return "HEALTH";}
    @Override public BigDecimal calculateAnnualPremium(){BigDecimal base=switch(plan){case "Basic"->new BigDecimal("3000");case "Standard"->new BigDecimal("5000");case "Premium"->new BigDecimal("8000");default->throw new IllegalArgumentException("Invalid health plan");};if(dependants<0)throw new IllegalArgumentException("Dependants cannot be negative");return base.add(new BigDecimal("1000").multiply(BigDecimal.valueOf(dependants))).setScale(2);}
}
