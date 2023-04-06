package by.bsuir.studytracker.domain;

import java.util.Objects;

public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String idNumber;
    private String completeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String passwordHash;
    private int account_status;

    public Student(int studentId, String lastName, String firstName, String idNumber, String completeAddress,
                   String phoneNumber, String emailAddress, String password, int account_status) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.completeAddress = completeAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passwordHash = password;
        this.account_status = account_status;
    }

    public Student(String lastName, String firstName, String idNumber, String completeAddress, String phoneNumber,
                   String emailAddress, String password, int account_status) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.completeAddress = completeAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passwordHash = password;
        this.account_status = account_status;
    }

    public Student(){}

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = password;
    }

    public int getAccount_status() {
        return account_status;
    }

    public void setAccount_status(int account_status) {
        this.account_status = account_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return studentId == student.studentId && account_status == student.account_status && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(idNumber, student.idNumber) && Objects.equals(completeAddress, student.completeAddress) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(emailAddress, student.emailAddress) && Objects.equals(passwordHash, student.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, lastName, firstName, idNumber, completeAddress, phoneNumber, emailAddress, passwordHash, account_status);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", completeAddress='" + completeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + passwordHash + '\'' +
                ", account_status=" + account_status +
                '}';
    }
}
