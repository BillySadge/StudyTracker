package by.bsuir.studytracker.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Assignment {
    private int assignmentId;
    private int courseId;
    private String assignmentName;
    private String assignmentDescription;
    private Instant assignmentDueDate;
    private BigDecimal totalPoints;

    public Assignment(int assignmentId, int courseId, String assignmentName, String assignmentDescription,
                      Instant assignmentDueDate, BigDecimal totalPoints) {
        this.assignmentId = assignmentId;
        this.courseId = courseId;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentDueDate = assignmentDueDate;
        this.totalPoints = totalPoints;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public Instant getAssignmentDueDate() {
        return assignmentDueDate;
    }

    public void setAssignmentDueDate(Instant assignmentDueDate) {
        this.assignmentDueDate = assignmentDueDate;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment that)) return false;
        return assignmentId == that.assignmentId && courseId == that.courseId && Objects.equals(assignmentName, that.assignmentName) && Objects.equals(assignmentDescription, that.assignmentDescription) && Objects.equals(assignmentDueDate, that.assignmentDueDate) && Objects.equals(totalPoints, that.totalPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, courseId, assignmentName, assignmentDescription, assignmentDueDate, totalPoints);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", courseId=" + courseId +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", assignmentDueDate=" + assignmentDueDate +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
