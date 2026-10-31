package ubuntusure.model;
import java.time.LocalDate;
public record Customer(int id, String firstName, String surname, String nationalId, LocalDate dateOfBirth, String gender, String phone, String email, String address) {
    public String fullName() { return firstName + " " + surname; }
}
