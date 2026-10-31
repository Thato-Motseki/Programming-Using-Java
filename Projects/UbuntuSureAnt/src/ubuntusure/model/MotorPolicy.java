package ubuntusure.model;
import java.math.BigDecimal; import java.math.RoundingMode; import java.time.LocalDate;
public class MotorPolicy extends InsurancePolicy {
    private final String registration, make, model, vehicleType, coverType; private final int year; private final BigDecimal vehicleValue;
    public MotorPolicy(String n,int c,LocalDate s,LocalDate e,BigDecimal coverage,PolicyStatus st,String registration,String make,String model,int year,BigDecimal value,String vehicleType,String coverType){super(n,c,s,e,coverage,st);this.registration=registration;this.make=make;this.model=model;this.year=year;this.vehicleValue=value;this.vehicleType=vehicleType;this.coverType=coverType;}
    @Override public String getProductType(){return "MOTOR";}
    @Override public BigDecimal calculateAnnualPremium(){String key=vehicleType+"|"+coverType; String rate=switch(key){case "Motorcycle|Third Party"->"0.020";case "Motorcycle|Comprehensive"->"0.040";case "Private Car|Third Party"->"0.025";case "Private Car|Comprehensive"->"0.050";case "Minibus|Third Party"->"0.030";case "Minibus|Comprehensive"->"0.060";case "Truck|Third Party"->"0.035";case "Truck|Comprehensive"->"0.070";default->throw new IllegalArgumentException("Unsupported vehicle/cover combination");};return vehicleValue.multiply(new BigDecimal(rate)).setScale(2,RoundingMode.HALF_UP);}
    public String getRegistration(){return registration;} public BigDecimal getVehicleValue(){return vehicleValue;} public String getVehicleType(){return vehicleType;} public String getCoverType(){return coverType;}
}
