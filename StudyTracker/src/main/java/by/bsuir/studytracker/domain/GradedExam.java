package by.bsuir.studytracker.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class GradedExam {
    private int gradedExamId;
    private int examId;
    private int studentId;
    private BigDecimal grade;
    private Instant completionDate;
    private String feedback;


    public GradedExam(int gradedExamId, int examId, int studentId, BigDecimal grade, Instant completionDate, String feedback) {
        this.gradedExamId = gradedExamId;
        this.examId = examId;
        this.studentId = studentId;
        this.grade = grade;
        this.completionDate = completionDate;
        this.feedback = feedback;
    }

    public int getGradedExamId() {
        return gradedExamId;
    }

    public void setGradedExamId(int gradedExamId) {
        this.gradedExamId = gradedExamId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        if (!(o instanceof GradedExam that)) return false;
        return gradedExamId == that.gradedExamId && examId == that.examId && studentId == that.studentId && Objects.equals(grade, that.grade) && Objects.equals(completionDate, that.completionDate) && Objects.equals(feedback, that.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradedExamId, examId, studentId, grade, completionDate, feedback);
    }

    @Override
    public String toString() {
        return "GradedExam{" +
                "gradedExamId=" + gradedExamId +
                ", examId=" + examId +
                ", studentId=" + studentId +
                ", grade=" + grade +
                ", completionDate=" + completionDate +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
