package by.bsuir.studytracker.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Exam {
    private int examId;
    private int courseId;

    private String examName;

    private BigDecimal totalPoints;
    private BigDecimal duration;
    private Instant examDate;

    public Exam(int examId, int courseId, String examName, BigDecimal totalPoints, BigDecimal duration, Instant examDate) {
        this.examId = examId;
        this.courseId = courseId;
        this.examName = examName;
        this.totalPoints = totalPoints;
        this.duration = duration;
        this.examDate = examDate;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public Instant getExamDate() {
        return examDate;
    }

    public void setExamDate(Instant examDate) {
        this.examDate = examDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam exam)) return false;
        return examId == exam.examId && courseId == exam.courseId && Objects.equals(examName, exam.examName) && Objects.equals(totalPoints, exam.totalPoints) && Objects.equals(duration, exam.duration) && Objects.equals(examDate, exam.examDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, courseId, examName, totalPoints, duration, examDate);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", courseId=" + courseId +
                ", examName='" + examName + '\'' +
                ", totalPoints=" + totalPoints +
                ", duration=" + duration +
                ", examDate=" + examDate +
                '}';
    }
}
