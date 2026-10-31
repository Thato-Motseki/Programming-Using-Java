package ubuntusure.model;
import java.math.BigDecimal; import java.math.RoundingMode; import java.time.LocalDate;
public class LifePolicy extends InsurancePolicy {
    private final int age; private final String occupation, beneficiaryName, beneficiaryContact;
    public LifePolicy(String n,int c,LocalDate s,LocalDate e,BigDecimal coverage,PolicyStatus st,int age,String occupation,String beneficiaryName,String beneficiaryContact){super(n,c,s,e,coverage,st);this.age=age;this.occupation=occupation;this.beneficiaryName=beneficiaryName;this.beneficiaryContact=beneficiaryContact;}
    @Override public String getProductType(){return "LIFE";}
    @Override public BigDecimal calculateAnnualPremium(){if(age<18||age>65)throw new IllegalArgumentException("Life policy age must be 18–65");String r=age<=30?"0.01":age<=40?"0.015":age<=50?"0.02":age<=60?"0.03":"0.04";return coverageAmount.multiply(new BigDecimal(r)).setScale(2,RoundingMode.HALF_UP);}
    public String getBeneficiaryName(){return beneficiaryName;} public String getBeneficiaryContact(){return beneficiaryContact;}
}
