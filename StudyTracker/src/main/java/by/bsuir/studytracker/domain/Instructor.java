package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class Instructor {
    private int instructorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password_hash;

    public Instructor(int instructorId, String firstName, String lastName, String email, String phoneNumber, String password_hash) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password_hash = password_hash;
    }

    public Instructor() {

    }

    public Instructor(String firstName, String lastName, String email, String phoneNumber, String password_hash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password_hash = password_hash;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instructor that = (Instructor) o;

        if (instructorId != that.instructorId) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        return Objects.equals(password_hash, that.password_hash);
    }

    @Override
    public int hashCode() {
        int result = instructorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (password_hash != null ? password_hash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password_hash='" + password_hash + '\'' +
                '}';
    }
}
