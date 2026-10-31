package ubuntusure.model;
import java.math.BigDecimal; import java.math.RoundingMode; import java.time.LocalDate;
public class PropertyPolicy extends InsurancePolicy {
    private final String propertyAddress, propertyType; private final BigDecimal propertyValue, contentsValue; private final boolean contentsIncluded;
    public PropertyPolicy(String n,int c,LocalDate s,LocalDate e,BigDecimal coverage,PolicyStatus st,String address,String type,BigDecimal value,BigDecimal contents,boolean included){super(n,c,s,e,coverage,st);propertyAddress=address;propertyType=type;propertyValue=value;contentsValue=contents;contentsIncluded=included;}
    @Override public String getProductType(){return "PROPERTY";}
    @Override public BigDecimal calculateAnnualPremium(){BigDecimal rate=propertyType.equals("Residential")?new BigDecimal("0.015"):propertyType.equals("Commercial")?new BigDecimal("0.025"):null;if(rate==null)throw new IllegalArgumentException("Invalid property type");BigDecimal total=propertyValue.multiply(rate);if(contentsIncluded)total=total.add(contentsValue.multiply(new BigDecimal("0.01")));return total.setScale(2,RoundingMode.HALF_UP);}
}
