package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private String courseCode;

    public Course(int courseId, String courseName, String courseDescription, String courseCode) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
    }

    public Course() {

    }

    public Course(String courseName, String courseDescription, String courseCode) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (!Objects.equals(courseName, course.courseName)) return false;
        if (!Objects.equals(courseDescription, course.courseDescription))
            return false;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseDescription != null ? courseDescription.hashCode() : 0);
        result = 31 * result + (courseCode != null ? courseCode.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
