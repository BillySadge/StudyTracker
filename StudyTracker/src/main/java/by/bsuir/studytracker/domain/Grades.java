package by.bsuir.studytracker.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Grades {
    private int gradeId;
    private int studentId;
    private int assignmentId;
    private BigDecimal grade;
    private Instant completionDate;
    private String feedback;

    public Grades(int gradeId, int studentId, int assignmentId, BigDecimal grade, Instant completionDate, String feedback) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.grade = grade;
        this.completionDate = completionDate;
        this.feedback = feedback;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public Instant getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Instant completionDate) {
        this.completionDate = completionDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grades grades = (Grades) o;

        if (gradeId != grades.gradeId) return false;
        if (studentId != grades.studentId) return false;
        if (assignmentId != grades.assignmentId) return false;
        if (!Objects.equals(grade, grades.grade)) return false;
        if (!Objects.equals(completionDate, grades.completionDate))
            return false;
        return Objects.equals(feedback, grades.feedback);
    }

    @Override
    public int hashCode() {
        int result = gradeId;
        result = 31 * result + studentId;
        result = 31 * result + assignmentId;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (completionDate != null ? completionDate.hashCode() : 0);
        result = 31 * result + (feedback != null ? feedback.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "gradeId=" + gradeId +
                ", studentId=" + studentId +
                ", assignmentId=" + assignmentId +
                ", grade=" + grade +
                ", completionDate=" + completionDate +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
