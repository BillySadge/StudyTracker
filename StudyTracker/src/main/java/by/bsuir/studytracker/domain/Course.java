package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private Instant startDate;
    private Instant endDate;
    private int instructorId;
    private String courseCode;
    private int departmentId;
    private int courseMaterialsId;

    public Course(int courseId, String courseName, String courseDescription, Instant startDate, Instant endDate,
                  int instructorId, String courseCode, int departmentId, int courseMaterialsId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructorId = instructorId;
        this.courseCode = courseCode;
        this.departmentId = departmentId;
        this.courseMaterialsId = courseMaterialsId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getCourseMaterialsId() {
        return courseMaterialsId;
    }

    public void setCourseMaterialsId(int courseMaterialsId) {
        this.courseMaterialsId = courseMaterialsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return courseId == course.courseId && instructorId == course.instructorId && departmentId == course.departmentId && courseMaterialsId == course.courseMaterialsId && Objects.equals(courseName, course.courseName) && Objects.equals(courseDescription, course.courseDescription) && Objects.equals(startDate, course.startDate) && Objects.equals(endDate, course.endDate) && Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseDescription, startDate, endDate, instructorId, courseCode, departmentId, courseMaterialsId);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", instructorId=" + instructorId +
                ", courseCode='" + courseCode + '\'' +
                ", departmentId=" + departmentId +
                ", courseMaterialsId=" + courseMaterialsId +
                '}';
    }
}
