import java.io.Serializable;
import java.time.LocalDate;
enum Gender {
    MALE, FEMALE, OTHER
}


public class User implements Serializable {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final double salary;
    private final Gender gender;
    private final String division;
    private final String position;

    public User(String firstName, String lastName, LocalDate birthDate, double salary, Gender gender, String division, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
        this.division = division;
        this.position = position;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getName() + ", Birth: " + birthDate + ", Salary: $" + salary + ", Gender: " + gender + ", Division: " + division + ", Position: " + position;
    }
}