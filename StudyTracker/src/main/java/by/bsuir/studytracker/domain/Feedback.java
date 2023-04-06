package by.bsuir.studytracker.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Feedback {
    private int feedbackId;
    private int instructorId;
    private int assignmentId;
    private int studentId;
    private Instant dateCreated;
    private Instant dateModified;
    private BigDecimal feedbackRating;
    private String feedbackText;
    private String additionalNotes;

    public Feedback(int feedbackId, int instructorId, int assignmentId, int studentId, Instant dateCreated,
                    Instant dateModified, BigDecimal feedbackRating, String feedbackText, String additionalNotes) {
        this.feedbackId = feedbackId;
        this.instructorId = instructorId;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.feedbackRating = feedbackRating;
        this.feedbackText = feedbackText;
        this.additionalNotes = additionalNotes;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public BigDecimal getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(BigDecimal feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback feedback)) return false;
        return feedbackId == feedback.feedbackId && instructorId == feedback.instructorId && assignmentId == feedback.assignmentId && studentId == feedback.studentId && Objects.equals(dateCreated, feedback.dateCreated) && Objects.equals(dateModified, feedback.dateModified) && Objects.equals(feedbackRating, feedback.feedbackRating) && Objects.equals(feedbackText, feedback.feedbackText) && Objects.equals(additionalNotes, feedback.additionalNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId, instructorId, assignmentId, studentId, dateCreated, dateModified, feedbackRating, feedbackText, additionalNotes);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", instructorId=" + instructorId +
                ", assignmentId=" + assignmentId +
                ", studentId=" + studentId +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", feedbackRating=" + feedbackRating +
                ", feedbackText='" + feedbackText + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }
}
