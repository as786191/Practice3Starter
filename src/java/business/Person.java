package business;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * INFO2514
 * @author fssco
 */
public class Person implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer employeeID;
    private LocalDate birthDate;
    private LocalDate hireDate;

    public Person() {}

    public Person(int employeeId, String firstName, String middleName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        this.employeeID = employeeId;  
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
