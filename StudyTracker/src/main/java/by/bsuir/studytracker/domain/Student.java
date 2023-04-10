package by.bsuir.studytracker.domain;

import java.util.Objects;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String cardIdNumber;
    private String passwordHash;

    public Student(int studentId, String firstName, String lastName, String emailAddress, String phoneNumber, String cardIdNumber, String passwordHash) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.cardIdNumber = cardIdNumber;
        this.passwordHash = passwordHash;
    }


    public Student(String firstName, String lastName, String emailAddress, String phoneNumber, String cardIdNumber, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.cardIdNumber = cardIdNumber;
        this.passwordHash = passwordHash;
    }

    public Student(){}
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardIdNumber() {
        return cardIdNumber;
    }

    public void setCardIdNumber(String cardIdNumber) {
        this.cardIdNumber = cardIdNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (!Objects.equals(firstName, student.firstName)) return false;
        if (!Objects.equals(lastName, student.lastName)) return false;
        if (!Objects.equals(emailAddress, student.emailAddress))
            return false;
        if (!Objects.equals(phoneNumber, student.phoneNumber)) return false;
        if (!Objects.equals(cardIdNumber, student.cardIdNumber))
            return false;
        return Objects.equals(passwordHash, student.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (cardIdNumber != null ? cardIdNumber.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardIdNumber='" + cardIdNumber + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
