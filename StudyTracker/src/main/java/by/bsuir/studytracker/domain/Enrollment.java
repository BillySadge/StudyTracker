package by.bsuir.studytracker.domain;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private Instant enrollmentDate;
    private String enrollmentStatus;

    public Enrollment(int enrollmentId, int studentId, int courseId, Instant enrollmentDate, String enrollmentStatus) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
    }

    public Enrollment(int studentId, int courseId, Instant enrollmentDate, String enrollmentStatus) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
    }

    public Enrollment() {

    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Instant getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Instant enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment that)) return false;
        return enrollmentId == that.enrollmentId && studentId == that.studentId && courseId == that.courseId && enrollmentStatus == that.enrollmentStatus && Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentId, studentId, courseId, enrollmentDate, enrollmentStatus);
    }

    @Override
    public String toString() {
        return "enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                ", enrollmentStatus=" + enrollmentStatus +
                '}';
    }
}
