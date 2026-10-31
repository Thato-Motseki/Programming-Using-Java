package ubuntusure.util;
import java.math.BigDecimal; import java.time.LocalDate;
public final class Validation {
 private Validation(){}
 public static String required(String value,String label){if(value==null||value.trim().isEmpty())throw new IllegalArgumentException(label+" is required.");return value.trim();}
 public static BigDecimal positiveMoney(String value,String label){try{BigDecimal n=new BigDecimal(required(value,label));if(n.signum()<=0)throw new IllegalArgumentException(label+" must be greater than zero.");return n.setScale(2,java.math.RoundingMode.HALF_UP);}catch(NumberFormatException e){throw new IllegalArgumentException(label+" must be a valid monetary amount.");}}
 public static void dates(LocalDate start,LocalDate end){if(start==null||end==null)throw new IllegalArgumentException("Policy start and end dates are required.");if(start.isAfter(end))throw new IllegalArgumentException("Start date cannot be after end date.");}
}
