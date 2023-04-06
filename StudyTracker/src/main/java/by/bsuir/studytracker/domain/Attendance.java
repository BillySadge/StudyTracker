package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class Attendance {
    private int attendanceId;
    private int studentId;
    private int courseId;
    private Instant attendanceDate;
    private int attendanceStatus;

    public Attendance(int attendanceId, int studentId, int courseId, Instant attendanceDate, int attendanceStatus) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.attendanceDate = attendanceDate;
        this.attendanceStatus = attendanceStatus;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
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

    public Instant getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Instant attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance that)) return false;
        return attendanceId == that.attendanceId && studentId == that.studentId && courseId == that.courseId && attendanceStatus == that.attendanceStatus && Objects.equals(attendanceDate, that.attendanceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceId, studentId, courseId, attendanceDate, attendanceStatus);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", attendanceDate=" + attendanceDate +
                ", attendanceStatus=" + attendanceStatus +
                '}';
    }
}
