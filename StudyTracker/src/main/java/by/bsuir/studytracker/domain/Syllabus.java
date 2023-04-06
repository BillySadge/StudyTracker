package by.bsuir.studytracker.domain;
import java.time.Instant;
import java.util.Objects;

public class Syllabus {
    private int syllabus_id;
    private int course_id;
    private int instructor_id;
    private String title;
    private String description;
    private String courseGoals;
    private String courseTopics;
    private String textbook;
    private String supplementaryMaterials;
    private String gradingPolicy;
    private String attendancePolicy;
    private String courseSchedule;
    private Instant dateCreated;
    private Instant dateModified;

    public Syllabus(int syllabus_id, int course_id, int instructor_id, String title, String description,
                    String courseGoals, String courseTopics, String textbook, String supplementaryMaterials,
                    String gradingPolicy, String attendancePolicy, String courseSchedule, Instant dateCreated,
                    Instant dateModified) {
        this.syllabus_id = syllabus_id;
        this.course_id = course_id;
        this.instructor_id = instructor_id;
        this.title = title;
        this.description = description;
        this.courseGoals = courseGoals;
        this.courseTopics = courseTopics;
        this.textbook = textbook;
        this.supplementaryMaterials = supplementaryMaterials;
        this.gradingPolicy = gradingPolicy;
        this.attendancePolicy = attendancePolicy;
        this.courseSchedule = courseSchedule;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getSyllabus_id() {
        return syllabus_id;
    }

    public void setSyllabus_id(int syllabus_id) {
        this.syllabus_id = syllabus_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseGoals() {
        return courseGoals;
    }

    public void setCourseGoals(String courseGoals) {
        this.courseGoals = courseGoals;
    }

    public String getCourseTopics() {
        return courseTopics;
    }

    public void setCourseTopics(String courseTopics) {
        this.courseTopics = courseTopics;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String getSupplementaryMaterials() {
        return supplementaryMaterials;
    }

    public void setSupplementaryMaterials(String supplementaryMaterials) {
        this.supplementaryMaterials = supplementaryMaterials;
    }

    public String getGradingPolicy() {
        return gradingPolicy;
    }

    public void setGradingPolicy(String gradingPolicy) {
        this.gradingPolicy = gradingPolicy;
    }

    public String getAttendancePolicy() {
        return attendancePolicy;
    }

    public void setAttendancePolicy(String attendancePolicy) {
        this.attendancePolicy = attendancePolicy;
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Instant getDateModified() {
        return dateModified;
    }

    public void setDateModified(Instant dateModified) {
        this.dateModified = dateModified;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Syllabus syllabus = (Syllabus) o;
        return syllabus_id == syllabus.syllabus_id && course_id == syllabus.course_id
                && instructor_id == syllabus.instructor_id && Objects.equals(title, syllabus.title)
                && Objects.equals(description, syllabus.description)
                && Objects.equals(courseGoals, syllabus.courseGoals)
                && Objects.equals(courseTopics, syllabus.courseTopics)
                && Objects.equals(textbook, syllabus.textbook)
                && Objects.equals(supplementaryMaterials, syllabus.supplementaryMaterials)
                && Objects.equals(gradingPolicy, syllabus.gradingPolicy)
                && Objects.equals(attendancePolicy, syllabus.attendancePolicy)
                && Objects.equals(courseSchedule, syllabus.courseSchedule)
                && Objects.equals(dateCreated, syllabus.dateCreated)
                && Objects.equals(dateModified, syllabus.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(syllabus_id, course_id, instructor_id, title, description, courseGoals, courseTopics,
                textbook, supplementaryMaterials, gradingPolicy, attendancePolicy, courseSchedule, dateCreated,
                dateModified);
    }


    @Override
    public String toString() {
        return "Syllabus{" +
                "syllabus_id=" + syllabus_id +
                ", course_id=" + course_id +
                ", instructor_id=" + instructor_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", courseGoals='" + courseGoals + '\'' +
                ", courseTopics='" + courseTopics + '\'' +
                ", textbook='" + textbook + '\'' +
                ", supplementaryMaterials='" + supplementaryMaterials + '\'' +
                ", gradingPolicy='" + gradingPolicy + '\'' +
                ", attendancePolicy='" + attendancePolicy + '\'' +
                ", courseSchedule='" + courseSchedule + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
